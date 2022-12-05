package com.example.Newsternews.Resources;

public class Topic
{
    public static String SEARCHTERM1 = "Business";
    public static String SEARCHTERM2 = "Entertainment_MovieAndTV";
    public static String SEARCHTERM3 = "Entertainment_Music";
    public static String SEARCHTERM4 = "Politics";
    public static String SEARCHTERM5 = "ScienceAndTechnology";
    public static String SEARCHTERM6 = "Sports_NBA";
    public static String SEARCHTERM7 = "Sports_NFL";
    public static String SEARCHTERM8 = "US";
    public static String SEARCHTERM9 = "World";

    public static String[] SearchTermList = {SEARCHTERM1, SEARCHTERM2, SEARCHTERM3, SEARCHTERM4, SEARCHTERM5,
            SEARCHTERM6, SEARCHTERM7, SEARCHTERM8, SEARCHTERM9};

    public static int getSearchTermValue(String searchTerm)
    {
        if (searchTerm.equals(SEARCHTERM1)){
            return 1;
        }else if (searchTerm.equals(SEARCHTERM2)){
            return 2;
        }else if (searchTerm.equals(SEARCHTERM3)){
            return 3;
        }else if (searchTerm.equals(SEARCHTERM4)){
            return 4;
        }else if (searchTerm.equals(SEARCHTERM5)){
            return 5;
        }else if (searchTerm.equals(SEARCHTERM6)){
            return 6;
        }else if (searchTerm.equals(SEARCHTERM7)){
            return 7;
        }else if (searchTerm.equals(SEARCHTERM8)){
            return 8;
        }else{
            return 9;
        }
    }

}
