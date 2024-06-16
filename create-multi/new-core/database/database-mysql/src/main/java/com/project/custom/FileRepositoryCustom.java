package com.project.custom;


import com.project.UploadFile;

public interface FileRepositoryCustom {
    UploadFile findByItemId(Long id);
    void deleteFromItemId(Long id);
}
