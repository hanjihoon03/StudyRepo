package com.repository;


import com.base.UploadFile;
import com.custom.UploadApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadApiRepository extends JpaRepository<UploadFile, Long>, UploadApiRepositoryCustom {
}
