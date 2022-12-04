package com.example.Newsternews.DB_CRUD_Tests;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import com.example.Newsternews.newsRepository.NewsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class newsRepositoryTest {
    @Autowired
    NewsRepository newsRepository;

    @Test
    public void testInsertNews() throws IOException {
        for (int i = 0; i < Topic.SearchTermList.length; i++) {
            LinkedList<News> result = API.SearchNews(Topic.SearchTermList[i]);
            for (int j = 0; j < result.size(); j++) {
                newsRepository.save(result.get(j));
            }
        }

    }

    @Test
    public void getNewsByTopic(){
        List<News> newsList = newsRepository.findByTopics(1);
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println(newsList.get(i).toString());
        }
    }

    @Test
    public void getTime(){
        LocalTime ArizonaNow = LocalTime.now(ZoneId.of("America/Phoenix"));
        int hour = ArizonaNow.getHour();
        System.out.println(hour);
    }

    @Test
    public void tmpTest(){
        for (int i = 0; i < Topic.SearchTermList.length; i++) {
            System.out.println(Topic.SearchTermList[i]);
        }
    }

}
