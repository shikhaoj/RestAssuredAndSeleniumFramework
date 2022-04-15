package com.rest.apis.delete;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class DeleteAPITest {
    @Test
    public void delete_user_API_Test(){

        //Always first post the data then delete as since you have a different access token you are not authorized
        //To change anyone else user data
        //With a particular access token you can only delete that data which is created by that access token
        //Hence it will not work only done as a demo but for real time projects it will work

        //post --> delete -->get

        RestAssured.baseURI="https://gorest.co.in";
        given().log().all()
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                .when().log().all()
                .delete("/public/v2/users/4034")
                .then().log().all()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .body("result",equalTo(null));

    }
}

