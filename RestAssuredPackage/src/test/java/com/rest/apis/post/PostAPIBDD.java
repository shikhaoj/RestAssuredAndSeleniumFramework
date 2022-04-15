package com.rest.apis.post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPIBDD {
    @Test
    public void tokenPostBDDAPI_JSONSTRING_Test() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        given().log().all()
                .contentType(ContentType.JSON)
                //We have to make the inner double quotes as literals by putting "\" otherwise it will only take "{" as a string
                //JSON Payload is having very less attributes or that payload is never gonna change then it is passed as a string
                //As when too many attributes are present then that much literals you have to use
                .body("{\"username\" : \"admin\",\"password\" : \"password123\"}")
                .when().log().all()
                //it is a post api to generate a token
                .post("/auth")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void tokenPostBDDAPI_FILE_TEST(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String tokenID=given().log().all()
                .contentType(ContentType.JSON)
                //We have to make the inner double quotes as literals by putting "\" otherwise it will only take "{" as a string
                .body(new File("/home/raramuri/IdeaProjects/REST ASSURED API/src/test/java/ datafiles/credentials.json"))
                .when().log().all()
                //it is a post api to generate a token
                .post("/auth")
                .then().log().all()
                //Extracting a value from json path
                .extract().path("token");
        System.out.println(tokenID);
        //we can not use assertEquals as every time new access token will be generated we can not compare it
        //but for this test case to work every time token should be created and if it is not created then by default string is null
        Assert.assertNotNull(tokenID);
    }
    @Test
    public void createGitHubRepo_Post_API_JSONStringTest(){
        RestAssured.baseURI="https://api.github.com";
        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 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")
                .body("{\"name\" : \"Post_with_OAuth2_with_RestAPI_TestingOfApis\"}")
                .when().log().all()
                .post("/user/repos")
                .then().log().all()
                //with extract we can only use it for checking single attribute at a time from the response body
                //but with .body() you can check the multiple attributes at the time in one go with help of .and()
                .assertThat()
                .statusCode(201)
                .body("private",equalTo(false))
                .and()
                .body("owner.login",equalTo("shikhaoj"));
    }
    @Test
    public void createGitHub_Post_API_FileTest(){
        RestAssured.baseURI="https://api.github.com";
        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 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")
                .body(new File("/home/raramuri/IdeaProjects/REST ASSURED API/src/test/java/ datafiles/user.json"))
                .when().log().all()
                .post("/user/repos")
                .then().log().all()
                //with extract we can only use it for checking single attribute at a time from the response body
                //but with .body() you can check the multiple attributes at the time in one go with help of .and()
                .assertThat()
                .statusCode(201)
                .body("private",equalTo(false));

    }
}
