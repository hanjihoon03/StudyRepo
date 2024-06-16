package com.project.repository;


import com.project.UploadFile;
import com.project.custom.UploadApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadApiRepository extends JpaRepository<UploadFile, Long>, UploadApiRepositoryCustom {
}
