package com.rest.apis.zopping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class AuthenticationForZopping {

   @Test
    public void auth_api_post_call(){

       Authentication userNamePassword=new Authentication("shikha.rani@zopsmart.com","78513882",false);

       ObjectMapper objectMapper=new ObjectMapper();
       String jsonPayload = null;

       try {
           jsonPayload=objectMapper.writeValueAsString(userNamePassword);
       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }
       System.out.println("=============");
       System.out.println(jsonPayload);
       RestAssured.baseURI="https://staging.zopping.com";
       given().log().all()
               .contentType(ContentType.JSON)
               .body(jsonPayload)
               .when().log().all()
               .post("/api/account-service/auth")
               .then().log().all()
               .assertThat()
               .statusCode(200);

   }



}
