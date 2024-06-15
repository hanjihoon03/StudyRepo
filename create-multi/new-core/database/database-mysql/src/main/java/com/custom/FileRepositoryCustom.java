package com.custom;


import com.base.UploadFile;

public interface FileRepositoryCustom {
    UploadFile findByItemId(Long id);
    void deleteFromItemId(Long id);
}
