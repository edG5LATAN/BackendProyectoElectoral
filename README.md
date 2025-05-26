# Project Back-End about School Election with Java Spring-Boot and Spring-Security ! 👋


![Logo](https://i.pinimg.com/736x/75/ad/bf/75adbf09fc8de34d0febb9cb7714764a.jpg)


## 🚀 About Project
This project is about one aplication of school elections for one party politic school.
All the student having create one  user for can to vote, in this user have your course, name, lastName, email and one password this email never repeat it 

The students can select of all the political party one favorite, the student can see the counts the vote in the same time.

The students only vote one time and only the admin can modify the political parties how create, delete, update

The admin can modify the code for put the time and date when the student can see the counts the votes.

For more project you can visit my
[Linkedin](https://www.linkedin.com/in/edwin-castro-13a763272/)
## Tech Stack

**Front-End:** React, Context, Cors, ENV, Bootstrap, HTML, CSS, JS, Cookie Token.

**Back-End:** Java, Spring-Boot, Spring-Security, JWT, Bcrypt, Cookie Token,


## API Reference

for this backend only three options not need authentication, they are create one user, log-out and login, in the login its created create one session token cookie for in to the other endpoints of the backend.

This send to for the header in the form of token cookie, for this you need configrate the frontend and backend for receive the token instant

#### login

```http
  POST /v1/loguearse/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Required**.|
| `password` | `string` | **Required**.|

##### here return one Token and header how cookie-token this token is for the validation for the other endpoints


#### create user

```http
  POST /v1/alumno/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name` | `string` | **Required**. |
| `lastName` | `string` | **Required**. |
| `grade` | `Enumerated` | **Required**.  |
| `email` | `string` | **Required**.  |
| `password` | `string` | **Required**. |

#### log-out

```http
  POST /v1/loguearse/logout
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `null` | `null` | **Not-Required**. |




## Documentation

[JWT](https://jwt.io/) Here is created our token encrypt

[Bcrypt](https://mvnrepository.com/artifact/at.favre.lib/bcrypt) Here is created our password encrypt for the send at the jwt

[Cookie](https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html) Here we recived the token encrypt only for the read in the frontend and not modify front the web

[Spring-Security](https://spring.io/projects/spring-security) Here to created all the logic of the authentication to user for our project and the roles of the authentication

[Spring-Boot](https://spring.io/projects/spring-boot)Here to created all our project how endpoints ,services ,controller and DTO for the use in the project

## Environment Variables

To run this project, you will need to add the following environment variables

`${PASS}` the password of your databases if you use MYSQL

`${HOST}` the direccion of the page

`${DTB_USER}` name of you databases for the project

`${PORT}` port where you backend running

`${APIKEY}` this is for you key in your JWT




## Demo

Here you can see the proyect already deployed in [YouTube](https://youtu.be/XIn_6wvHCls?si=c0ML25gI_mbMl3d_) and you will can see some parts of code front-end and back-end

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-Front_End-000?style=for-the-badge&logo=ko-fi&logoColor=yellow)](https://portafolio-frontend-rust.vercel.app/)
[![portfolio](https://img.shields.io/badge/my_portfolio-Back_Edn-000?style=for-the-badge&logo=ko-fi&logoColor=green)](https://portafolio-reack.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/edwin-castro-13a763272)



