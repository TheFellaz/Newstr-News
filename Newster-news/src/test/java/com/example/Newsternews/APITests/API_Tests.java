package com.example.Newsternews.APITests;


import com.example.Newsternews.API.API;
import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.News;
import org.junit.Test;
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
        LinkedList<News> result = API.SearchNews(Keys.SEARCHTERM1);

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
        /*
        String testString = API.SearchNews(Keys.SEARCHTERM1);

        JsonElement jelement = new JsonParser().parse(testString);
        JsonObject jobject = jelement.getAsJsonObject();
        String testQuery = jobject.get("queryContext").getAsJsonObject().get("originalQuery").getAsString();

        //TODO: ADD TEST FOR DIFFERENT SEARCHTERM POSSIBILITIES
        assertEquals(testQuery, Keys.SEARCHTERM1);
        */
    }

}