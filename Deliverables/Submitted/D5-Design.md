## 1. Description

Our system, Newster-News, is an online news application that allows users to customize a daily newsletter. Our app saves 
user preferences about news topics they would like to receive, and the frequency at which they want to receive news. The 
system will then automatically fetch news relevant to the user’s interests, then send that news to their email.

Our system presents a frontend UI to the client using a React.js server responsible for signing up users, login and 
logout, and setting user preferences. The backend Spring server is responsible for handling a MySQL database and using a 
few API’s to fetch news articles, then send them by email to the user.

---

## 2. Architecture

![d5-2](https://user-images.githubusercontent.com/35905481/201496561-e6ced83c-d85d-41f6-9182-48d0ea02eaa0.jpg)

---

## 3. Class Diagram

![d5-3](https://user-images.githubusercontent.com/35905481/201496562-446a3bf8-2e81-4f63-a1ff-4047c1a52fea.jpg)

---

## 4. Sequence Diagram

![d5-4](https://user-images.githubusercontent.com/35905481/201496563-4757c6be-73aa-46cf-a8e9-83360019939e.jpg)

### 1 Brief Description 

The user will register their account into the system.

### 2 Actor Brief Descriptions 

The users who are joining Newstr-News

2.1 Actor 1 Name: New user

### 3 Preconditions:

3.1: The user is not already registered

3.2: The user can connect to the system

3.3: The user has an email address to register with

### 4 Basic Flow of Events

1.	User opens the app

2.	User selects option to sign up

3.	User enters their information

4.	User confirms information and continues with sign up

5.	System sends user information to server

6.	Server records new user information

### 5 Alternative Flows

5.1: Email already in use

At step 4, if email is already in use, the app messages the user to use a different email, and the user is returned to 
step 3.

### 6 Subflows

6.1: Step 4-5 subflow

4.1 User confirms information

4.2 App sends information to server

5.1 Server receives user information

5.2 Server records user information

### 7 Key Scenarios

7.1: A new user is registering for the service

### 8 Post Conditions:
The user is registered to the system and can access their profile and customize their settings.

### 9 Special Requirements:
N/A

---

## 5. Design Patterns

### Backend - Creational (Singleton)

![d5-5](https://user-images.githubusercontent.com/35905481/201496564-fad7973c-344b-4509-9a80-94776caa19f5.jpg)

API: https://github.com/TheFellaz/Newstr-News/blob/main/Newster-news/src/main/java/com/example/Newsternews/API/API.java

Keys: https://github.com/TheFellaz/Newstr-News/blob/main/Newster-news/src/main/java/com/example/Newsternews/Keys/Keys.java

### Frontend - Behavioral (Template)

![d5-6](https://user-images.githubusercontent.com/35905481/201496565-7421aef3-6f6f-4e32-8704-419220a6e1de.jpg)

App: https://github.com/TheFellaz/Newstr-News/blob/main/newsterweb/src/App.js

Router: https://github.com/TheFellaz/Newstr-News/blob/main/newsterweb/src/Router.js

Header: https://github.com/TheFellaz/Newstr-News/blob/main/newsterweb/src/component/Header/Header.js

Footer: https://github.com/TheFellaz/Newstr-News/blob/frontend/newsterweb/src/component/Footer/Footer.js

---

## 6. Design Principles

### SRP (Single Responsibility Principle)

Each java or javascript file is only responsible for creating one object, which adds one piece of functionality to the 
software.

### OCP (Open-Closed Principle)

Our classes, such as the EmailBody class, use private String constants with mutator and accessor methods to alter them. 
This results in classes that are open to extension, but closed for modification.

### LSP (Liskov Substitution Principle)

Because of how React is organized, and because of how unique our java objects are in the first place, we don’t have much 
use for stereotyping and super and subclasses.

### ISP (Interface Segregation Principle)

Our interfaces such as the SignUp page on the frontend are displayed for certain purposes without displaying all the 
information on a single page (interface).

### DIP (Dependency Inversion Principle)

Our email sending service depends only on an email service interface we created, not the object that implements it.


