package com.repository;

import com.base.UploadFile;
import com.custom.FileRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<UploadFile, Long>, FileRepositoryCustom {
}
