# Team Project - D.7 V & V

## 1. Description

**Provide 1-2 paragraphs to describe your system. This will help us to remember what your system is about.**

Our system, Newster-News, is an online news application that allows users to customize a daily newsletter. Our app saves user preferences about news topics they would like to receive, and the frequency at which they want to receive news. The system will then automatically fetch news relevant to the user’s interests, then send that news to their email.

  

Our system presents a frontend UI to the client using a React.js server responsible for signing up users, login and logout, and setting user preferences. The backend Spring server is responsible for handling a MySQL database and using a few API’s to fetch news articles, then send them by email to the user.

GitHub: https://github.com/TheFellaz/Newstr-News 

Website: http://newster-news.com/


## 2. Verification

### 2.1 Unit test

### 2.1.1 Test framework to develop our tests
`Backend: Junit4`
`Frontend: Jest`

### 2.1.2 **Link to your GitHub folder where your automated unit tests are located**

[Backend Unit Test Link](https://github.com/TheFellaz/Newstr-News/tree/main/Newster-news/src/test/java/com/example/Newsternews)
<br/>
[Frontend Unit Test Link](https://github.com/TheFellaz/Newstr-News/tree/main/newsterweb/src/__test__)


### 2.1.3 **An example of a test case that makes use of mock objects. Include in your answer a GitHub link to the class being tested and to the test.**

**Backend Tested Object**
[Backend test case file](https://github.com/TheFellaz/Newstr-News/blob/main/Newster-news/src/test/java/com/example/Newsternews/APITests/API_Mock.java)

**Print Screen:**
**![](https://lh3.googleusercontent.com/Hk_sY6V3Fr2e77rR8ytjSzvMr0O-Ixip_4lqnJzzA33r1Lx6Fu1GbkMMkLXA5iHn1OuC6gxmdYhCz-gb8xfbMbUhpWqkS03toVycX26iN1FbY6lNCucVDVaq704Qv45gsDkHVqFTmUVhQf1jZxpVXygPvUfIIGGaautR0qZ7ErF6r37Lhm6G8qC673-3tw)**

### 2.2 Acceptance Test

### 2.2.1 **Test framework you used to develop your test**
Selenium

### 2.2.2 **Link to your GitHub folder where your automated acceptance tests are located**
[Acceptance Test Link](https://github.com/TheFellaz/Newstr-News/blob/main/Newster-news/src/test/java/com/example/Newsternews/AcceptanceTest)

### 2.2.3 **Test examples of an acceptance test**

[Github Link for Acceptance Test](https://github.com/TheFellaz/Newstr-News/blob/main/Newster-news/src/test/java/com/example/Newsternews/AcceptanceTest/MainPageTest.java)

testTitle()

-   check if the user can get the proper website name
    
-   Assert.assertThat(driver.getTitle(),is("Newster News"));
    

  

testMoveLoginPage()

-   check if user can move to the Login page
    
-   Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));
    

  

testMoveUserPage()

-   check if the user can login and move to the user page
    
-   Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));
    

  

testSignUpPage()

-   check if the user can SignUp the webpage
    
-   Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));

### 2.2.4 **Test Video**
[Test result Video](https://drive.google.com/file/d/1XcSZWGS2aefwGC4HMFEmNRf0ojDJ4tzy/view?usp=sharing)

## 3. Validation (user evaluation)

**Validation aims to ensure that you developed the right product. At the beginning of the semester, you talked to the clients/potential users to understand their needs. Now it is time to check if you are on the right track by conducting some user evaluation on the actual system.**

### Script:

Tasks: 
- Please create an account in the Newster-news website

- Please add and modify your topics

- Please modify your email frequency

Questions:

1.  Please describe your experience with the UI
    
2.  Please describe the process of making an account
    
3.  Please describe the process of updating topic choice
    
4.  Please describe the process of updating email frequency
    
5.  How would you compare this experience to bigger newsletter providers if applicable?
    
6.  How would you rate your experience out of 10?


### Interviews Results 
#### Interview 1. **Ethan Hall:**

Tasks:

All tasks complete with no conflict

  

Answers to questions:

1.  The UI was basic but easy to navigate. I thought it could do with more color and some simple css, but it was a good experience. Nothing was too confusing and everything was straight forward.
    
2.  The process was simple. I had no problems filling out the form to create an account
    
3.  The process was also simple. All I had to do was click a few buttons. As a user, I don’t really have to struggle with setting my preferences like other websites
    
4.  Updating the email frequency was easy as well.
    
5.  I have not used another newsletter provider
    
6.  9/10, only took off points for the UI being so simple
    

  
  
#### Interview 2. **Evan Johnson:**

Tasks:

All tasks completed with no conflict

  

Answer

1.  The UI was very straightforward. I had 0 problems with it.
    
2.  The process was also straightforward.
    
3.  the process was also straightforward
    
4.  The process was easy and simple
    
5.  N/A
    
6.  10/10 the process was really easy
    

  
  
  
  
#### Interview 3. **Jaesang Park:**

Tasks:

All tasks completed with no conflict

  

Answer

1.  The UI was basic and fairly simple to understand, but I had a few minor issues navigating while I got used to it
    
2.  The process was simple to create an account
    
3.  Updating topics were super easy
    
4.  Updating email frequency was also easy
    
5.  This service is able to provide news automatically to my inbox for free which I find helpful as someone who doesn't go out and search for news that often
    
6.  9/10
    

  
  
### Reflections:   
Reflect on what you observed. Some questions that you can explore: What features worked well? What can be changed? How is the learning curve of your system? Did the users perform the tasks as you expected? Did the users’ actions produce the results they expected? What did the users like the most? Is your value proposition accomplished?

**Worked well:**

-   The UI was simple but easy to understand and use.
    
-   Updating information such as topic info and frequency is easy for the average user
    

**What can be improved:**

-   send an email as soon as the user signs in
    
-   UI could use more color
    

**Learning curve:**

-   there is no learning curve, our system is straightforward
    

**Liked the most:**

-   The users liked how straightforward the application was. There was no complicated aspects of our UI.
