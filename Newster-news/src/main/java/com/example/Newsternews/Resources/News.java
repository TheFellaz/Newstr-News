package com.example.Newsternews.Resources;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NEWS_TB")
public class News {
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
}
