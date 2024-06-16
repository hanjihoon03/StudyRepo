package com.project.repository;

import com.project.UploadFile;
import com.project.custom.FileRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<UploadFile, Long>, FileRepositoryCustom {
}
