package com.custom;


import com.apidto.UserLoginIdPwDto;

public interface UserApiRepositoryCustom{
    UserLoginIdPwDto findByNameAndEmail(String name, String email);
}
