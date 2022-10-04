# Team Project - 2 - Requirements

## 1. Positioning
### 1.1 Problem statement

The problem of difficulty in finding free, customizable news that is easy to access affects everyday people who struggle finding news that they want to read the impact of which is they are uninformed, and lacking information about things they are interested.

### 1.2 Product Position Statement

For People who struggle to find news they want to read, who need better access to customizable news sources. Newstr-news is a web application that allows users to customize and receive regular email news updates. Unlike mainstream news websites and papers. Our product brings the customized news directly to our users without having to search for it.

### 1.3 Value proposition and customer segment

Value prop: Newstr is a free and easy-to-use application that allows people who struggle to find pertinent topics to receive news that suits their interests easily and daily through email.

Consumer segment: Everyday people who struggle to find interesting and relevant news stories.

## 2. Stakeholders

**Project Manager** - Zachary Parham

Responsible for assigning responsibilities, and managing deadlines and resources to ensure timely completion of assigned tasks. 

**Application Developers** - “The Fellaz” ( Jackson Brittain, Zachary Parham, Hyunsoo Kim, William Rogers, Jacob Olson)

Develop the required tasks of the software. Developers should also test, debug and improve useability and reliability of software (web applications and mobile applications).

**Testers/ Users** - NAU classmates and peers, The Interviewees, “The Fellaz”

Testers/Users will try our software and give us helpful feedback
 to help developers improve usability, reliability, and functionality.

**Competitors** - NY Times, CNN, The Heralds, FOX, NBC, MSN, Apple News

Other news applications which provide similar functionality to the users. We will have similar functionality, but we will have unique features to set us apart.

## 3. Functional requirements (features)
1. Send news to users
    - users will receive news from their inbox
2. Customizable topics
    - users can pick news topics they are interested in
3. Variable email frequency
    - users can pick a time and a frequency to receive the news
4. Sort news by bias
    - users can choose the bias of political news 
5. Customizable news sources
    - users can choose what sources they prefer
6. Stores user emails
    - backend will store emails and send news automatically


## 4. Non-functional requirements

- Reliability - 95% of users receive their news at the sending time
- Compatibility - Users accessing both the  mobile app and web app receive the same information
- Usability - Users won't have any trouble setting up accounts
- Portability - Users can view news from their phone
- Security - User information will be stored securely and will use security protocols during registration

## 5. MVP
**Features:**
- Send news to users
- Customizable news topics
- Variable email frequency

**Description:**
	The MVP will be a smaller app that allows users to select news topics that interest them

  
