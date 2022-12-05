package com.example.Newsternews.APITests;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

@RunWith(JUnit4.class)
public class API_Test2 {

    @Test
    public void getAPIReturn() throws Exception {

        LinkedList<News> result = API.SearchNews(Topic.SEARCHTERM1);

        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.toString());

        }

    }

}