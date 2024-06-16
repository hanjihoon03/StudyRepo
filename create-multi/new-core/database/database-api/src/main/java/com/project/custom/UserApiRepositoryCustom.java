package com.project.custom;


import com.project.apidto.UserLoginIdPwDto;

public interface UserApiRepositoryCustom{
    UserLoginIdPwDto findByNameAndEmail(String name, String email);
}
