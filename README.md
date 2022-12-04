# Newster News

[Official Newster-News Website](http://newster-news.com)

Getting news from an unbiased source is difficult and relying on one source can lead to confirmation bias. In addition,
politics dominate the news cycle, so that means finding specific topics can prove difficult. With Newster, users can
customize their daily news delivery and receive it in their email inbox. No more jumping around from website to website.
With Newster, all of the sources are brought together.

### Communication

Our team uses discord to communicate with each other.

You can connect to our [team leader email](zjp29@nau.edu)

### Prerequisites

Out team uses the **Ubuntu 20.04.5 LTS** for the server. For the frontend we use **npm**, **Java script**, **React**.
For the backend we use **Java**, **Gradle**, **MySQL**. For the Webserver and ProxyServer we use **NGINX**. The mobile 
app uses **Java**, **Kotlin**, and **Android**

![](https://user-images.githubusercontent.com/39149858/198933783-27646d08-65e0-453e-b5a0-a0b1520d466e.png)

## Getting Started

### 1. Clone the Repository from git

Clone the repository and run the two local host servers.

```shell
git clone https://github.com/TheFellaz/Newstr-News.git
```

### 2. Setup the Frontend Client Server

Change directory to the frontend folder.

```shell
cd Newster-News/newsterweb
```

Install the npm package for the frontend.

```shell
npm i
```

### 3. Run the Frontend (Client) Server

```shell
npm run start
```

### 4. Set up the Backend Server

Change directory to the backend server directory.

```shell
cd Newster-news
```

Build the java project with gradle.

```shell
./gradlew clean
./gradlew build
```

### 5. Run the Backend Server

```shell
./gradlew bootRun
```

## Running the tests

- Junit
  > Use to check Spring framework
- Jest
- React testing library
- MSW
  > Use to check Frontend, React framework

## Deployment

- Hostwinds
- NGINX

We chose Hostwinds to host our server due to prior experience with it. The backend server is implemented by Spring and is 
running in the server which is in the Hostwinds server. We compiled Spring into a jar file and have it running using the 
8080 port. The frontend client server is implemented using React. We made a build file of the frontend and served it 
using NGINX in the 80 port in the Hostwinds server. The link for the website is http://newster-news.com.

## Built With

- [Springboot](https://spring.io/projects/spring-boot) - web application framework
- [React](https://reactjs.org/) - web framework
- [Gradle](https://gradle.org/) - java build manager
- [npm](https://www.npmjs.com/) - javascipt package manager
- [MySQL](https://www.mysql.com) - database
- [Android](https://www.android.com) - used to run mobile app

## Contributing

Please read [CONTRIBUTING.md](https://github.com/TheFellaz/Newstr-News/blob/main/CONTRIBUTING.md)

## The Fellaz Members:

[Hyunsoo Kim](https://github.com/dblepart99)

[William Rogers](https://github.com/qejmc)

[Jackson Britton](https://github.com/brittainjackson7)

[Jacob Olsen](https://github.com/Jacob-Olaffson)

[Zachary Parham](https://github.com/zjp292)

## Tools

Intellij, Visual Studio Code, PostMan, Android Studio

## License

This project is licensed under the GNU License - see the [LICENSE.md](https://github.com/TheFellaz/Newstr-News/blob/main/LICENSE) file for details
