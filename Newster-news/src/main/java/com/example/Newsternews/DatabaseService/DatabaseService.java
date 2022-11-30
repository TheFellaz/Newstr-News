package com.example.Newsternews.DatabaseService;

import com.example.Newsternews.Resources.DBUserData;

public interface DatabaseService {

    DBUserData FindUserByID(long ID);

    //CRUD functionality
    void addUser();
    void updateUser();
    void deleteUser();

}
