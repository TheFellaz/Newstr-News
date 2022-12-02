package com.example.Newsternews.DB_CRUD_TEST;

import com.example.Newsternews.Resources.User;
import com.example.Newsternews.SignUpController.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootTest
@EnableJpaRepositories
@Component
public class UserRepositoryTest {
    @Autowired
    private UserRepository memoRepository;

    @Test
    public void UpdateDummies() {
        User memo = new User("Jacob", "hk@nau.edu", "pw");
////        User memo = User.builder()
////                .email("emial@naver.com")
////                .frequency(1)
////                .userName("Jacob")
////                .build();
//
        memoRepository.save(memo);
//        memoRepository.findAll();
    }

}
