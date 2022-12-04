package com.example.Newsternews.newsRepository;

import com.example.Newsternews.Resources.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query(value = "SELECT * FROM news_tb WHERE news_topic = ?1", nativeQuery = true)
    LinkedList<News> findByTopics(int topic);
}
