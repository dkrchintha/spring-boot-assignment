package com.dkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dkr.entity.FileRepo;

@Repository
public interface FileRepository extends JpaRepository<FileRepo, String> {

}
