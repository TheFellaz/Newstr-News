package com.example.Newsternews.APITests;


import com.example.Newsternews.API.API;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(JUnit4.class)
public class API_Tests {

    @Test
    public void getAPIReturn() throws Exception
    {
        LinkedList<News> result = API.SearchNews(Topic.SEARCHTERM1);

        String url = result.get(0).getNewsUrl();
        String name = result.get(0).getNewsTitle();
        String description = result.get(0).getDesc();

        //Assert that the API returns a url, name, and description and stores it in the linked list
        assertNotNull(url);
        assertNotNull(name);
        assertNotNull(description);

    }

    @Test
    public void assertCorrectQuery() throws Exception
    {
        LinkedList<News> result = API.SearchNews(Topic.SEARCHTERM1);

        String JSONResult = API.getJSON();

        @SuppressWarnings("deprecation")
        JsonElement jelement = new JsonParser().parse(JSONResult);
        JsonObject jobject = jelement.getAsJsonObject();
        String testQuery = jobject.get("queryContext").getAsJsonObject().get("originalQuery").getAsString();

        assertEquals(testQuery, Topic.SEARCHTERM1);
    }

}