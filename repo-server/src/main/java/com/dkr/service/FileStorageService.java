package com.dkr.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dkr.entity.FileRepo;
import com.dkr.repo.FileRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileRepository fileDBRepository;

	public FileRepo store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileRepo FileDB = new FileRepo(fileName, file.getContentType(), file.getBytes());

		return fileDBRepository.save(FileDB);
	}
	
	@Cacheable(value = "repoCache")
	public FileRepo getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	@Cacheable(value = "repoCache")
	public Stream<FileRepo> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
}