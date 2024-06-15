package com.repository;


import com.base.User;
import com.custom.UserApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserApiRepository extends JpaRepository<User, Long>, UserApiRepositoryCustom {

}
