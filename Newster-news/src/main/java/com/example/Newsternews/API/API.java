package com.example.Newsternews.API;

import com.example.Newsternews.Keys.Keys;
import com.example.Newsternews.Resources.News;
import com.example.Newsternews.Resources.Topic;
import com.google.gson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

@RestController
@RequestMapping("/wawa")
public class API
{
    //Raw JSON Response
    private static String JSONResponse;

    // pretty-printer for JSON; uses GSON parser to parse and re-serialize
    @SuppressWarnings("deprecation")
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    @GetMapping
    public static LinkedList<News> SearchNews(String searchTerm) throws IOException {

        // construct the search request URL (in the form of URL + query string)
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

        //Linked list is stored as articles
        LinkedList<News> articles = parseThroughAPIResponse(response, searchTerm);

        //Set the raw JSON response for testing
        setJSON(response);

        //Return list of articles
        return articles;

    }

    @SuppressWarnings("deprecation")
    public static LinkedList<News> parseThroughAPIResponse(String APIResponse, String searchTerm)
    {
        //initialize variables
        LinkedList<News> articles = new LinkedList<News>();
        News newsArticle;
        String name, url, description;
        int resultNumber;
        int topic;

        //Assign topics to integer value for easy storage in SQL
        topic = Topic.getSearchTermValue(searchTerm);

        //Parses the JSON to get to where the articles are stored
        JsonElement jelement = new JsonParser().parse(APIResponse);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("value");

        //Loop through each article
        for(resultNumber = 0; resultNumber < Keys.COUNT; resultNumber++)
        {
            try
            {
                //Get return for the article
                jobject = jarray.get(resultNumber).getAsJsonObject();
            }

            //Handles cases where the API does not return correct amount of articles
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("WARN: API did not return correct amount of articles");
                break;
            }

            //Parse the json
            name = jobject.get("name").getAsString();
            url = jobject.get("url").getAsString();
            description = jobject.get("description").getAsString().substring(0, 100) + "...";

            //Get the local date and time
            LocalTime ArizonaNow = LocalTime.now(ZoneId.of("America/Phoenix"));
            String Date = ArizonaNow.toString();

            //Create a News object for each article
            newsArticle = new News(name, Date, url, topic, description);

            //Add the News object to the articles linked list
            articles.add(newsArticle);
        }

        //Return the linked list of articles
        return articles;

    }

    public static void setJSON(String JSON)
    {
        JSONResponse = JSON;
    }

    public static String getJSON()
    {
        return JSONResponse;
    }

}