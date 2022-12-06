package com.example.Newsternews.DB_CRUD_Tests;


import com.example.Newsternews.Resources.User;
import com.example.Newsternews.userRepository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class userRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testInsertUser(){
        IntStream.rangeClosed(1,10).forEach(i -> {

            String name = "name"+i;
            String email = "email"+i;
            String pw = "pw"+i;
            User user = new User(name, email, pw);

            userRepository.save(user);
        });
        System.out.println(userRepository.getClass().getName());
    }

    @Test
    public void testSelect(){
        Long mno = 100L;
//        Optional<User> result = userRepository.findById(mno);
//        System.out.println("================");
//        if(result.isPresent()){
//            User user = result.get();
//            System.out.println(user);
//        }
        User tmpUser = userRepository.findByEmail("email1");
//        System.out.println(userResult.toString());
//        User tmpUser = userRepository.findByEmail("email1");
        System.out.println(tmpUser.toString());
    }

    @Test
    public void testUpdate(){
//        IntStream.rangeClosed(1,10).forEach(i -> {
//            String name = "name"+i;
//            String email = "email"+i;
//            String pw = "pw"+i;
//            User user = new User(name, email, pw);
//            // 저장한다
//            userRepository.save(user);
//        });
//        System.out.println(userRepository.getClass().getName());
//        IntStream.rangeClosed(5,10).forEach(i -> {
//
//            String name = "name2"+i;
//            String email = "email"+i;
//            String pw = "pw2"+i;
//            User user = new User(name, email, pw);
//            // 저장한다
//            userRepository.save(user);
//        });
//        System.out.println(userRepository.getClass().getName());
        User user = new User("kim", "hk486@nau.edu", "password", "topics", 1, "token");
        userRepository.save(user);
    }

    @Test
    public void userFrequencyTest(){
        List<User> userList = userRepository.findByFrequency(0);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

}
