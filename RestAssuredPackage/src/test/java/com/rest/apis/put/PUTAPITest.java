package com.rest.apis.put;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.apis.post.CreateUser;
import com.rest.apis.post.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

//Since it is not necessary for the userId for which we are updating the data will be present in future or gone once someone has refreshed the database
//Hence we first create data by using a post call then update the created userId
//The working of PUT API is to update an existing record and if no record is there then create a new one
public class PUTAPITest {

    //Create a user with post call
    //give the payload that is user info
    //update the info with put call
    //1. other attributes should remain same
    //2. the attribute which has been changed , need to check

    @Test
    public void update_User_PUT_API_Test(){

        //1.Create a POST Request with Payload
        CreateUser user=new CreateUser("Niharika","scrum master");

        //Convert this POJO to JSON -- using JACKSON API - ObjectMapper
        ObjectMapper objectMapper=new ObjectMapper();
        String userJson=null;
        try {
            userJson=objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("POST CALL JSON IS"+userJson);

        //write POST CALL
        RestAssured.baseURI="https://reqres.in";
        String userId = given().log().all()
                .contentType(ContentType.JSON)
                .body(userJson)
                .when().log().all()
                .post("/api/users")
                .then().log().all()
                .assertThat()
                .contentType(ContentType.JSON)
                        .extract().path("id");
        System.out.println("user id is:::> "+userId);
         //System.out.println("Response of POST "+userId.asString());

        //Call the put API
       user.setName("Mia");

        //Convert this POJO to JSON -- using JACKSON API - ObjectMapper
        String updatedUserJson=null;
        try {
            updatedUserJson=objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        given().log().all()
                .contentType(ContentType.JSON)
                .body(updatedUserJson)
                .when().log().all()
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat()
                .contentType(ContentType.JSON)
                //We always do below 3 assertions for put call
                //1.Check wheather the updated attribute is updated or not
                .and()
                .body("name",equalTo(user.getName()))
                //2.Check wheather it is updated for the same user or some other
                //AS it may happen that some other id got updated it is a common bug while using put call

                //Here there is no id present in the response body of put call so we can't check it but otherwise we have to
               // .body("id",equalTo(userId))
                //3.Check wheather the non-updated attribute is as it is or not
                //.and()
                .body("job",equalTo(user.getJob()));

        //It is a good practice to use this sequence for post and put calls
        //As if this whole sequence is not working then there is a bug in the application
        //1.post--> get
        //2.post --> put -->get


    }
}

