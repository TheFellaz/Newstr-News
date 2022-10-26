package com.example.Newsternews.API;

import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.API.ArticleClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.*;

@RestController
@RequestMapping
public class API
{
    //initialize class variables
        //number of articles being received
    static int COUNT = 10;

    // pretty-printer for JSON; uses GSON parser to parse and re-serialize
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }


    @GetMapping
    public static String SearchNews() throws IOException {
        //initialize variables
        String test;

        // construct the search request URL (in the form of URL + query string)
        //added count = 10 in url to control
        URL url = new URL(Keys.ENPOINT + Keys.PATH + "?q=" +  URLEncoder.encode("Microsoft", "UTF-8")
                + "&count=" + COUNT);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", Keys.APIKEY);

        // receive the JSON body
        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        // construct result object for return
        Outbox results = new Outbox(new HashMap<String, String>(), response);

        stream.close();
        System.out.println("response: \n");
        System.out.println(prettify(results.jsonResponse));

        parseThroughAPIResponse(response);
        //System.out.print(test);
        return response;

    }

    //@GetMapping
    public static void parseThroughAPIResponse(String APIResponse)
    {
        //initialize variables
        ArticleClass workingNode = new ArticleClass();
        Scanner scanner = new Scanner(APIResponse);
        String workingString = "";
        String name;
        String url;
        String description;


        //parse through APIResponse, look for "value": [, this is the start of the articles
        Gson g = new Gson();
        ArticleClass test = g.fromJson(APIResponse, ArticleClass.class);
        //loop through COUNT times
            //once in, capture name, url, description in ArticleClass format
        //System.out.print(test.name);
        System.out.println(test.head);
        return;
    }



}
