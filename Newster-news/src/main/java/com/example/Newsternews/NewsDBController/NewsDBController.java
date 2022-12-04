package com.example.Newsternews.NewsDBController;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.newsRepository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedList;

@RestController
public class NewsDBController {
    @Autowired
    NewsRepository newsRepository;

    @Scheduled(cron = "0 0 7,11,17 * * ?")
    public void saveNewsArticles() throws IOException {
        LinkedList<News> result1 = API.SearchNews(Keys.SEARCHTERM1);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM2);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM3);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM4);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM5);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM6);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM7);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM8);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM9);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Keys.SEARCHTERM1);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }
    }

}
