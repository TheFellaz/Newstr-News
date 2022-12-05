package com.example.Newsternews.NewsDBController;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
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
        LinkedList<News> result1 = API.SearchNews(Topic.SEARCHTERM1);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM2);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM3);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM4);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM5);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM6);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM7);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM8);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM9);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }

        result1 = API.SearchNews(Topic.SEARCHTERM1);
        for (int i = 0; i < result1.size(); i++) {
            newsRepository.save(result1.get(i));
        }
    }

}
