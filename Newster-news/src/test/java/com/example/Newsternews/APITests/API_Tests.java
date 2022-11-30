package com.example.Newsternews.APITests;


import com.example.Newsternews.API.API;
import com.example.Newsternews.API.ArticleClass;
import com.example.Newsternews.Keys.Keys;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(JUnit4.class)
public class API_Tests {

    @Test
    public void getAPIReturn() throws Exception
    {
        String testString = API.SearchNews();
        ArticleClass result = API.parsedResponse;

        String url = result.getHead().getUrl();
        String name = result.getHead().getName();
        String description = result.getHead().getDescription();

        //Assert that the API returns a url, name, and description and stores it in the linked list
        assertNotNull(url);
        assertNotNull(name);
        assertNotNull(description);

    }

    @Test
    public void assertCorrectQuery() throws Exception
    {
        String testString = API.SearchNews();

        JsonElement jelement = new JsonParser().parse(testString);
        JsonObject jobject = jelement.getAsJsonObject();
        String testQuery = jobject.get("queryContext").getAsJsonObject().get("originalQuery").getAsString();

        assertEquals(testQuery, Keys.SEARCHTERM);

    }

}