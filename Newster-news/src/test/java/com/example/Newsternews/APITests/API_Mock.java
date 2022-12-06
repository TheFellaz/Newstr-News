package com.example.Newsternews.APITests;

import com.example.Newsternews.API.API;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class API_Mock {

    @InjectMocks
    API API_mock;

    @Test
    public void mock() throws Exception
    {
        LinkedList<News> result = API_mock.SearchNews(Topic.SEARCHTERM1);

        String url = result.get(0).getNewsUrl();
        String name = result.get(0).getNewsTitle();
        String description = result.get(0).getDesc();

        //Assert that the API returns a url, name, and description and stores it in the linked list
        assertNotNull(url);
        assertNotNull(name);
        assertNotNull(description);
    }

}