## 6. Use cases
### 6.1 Use case diagram
![Use Case Diagram](https://user-images.githubusercontent.com/71902810/193481228-f57c2553-d022-409c-8f0b-72eda95a5067.png)

### 6.2 Use Case Descriptions and interface Sketch

Jacob: Register new user

**1	Brief Description:**
The user will register their account into the system.

**2	Actor Brief Descriptions:**
The users who are joining Newstr-News

**2.1 	Actor 1 Name:**
New user

**3	Preconditions:**

3.1:
The user is not already registered

3.2:
The user can connect to the system

3.3:
The user has an email address to register with

**4	Basic Flow of Events**

	1.	User opens the app
	
	2.	User selects option to sign up
	
	3.	User enters their information
	
	4.	User confirms information and continues with sign up
	
	5.	System sends user information to server
	
	6.	Server records new user information

**5	Alternative Flows**

5.1:	Email already in use

At step 4, if email is already in use, the app messages the user to use a different email, and the user is returned to step 3.

**6	Subflows**

6.1:	Step 4-5 subflow

4.1 User confirms information

4.2 App sends information to server

5.1 Server receives user information

5.2 Server records user information

**7	Key Scenarios**

7.1: A new user is registering for the service

**8	Post Conditions:**

The user is registered to the system and can access their profile and customize their settings.

**9	Special Requirements:**

n/a


![interface sketch 1](https://user-images.githubusercontent.com/71902810/193481318-4d8e3844-884b-4dc4-8cbb-de4cd0ff71f6.png)


Jackson: Register email
**1    	Brief Description**
The web users will be able to register their email

**2    	Actor Brief Descriptions**
The users who use newstr-news in website
2.1    	<Actor 1 Name>
The Web user 

**3    	Preconditions**
<pre-condition 1>
They have navigated to the web page and started the signup process

**4    	Basic Flow of Events**
1. 	They start the account creation process
2. 	Enter their email address
3. 	
**5    	Alternative Flows**
5.1    	<alternate flow 1>
1. They are not receiving emails, must check if they entered their email address
2. 
**6    	Subflows**
6.1    	<subflow 1>
1. 	<subflow 1, step 1>
2. 	…
3. 	<subflow 1, step n>
**7    	Key Scenarios**
7.1    	<scenario 1>
1. The user is signing up
2. 
**8    	Post-conditions**
8.1    	The users will have an account and be able to select other preferences

**9    	Special Requirements**
		The user should have or set us a email account
    
    
Zachary: Add topics to receive 

**1    	Brief Description**
Users can choose what topics they receive from the news email.

**2    	Actor Brief Descriptions**
Users who want to customize their news feed.
2.1    	Actor 1
The Web user 

**3    	Preconditions**
	User has created an account with newster-news.
  
**4    	Basic Flow of Events**
1. Use case begins when user creates an account
2. Users select multiple news categories that they are interested in.
3. Use case ends

**5    	Alternative Flows**
5.1    	<alternate flow 1>
1. If the user already has an account and wishes to update their preferences:
User selects the “Update your preferences” option on the website
The use case resumes at step 2

**6    	Subflows**
6.1    	<subflow 1>
1.  For each category they select, the categories will be added to the database 
2. If the user does not select any categories, the user will receive general news

**7    	Key Scenarios**
7.1    	<scenario 1>
1. The users are waiting for the news articles
2. The users receive the emergency news articles when appropriate

**8    	Post-conditions**
8.1    	The users will receive news articles from the categories they selected

**9    	Special Requirements**
		All of the users should have a Newster-news account.
    
![interface 3 sketch](https://user-images.githubusercontent.com/71902810/193481530-a32af29e-9dce-43ed-a019-96f3e3309d3d.png)


William: Opt-in to emergency news

**1    	Brief Description**
Users can choose to opt-in to important or emergency news.

**2    	Actor Brief Descriptions**
The users who use newstr-news on the website
2.1    	Actor 1
The Web user 

**3    	Preconditions**
	User has created an account with newster-news.
  
**4    	Basic Flow of Events**
1. Use case begins when user creates an account
2. User selects a checkbox stating “Opt-in to emergency news” with a brief description
3. Use case ends

**5    	Alternative Flows**
5.1    	<alternate flow 1>
1. If the user already has an account and wishes to update their preferences:
User selects the “Update your preferences” option on the website
The use case resumes at step 2

**6    	Subflows**
6.1    	<subflow 1>
1.  If the user selects the checkbox, update their preferences accordingly in the database, and begin to send emergency news
2. If the user does not select the checkbox, update their preferences accordingly and do not send emergency news

**7    	Key Scenarios**
7.1    	<scenario 1>
1. The users are creating their account for the first time
2. The users will select the category 

**8    	Post-conditions**
8.1    	The users will receive the emergency news urls by email.

**9    	Special Requirements**
		All of the users should have a Newster-news account.
    
![interface 4 sketch](https://user-images.githubusercontent.com/71902810/193481589-86d4c313-d32d-4dc0-b8b6-f840f6a75e86.png)


Hyunsoo: Receive news emails

**1    	Brief Description**
The web users will be able to receive news URL in emails

**2    	Actor Brief Descriptions**
The users who use newstr-news in website
2.1    	<Actor 1 Name>
The Web user 

**3    	Preconditions**
<pre-condition 1>
They have signed up for the service and chosen their news categories.

**4    	Basic Flow of Events**
1. 	They start to receive emails with news URLs on them.

**5    	Alternative Flows**
5.1    	<alternate flow 1>
1. They are not receiving emails, must check if they chose the news category and entered their email address to the service.

**6    	Subflows**
6.1    	<subflow 1>
1. 	<subflow 1, step 1>
2. 	…
3. 	<subflow 1, step n>

**7    	Key Scenarios**
7.1    	<scenario 1>
1. The users are waiting for the news articles
2. The email is delivered at the time, when the users chose.

**8    	Post-conditions**
8.1    	The users will receive the news urls by email.

**9    	Special Requirements**
		All of the users should have a personal email account.
    
![Interface 5 sketch](https://user-images.githubusercontent.com/71902810/193481654-50968452-e515-490b-9871-6924be1aadb5.png)

## 7. User Stories

### Hyunsoo Kim
**User story 1:**
“As a night shift worker, I want news delivered at night so that I can get updated news about what happened before my work starts.
**Priority:** 1 **Estimated Hours:** 1

**User story 2:**
“As a big fan of football, I don’t want to go to a lot of news websites for the football news. So that I can get news in a shorter time. 
**Priority:** 2 **Estimated Hours:** 1

### Jacob Olson:
**User Story 1:**
“As a person with niche interests, I want customizable news topics so that I can find more of what interests me”
**Priority:** 1 **Estimated Hours:** 1

**User Story 2:**
“As a person who struggles to find news readily, I want news delivered directly to me so that I can engage with current events with little effort”
**Priority:** 1 **Estimated Hours:** 1

### William Rogers:
**User Story 1:**
“As a huge NASA fan, I want to receive news relating to space exploration so that I can one day become an astronaut.”
**Priority:** 1 **Estimated Hours:** 1

**User Story 2:**
“As someone who often does not have time to read the news, I want free news delivered to me automatically so that I can stay informed”
**Priority:** 1 **Estimated Hours:** 1

### Zachary Parham
**User Story 1:**
“As an investor, I want to get business news delivery before market open, so I can make educated decisions in investing”
**Priority:** 1 **Estimated hours:** 1

**User Story 2:**
“As a student, I want to get updates on important government grants and loans, so I can stay informed about education funding”
**Priority:** 1 **Estimated hours:** 1

### Jackson Brittain
**User Story 1:**
“As a busy college student, I want easily accessible news, so I can spend less time browsing the internet”
**Priority:** 1 **Estimated hours:** 1

**User Story 2:**
“As a previous newspaper reader, I want to be able to receive local news online, so I don't have to read another soggy newspaper”
**Priority:** 1 **Estimated hours:** 1

## 8. Issue Tracker

[Issue Tracker](https://github.com/TheFellaz/Newstr-News/issues)
    
![User Story Issue Tracker](https://user-images.githubusercontent.com/71902810/193481108-33eb997e-9ed5-44e0-8f25-5b821a65de35.png)
