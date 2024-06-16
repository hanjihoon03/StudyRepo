package com.test;


import com.project.User;
import com.project.subdomain.Address;
import com.project.subdomain.Tier;
import com.project.MainWebApplication;
import com.project.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MainWebApplication.class)
public class TestApplication {

    @Autowired
    UserRepository userRepository;

    @Test
    void test1() {
        Address address = new Address("1","1","1");
        User user = new User("1","1",1,"1@1","1",address, Tier.NORMAL);

        User saveUser = userRepository.save(user);

        Assertions.assertThat(user.getAge()).isEqualTo(saveUser.getAge());

    }
}
