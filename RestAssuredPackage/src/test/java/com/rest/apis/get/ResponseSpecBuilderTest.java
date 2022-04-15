package com.rest.apis.get;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//It's a very good utility and always preferable
public class ResponseSpecBuilderTest {

    //t1 t2 t3 t4 ....t100
    //status code 200
    //content type
    //header
    //Now we need to write assertions seperately for all the test cases i.e 100 times but we will make an object where
    //you will define all the above then we apply it for all test cases
    //And ofcourse if say tommorow status code will change from 200 to 201 then we then have to update it 100 times
    //But we have these under an object we have to update it only one time
    //You can create your own expected resonse with help of response specification
    ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
    // Here responseSpecification variable is defined at the class level so that can be used for all of the test cases
    ResponseSpecification resSpec_200_OK=responseSpecBuilder.
            expectContentType(ContentType.JSON).
            expectStatusCode(200).
            expectHeader("Server","nginx").
            build();

    ResponseSpecification resSpec_400_BAD_REQUEST=responseSpecBuilder.
            expectStatusCode(400).
            expectHeader("Server","nginx").
            build();

    ResponseSpecification resSpec_401_FAIL_AUTH=responseSpecBuilder.
            expectStatusCode(401).
            expectHeader("Server","nginx").
            build();

    @Test
    public void ResponseSpecTest(){
        RestAssured.baseURI="https://gorest.co.in";
        given()
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                .when()
                .get("/public-api/users")
                .then()
                .assertThat()
                .spec(resSpec_200_OK);
    }

    @Test
     //There is problem with this API that it will give 200 even if inside the response it is 401 only and it should give the status code as 401 only
    public void ResponseSpec_Auth_Fail_Test(){
        RestAssured.baseURI="https://gorest.co.in";
        given()
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810a11111111111111111111")
                .when()
                .get("/public-api/users")
                .then()
                .assertThat()
                .spec(resSpec_401_FAIL_AUTH);
    }


}
