//package com.example.Newsternews.DatabaseService.impl;
//
//import com.example.Newsternews.Resources.DBUserData;
//import com.example.Newsternews.DatabaseController.DataBaseDataAccessObject;
//import com.example.Newsternews.DatabaseService.DatabaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class DatabaseIMPL implements DatabaseService {
//    @Autowired
//    DataBaseDataAccessObject DBDAO;
//
//    @Override
//    public DBUserData FindUserByID(long ID){
//        Optional<DBUserData> opt = DBDAO.findById(ID);
//        if(opt.isPresent())
//            return opt.get();
//        else
//            return null;
//    }
//
//    @Override
//    public void addUser() {
//
//    }
//
//    @Override
//    public void updateUser() {
//
//    }
//
//    @Override
//    public void deleteUser() {
//
//    }
//
//    @Override
//    public void addEmployee(){
//        ArrayList<DBUserData> user = new ArrayList<>();
//        // need front end input
//    }
//
//}
