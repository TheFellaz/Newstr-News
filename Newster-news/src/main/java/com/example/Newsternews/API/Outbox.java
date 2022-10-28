package com.example.Newsternews.API;

import java.util.HashMap;

public class Outbox {
    HashMap<String, String> relevantHeaders;
    String jsonResponse;
    Outbox(HashMap<String, String> headers, String json) {
        relevantHeaders = headers;
        jsonResponse = json;

    }

}
