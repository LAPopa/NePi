<!-- TABLE OF CONTENTS -->

# VillageHub app

<summary><h2 style="display: inline-block">Table of Contents</h2></summary>
<ol>
<li>
    <a href="#about-the-project">About The Project</a>
    <ul>
    <li><a href="#tech-used">Tech Used</a></li>
    </ul>
</li>
<li>
    <a href="#getting-started">Getting Started</a>
    <ul>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#running-the-app">Running the app</a></li>
    </ul>
</li>

</ol>

<!-- ABOUT THE PROJECT -->

## About The Project

NePi ("Neos Polis") is an application designed to simplify solving day to day issues that may arise regarding utilities (water, electricity, sewage etc). Users can create an account using an enrolled property's id in order to post tickets with their issues. On the other side of the application, the ticket is received and delegated to an operator in order to be solved. 

This repo handles both the backend and the frontend sides of the project.

All the api requests from the frontend side accesses the backend side to send or receive data from the database. 
The application is secured, each user role has different authorities and trying to access routes other than registration/login is locked behind authentication.

Application features include:

- Landing page with user logins and registration selectors

![mainScreen](https://user-images.githubusercontent.com/79319253/172130016-dda1beb6-d994-46d7-b0b9-0e313614fd1e.png)

![NePi_login](https://user-images.githubusercontent.com/79319253/172130076-523b5988-7542-4b73-bdcc-741a7963af54.gif)


- Registration forms for three user types (owner, renter, company)<br/><br/>

![ownerRegistration](https://user-images.githubusercontent.com/79319253/172130054-18f778c7-6d50-4bd9-ae5f-e311736f4622.png)


- User dashboards customized for each user type ( five user types )<br/><br/>

![mainScreen5](https://user-images.githubusercontent.com/79319253/172130149-f5dc8599-3890-4a43-85ad-14523b33cbd2.png)


- Ticketing system with respective forms to post, delegate and update the ticket status<br/><br/>

![newTicketForm](https://user-images.githubusercontent.com/79319253/172130183-9ef75ce3-807e-44fb-9e84-635ce7aae9b8.png)

![solveTicket](https://user-images.githubusercontent.com/79319253/172130201-60d616e5-a51c-4884-a5dc-394fa491230d.png)


- Graphical overviews for two user types (overseer, admin)<br/><br/>

![graphs](https://user-images.githubusercontent.com/79319253/172209886-ae414342-5445-4beb-a8d3-92af467039a3.png)



## Future Roadmap

- Expand ticketing system (track ticket status)
- Mail confirmations (account creation, ticket status changes)
- Meter readings feature 



### Tech Used

- Maven
- Java
- Spring Boot
- Spring Security
- JPA-Hibernate
- Postgresql
- React
- Node.js
- Tailwind Css
- Inkscape

<!-- GETTING STARTED -->

## Getting Started

To get a local copy up and running follow these simple steps.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/github_username/repo_name.git
   ```
2. Create your own application.properies file in a new resources directory in the backend folder and write
   ```
   spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=create-drop
   spring.datasource.url=databaseURL
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   spring.jpa.show-sql=false
   ```
   
3. Install NPM packages
    ```sh
    npm install
    ```
4. Make sure your device can run all the technologies in the build section

<!-- ACKNOWLEDGEMENTS -->

# React App

## Running the app

In the project frontend directory, you can run:

    npm start

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

