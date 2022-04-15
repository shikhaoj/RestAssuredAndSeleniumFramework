package com.rest.apis.schema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//You have to make this static import on your own in order to validate the schema
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

//We are validating the json schema if it is not matching with json reponse body it will give an error
public class CheckSchemaTest {
    @Test
    public void bookings_Schema_Test(){
        given().log().all()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(new File("/home/raramuri/IdeaProjects/REST ASSURED API/src/test/java/com/rest/apis/schema/bookings.json"))
                .post("https://restful-booker.herokuapp.com/booking")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                //Schema is validated at the body level since it is a schema of json body
                .body(matchesJsonSchemaInClasspath("BookingSchema.json"));
    }
    @Test
    public void get_user_API_Schema_Test(){
        RestAssured.baseURI="https://gorest.co.in";
        given().log().all()
                .when().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                .get("/public-api/users?first_name=john&gender=female")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                //Schema is validated at the body level since it is a schema of json body
                .body(matchesJsonSchemaInClasspath("getuserschema.json"));
    }
}
