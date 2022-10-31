# Newstr News

Getting news from an unbiased source is difficult and relying on one source can lead to confirmation bias. In addition, 
politics dominate the news cycle, so that means finding specific topics can prove difficult. With Newster, users can 
customize their daily news delivery and receive it in their email inbox. No more jumping around from website to website. 
With Newstr, all of the sources are brought together.

## Getting Started

clone Repository from git and run the two local host servers. For our project development, we used Intellij for the back end and vscode for the front end.

### Prerequisites

What things you need to install the software and how to install them

```
NPM
```
```
Gradle
```
```
Java
```
```
Java Script
```
```
React
```

### Installing

update NPM packages

```
NPM i in the newstrweb folder
```

Run front end server

```
npm start in the newstrweb folder
```

build Gradle for backend

```
./gradlew clean
./gradlew build 
./gradlew bootRun
```

## Running the tests

In Progress

### Backend Test

Checks that the API_test.java call is not NULL

```
Runs with the application
```

## Deployment

We chose hostwind as our server because one of our team members has used it before. The backend server is implemented by Spring and is running in the server which is in the hostwinds. We made Spring into a jar file and made it run in the 8080 port. Also, the frontend client server is implemented by React.  We made a build file of the frontend and served it using NGINX in the 80 port in the hostwinds server. The link for the website is http://newster-news.com.


[newstr-news](http://newster-news.com) - The Web App


## Built With

* [Springboot](https://spring.io/projects/spring-boot) - web application framework
* [React](https://reactjs.org/) - The web framework
* [Gradle](https://gradle.org/) - deployment manager
* [NPM](https://www.npmjs.com/) - server manager

## Contributing

Please read [CONTRIBUTING.md]() 

## Newstr Members:

[Hyunsoo Kim](https://github.com/dblepart99)

[William Rogers](https://github.com/qejmc)

[Jackson Britton](https://github.com/brittainjackson7)

[Jacob Olsen](https://github.com/Jacob-Olaffson)

[Zachary Parham](https://github.com/zjp292)


## License

This project is licensed under the GNU License - see the [LICENSE.md](https://www.gnu.org/licenses/gpl-3.0.en.html) file for details
