package com.example.Newsternews.APITests;


import com.example.Newsternews.API.API;
import com.example.Newsternews.API.ArticleClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(JUnit4.class)
public class API_Tests {

    @Test
    public void getAPIReturn() throws Exception
    {
        String testString = API.SearchNews();
        ArticleClass result = API.prettyResponse;

        String url = result.getHead().getUrl();
        String name = result.getHead().getName();
        String description = result.getHead().getDescription();

        assertNotNull(url);
        assertNotNull(name);
        assertNotNull(description);

    }

}