package com.rest.apis.post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

//POJO = Plain old java object =here we will define our own methods and variables in the form of getters and setters so we will be using object oriented programming with encapsulation
//WE ARE USING POJO AS THROUGH THIS IF WE HAVE TO MAKE SAY REPOS THEN WE NEED NOT TO WRITE 10 TEST CASES
//JUST WE CAN CREATE A SINGLE POJO CLASS AND WITH THE HELP OF DATAPROVIDERS PROVIDING 10 DIFFERENT REPO NAMES AND CAN MAKE 10 REPOS WITH THE HELP OF A SINGLE TEST CASE
public class PostAPIWithPOGO {
    //create a user
    //POST-URL
    //REQUEST JSON BODY-->
    //USER JAVA CLASS(POJO)-->JSON OBJECT
    //Encapsulation --> private variables-->public(getter setter methods)
    //POJO -- Plain Old Java Object-- Java class--> private variables -->public(getter and setter methods)
    //Encapsulation = Hiding the data members
    //Now this encapsulation will be declared -->we will declare a private variable--> which can be accessed by a public variables
    //We will be doing this in the form of template that is POJO

    @Test
    public void createGitHub_Repo_With_POJO_Test(){
        User user=new User(true,"main",false,"POJO_Repository_SEREIALIZATION");

        //CONVERT POJO TO JSON -- conversion of pojo to anything json or text or any other format is called "Serialization"
        //And this conversion we have to a third party API-- JACKSON API
        //fOR JACKSON API we have to put a dependency in pom.xml i.e. "com.fasterxml.jackson.core" dependency

        ObjectMapper objectMapper=new ObjectMapper();
        String userJson=null;
        try {
            userJson=objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(userJson);

        RestAssured.baseURI="https://api.github.com";
        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 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")
                .body(userJson)
                .when().log().all()
                .post("/user/repos")
                .then().log().all()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201)
        .and()
                .body("name",equalTo(user.getName()))
                .body("default_branch",equalTo(user.getDefault_branch()));
    }
}

