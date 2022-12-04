package com.example.Newsternews.DB_CRUD_Tests;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.User;
import com.example.Newsternews.newsRepository.NewsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class newsRepositoryTest {
    @Autowired
    NewsRepository newsRepository;

    @Test
    public void testInsertNews() throws IOException {
        LinkedList<News> result = API.SearchNews(Keys.SEARCHTERM1);
        for (int i = 0; i < result.size(); i++) {
            newsRepository.save(result.get(i));
        }
//        result = API.SearchNews(Keys.SEARCHTERM2);
//        for (int i = 0; i < result.size(); i++) {
//            newsRepository.save(result.get(i));
//        }
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
        for (int i = 0; i < Keys.SearchTermList.length; i++) {
            System.out.println(Keys.SearchTermList[i]);
        }
    }

}
