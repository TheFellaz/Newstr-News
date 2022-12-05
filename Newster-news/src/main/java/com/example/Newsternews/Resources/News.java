package com.example.Newsternews.Resources;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder(toBuilder = true)

@Entity
@Table(name = "news_tb")
public class News {

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", newsTitle='" + newsTitle + '\'' +
                ", date='" + date + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", topic=" + topic +
                ", desc='" + desc + '\'' +
                '}';
    }

    public News(){

    }

    public News(String newsTitle, String date, String newsUrl, int topic, String desc) {
        this.newsTitle = newsTitle;
        this.date = date;
        this.newsUrl = newsUrl;
        this.topic = topic;
        this.desc = desc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id", nullable = false)
    private Long news_id;

    @Column(name = "news_title", nullable = false)
    private String newsTitle;

    @Column(name = "news_date", nullable = false)
    private String date;

    @Column(name = "news_url", nullable = false)
    private String newsUrl;

    @Column(name = "news_topic", nullable = false)
    private int topic;

    @Column(name = "news_desc", nullable = false)
    private String desc;

    public Long getNews_id() {
        return news_id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNews_id(Long news_id) {
        this.news_id = news_id;
    }

    public void insert(String title, String description, String url)
    {
        setNewsTitle(title);
        setDesc(description);
        setNewsUrl(url);
    }
}
