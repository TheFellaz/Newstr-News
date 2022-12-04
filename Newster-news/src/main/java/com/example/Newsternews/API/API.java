package com.example.Newsternews.API;

import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.News;
import com.google.gson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;


import java.io.*;

@RestController
@RequestMapping("/wawa")
public class API
{
    // pretty-printer for JSON; uses GSON parser to parse and re-serialize
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    @GetMapping
    public static LinkedList<News> SearchNews(String searchTerm) throws IOException {

        // construct the search request URL (in the form of URL + query string)
        //added count = 10 in url to control
        URL url = new URL(Keys.ENDPOINT + Keys.PATH + "?q=" +  URLEncoder.encode(searchTerm, "UTF-8")
                + "&count=" + Keys.COUNT);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", Keys.APIKEY);

        // receive the JSON body
        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        // construct result object for return
        Outbox results = new Outbox(new HashMap<String, String>(), response);

        stream.close();

        //Linked list is stored as parsedResponse
        LinkedList<News> articles = parseThroughAPIResponse(response, searchTerm);

        return articles;

    }

    public static LinkedList<News> parseThroughAPIResponse(String APIResponse, String searchTerm)
    {
        //initialize variables
        LinkedList<News> articles = new LinkedList<News>();
        News newsArticle;
        String name, url, description;
        int resultNumber;
        int topic;

        if (searchTerm.equals("Business")){
            topic = 1;
        }else if (searchTerm.equals("Entertainment_MovieAndTV")){
            topic = 2;
        }else if (searchTerm.equals("Entertainment_Music")){
            topic = 3;
        }else if (searchTerm.equals("Politics")){
            topic = 4;
        }else if (searchTerm.equals("ScienceAndTechnology")){
            topic = 5;
        }else if (searchTerm.equals("Sports_NBA")){
            topic = 6;
        }else if (searchTerm.equals("Sports_NFL")){
            topic = 7;
        }else if (searchTerm.equals("US")){
            topic = 8;
        }else{
            topic = 9;
        }

        JsonElement jelement = new JsonParser().parse(APIResponse);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("value");

        for(resultNumber = 0; resultNumber < Keys.COUNT; resultNumber++)
        {
            try
            {
                //Get return for the first article
                jobject = jarray.get(resultNumber).getAsJsonObject();
            }

            //Handles cases where the API does not return correct amount of articles
            //TODO: Create better solution (Possibly limit of 8?)
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("WARN: API did not return correct amount of articles");
                break;
            }

            //Parse the json
            name = jobject.get("name").getAsString();
            url = jobject.get("url").getAsString();
            description = jobject.get("description").getAsString().substring(0, 100) + "...";
            LocalTime ArizonaNow = LocalTime.now(ZoneId.of("America/Phoenix"));
            String Date = ArizonaNow.toString();
            newsArticle = new News(name, Date, url, topic, description);
            articles.add(newsArticle);
        }

        return articles;

    }

}