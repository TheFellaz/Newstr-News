package com.example.Newsternews.Resources;

public class EmailTemplate
{
    private String name1;
    private String description1;
    private String url1;

    private String name2;
    private String description2;
    private String url2;

    private String name3;
    private String description3;
    private String url3;

    private String emailBody;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getEmailBody() {
        emailBody = "<h3>" + name1 + "</h3>";
        emailBody += "<i>" + description1 + "</i>";
        emailBody += "<p>" + url1 + "</p>";

        emailBody += "<h3>" + name2 + "</h3>";
        emailBody += "<i>" + description2 + "</i>";
        emailBody += "<p>" + url2 + "</p>";

        emailBody += "<h3>" + name3 + "</h3>";
        emailBody += "<i>" + description3 + "</i>";
        emailBody += "<p>" + url3 + "</p>";

        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}