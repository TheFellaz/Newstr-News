package com.example.Newsternews.userRepository;


import com.example.Newsternews.Resources.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM user_tb", nativeQuery = true)
    List<User> findAll();

    @Query(value = "SELECT * FROM user_tb WHERE user_email = ?1", nativeQuery = true)
    List<User> findByEmail(String email);

//    @Query(value = "")
}