## 1. Introduction

**Provide a short paragraph that describes your system. This paragraph should contain the value proposition and the description of the main features of the software. At the end of the introduction, include links to your project on GitHub and Trello.**

Value prop: Newstr is a free and easy-to-use application that allows people who struggle to find pertinent topics to receive news that suits their interests easily and daily through email.

The system awaits a response from the user. Once the user clicks on the get news button on the front end, the front end will show the Bing News API response. This system provides the user with pertinent information on general news.

Github: https://github.com/TheFellaz/Newstr-News 

## 2. Implemented requirements

**List in this section, the requirements and associated pull request that you implemented for this release, following the example below---include the description 
of the requirement, a link to the issue, a link to the pull request(s) that implement the requirement, who implemented the requirement, who approved it, and a 
print screen that depicts the implemented feature (if applicable). I expect that you implement the features you specified in your MVP (c.f. D.2 Requirements). 
Order the requirements below by the name of the student who implemented them. All the members of the group should have worked on implementation activities and 
submitted pull requests. Only stable code should be included in the release. The code that is still under development should be in branches.**

### Implementation 1

Requirement: Receive Bing News API response and process it to be displayed

Issue: https://github.com/TheFellaz/Newstr-News/issues/23 Pull request: https://github.com/TheFellaz/Newstr-News/pull/46 

Implemented by: Zachary Parham, William Rogers

Approved by: Jackson Brittain

Print screen: N/A

### Implementation 2

Requirement: Users can get news 

Issue: 
https://github.com/TheFellaz/Newstr-News/issues/36
https://github.com/TheFellaz/Newstr-News/issues/44
Pull request: 
https://github.com/TheFellaz/Newstr-News/pull/42
https://github.com/TheFellaz/Newstr-News/pull/45

Implemented by: Hyunsoo Kim

Approved by: Jackson Britain, Jacob Olson

Print screen: 

### Implementation 3

Requirement: Receive Bing News API response and process it to be displayed

Issue: https://github.com/TheFellaz/Newstr-News/issues/23 
Pull request: https://github.com/TheFellaz/Newstr-News/pull/46 

Implemented by: Zachary Parham, William Rogers

Approved by: Jackson Brittain

Print screen: 

### Implementation 4

Requirement: Send news article to frontend from spring server.

Issue: https://github.com/TheFellaz/Newstr-News/issues/50
Pull request: https://github.com/TheFellaz/Newstr-News/pull/52

Implemented by: Jacob Olson, Zachary Parham, Hyunsoo Kim

Approved by: Hyunsoo Kim

Print screen: N/A



## 3. Tests

**You should implement automated tests that aim to verify the correct behavior of your code.**

**Test framework you used to develop your tests**

`Backend: Junit4`

**Link to your GitHub folder**

[Github](Newstr-News/Newster-news/src/test/java/com/example/Newsternews/APITests)

**An example of a test case**

[Tests](Newstr-News/Newster-news/src/test/java/com/example/Newsternews/APITests/API_Tests.java)

**Test Results**

## 4. Adopted technologies

**List the adopted technologies with a brief description and justification for choosing them**

**Backend: Spring Boot**

The team chose spring for this web application because it removes a lot of the base plate code needed to create/run a web application.


**Frontend: React.js**

We chose React because React makes Javascript coding easier, and also can handle dependencies easily.
 
 **API’s used: Bing News API, Spring.js email API**

**Java testing tool: Junit 5**


**Web Server: NGINX**

We chose NGINX as a web server framework because NGINX allows us to easily setup the proxy server and about load balancing stuff.


**Database: MySQL**

We chose MySQL because it was easy to connect with the spring server and react.


## 5. Learning/training

**Describe the strategies employed by the team to learn the adopted technologies**

For learning/training, technologies already known by the team were designated for them. The two big ones being the front end(React.js) with Hyunsoo, and the back end(Java) with Zach. This means we have two different groups that meet separately but all meet together to link the two systems. As for the systems that are unknown to everyone such as Jest was split up amongst the team to learn. We didn’t have enough code to test in the frontend with jest so we implemented a test for the backend using the Junit.

## 6. Deployment

**Provide a link for the system in production and describe how you are deploying your system. **

We chose hostwind as our server because one of our team members has used it before. The backend server is implemented by Spring and is running in the server which is in the hostwinds. We uploaded the spring application to the server and ran it with gradle commands. Also, the frontend client server is implemented by React.  We made a build file of the frontend and served it using NGINX in the 80 port in the hostwinds server.

## 7. Licensing

**Inform the license you adopted for your source code (remember to configure GitHub
accordingly) and why you adopted this license. For more information, check [https://choosealicense.com/](https://choosealicense.com/) and [http://redhat.slides.com/glikins/open-sourcelicensing-101#/](http://redhat.slides.com/glikins/open-sourcelicensing-101#/)**

**GNU License**

- [GNU license](https://www.gnu.org/licenses/gpl-3.0.en.html)

We choose to use the GNU General Public License V3 to license our source code. We choose this license as it allows potential new developers to build upon our current 
code if Newster News does not end up reaching its full potential by the end of the course.

## 8. Readme File

**You should also prepare your repository for receiving new contributors.
Besides the Readme.md file, your repository should contain a CONTRIBUTING.md
file, a LICENSE file, and a CODE_OF_CONDUCT.md file. Search online for some
examples of these files. In this section of the deliverable, put links to these files on GitHub.**

- [README.md](https://github.com/TheFellaz/Newstr-News/blob/main/README.md)

- [CONTRIBUTING.md](https://github.com/TheFellaz/Newstr-News/blob/main/CONTRIBUTING.md)

- [CODE_OF_CONDUCT.md](https://github.com/TheFellaz/Newstr-News/blob/main/CODE_OF_CONDUCT.md)

- [LICENSE](https://github.com/TheFellaz/Newstr-News/blob/main/LICENSE)


## 9. Look & feel

**Describe the approach you adopted to design your user interface. Include some
Screenshots.**

For this implementation, we kept the UI simple and limited as we are still testing some functionalities, and haven’t expanded the project to warrant a more complex UI. For the second implementation, we plan to expand our UI and are considering a couple ideas. Currently we plan on keeping as much as we can on one page and having the users scroll to navigate through the web app in order to keep features from being buried in a complex network of different pages.

## 10. Lessons learned

**In retrospective, describe what your team learned during this first release and what you
are planning to change for the second release.**

In the frontend team(Jackson, Hyunsoo, Jacob) we learned how to set up React and test automation tools. In the backend (William, Zach), we learned how to implement the Bing News API and access the json result using tools such as Gson and Spring.

## 11. Demo

**Include a link to a video showing the system working.**

[Mobile App](https://youtube.com/shorts/Qq530LLksnQ?feature=share)
