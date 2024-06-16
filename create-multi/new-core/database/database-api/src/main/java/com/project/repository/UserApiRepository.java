package com.project.repository;


import com.project.User;
import com.project.custom.UserApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApiRepository extends JpaRepository<User, Long>, UserApiRepositoryCustom {

}
