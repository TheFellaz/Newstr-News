package com.example.Newsternews.Resources;

public class RegisterUser extends User {
    //all normal shit from user (extends)

    //add every single topic



//    public RegisterUser(boolean business,
//                        boolean entertainment_MovieAndTV,
//                        boolean entertainment_Music,
//                        boolean politics,
//                        boolean scienceAndTechnology,
//                        boolean sports_NBA,
//                        boolean sports_NFL,
//                        boolean US,
//                        boolean world) {
//        Business = business;
//        Entertainment_MovieAndTV = entertainment_MovieAndTV;
//        Entertainment_Music = entertainment_Music;
//        Politics = politics;
//        ScienceAndTechnology = scienceAndTechnology;
//        Sports_NBA = sports_NBA;
//        Sports_NFL = sports_NFL;
//        this.US = US;
//        World = world;
//    }

    boolean Business;
    boolean Entertainment_MovieAndTV;
    boolean Entertainment_Music;
    boolean Politics;
    boolean ScienceAndTechnology;
    boolean Sports_NBA;
    boolean Sports_NFL;
    boolean US;
    boolean World;


//    public RegisterUser() {
//        super();
//        Business = false;
//        Entertainment_MovieAndTV = false;
//        Entertainment_Music = false;
//        Politics = false;
//        ScienceAndTechnology = false;
//        Sports_NBA = false;
//        Sports_NFL = false;
//        US = false;
//        World = false;
//    }


    @Override
    public String toString() {
        return "RegisterUser{" +
                "Business=" + Business +
                ", Entertainment_MovieAndTV=" + Entertainment_MovieAndTV +
                ", Entertainment_Music=" + Entertainment_Music +
                ", Politics=" + Politics +
                ", ScienceAndTechnology=" + ScienceAndTechnology +
                ", Sports_NBA=" + Sports_NBA +
                ", Sports_NFL=" + Sports_NFL +
                ", US=" + US +
                ", World=" + World +
                '}';
    }

    public RegisterUser(String userName,
                        String email,
                        String pw,
                        String topics,
                        int frequency,
                        String token,
                        boolean Business,
                        boolean Entertainment_MovieAndTV,
                        boolean Entertainment_Music,
                        boolean Politics,
                        boolean ScienceAndTechnology,
                        boolean Sports_NBA,
                        boolean Sports_NFL,
                        boolean US,
                        boolean World) {
        super(userName, email, pw, topics, frequency, token);
        this.Business = Business;
        this.Entertainment_MovieAndTV = Entertainment_MovieAndTV;
        this.Entertainment_Music = Entertainment_Music;
        this.Politics = Politics;
        this.ScienceAndTechnology = ScienceAndTechnology;
        this.Sports_NBA = Sports_NBA;
        this.Sports_NFL = Sports_NFL;
        this.US = US;
        this.World = World;
    }

    public boolean isBusiness() {
        return Business;
    }

    public boolean isEntertainment_MovieAndTV() {
        return Entertainment_MovieAndTV;
    }

    public boolean isEntertainment_Music() {
        return Entertainment_Music;
    }

    public boolean isPolitics() {
        return Politics;
    }

    public boolean isScienceAndTechnology() {
        return ScienceAndTechnology;
    }

    public boolean isSports_NBA() {
        return Sports_NBA;
    }

    public boolean isSports_NFL() {
        return Sports_NFL;
    }

    public boolean isUS() {
        return US;
    }

    public boolean isWorld() {
        return World;
    }

    public void setBusiness(boolean business) {
        Business = business;
    }

    public void setEntertainment_MovieAndTV(boolean entertainment_MovieAndTV) {
        Entertainment_MovieAndTV = entertainment_MovieAndTV;
    }

    public void setEntertainment_Music(boolean entertainment_Music) {
        Entertainment_Music = entertainment_Music;
    }

    public void setPolitics(boolean politics) {
        Politics = politics;
    }

    public void setScienceAndTechnology(boolean scienceAndTechnology) {
        ScienceAndTechnology = scienceAndTechnology;
    }

    public void setSports_NBA(boolean sports_NBA) {
        Sports_NBA = sports_NBA;
    }

    public void setSports_NFL(boolean sports_NFL) {
        Sports_NFL = sports_NFL;
    }

    public void setUS(boolean US) {
        this.US = US;
    }

    public void setWorld(boolean world) {
        World = world;
    }
}