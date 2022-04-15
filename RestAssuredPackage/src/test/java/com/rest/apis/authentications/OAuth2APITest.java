package com.rest.apis.authentications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OAuth2APITest {
    @Test
    public void checkOAuth2_APITest(){
        RequestSpecification requestSpecification=
        RestAssured.
                given()
                .auth()
                .oauth2("3c1bea7057273c1132385624f62fc416768d3626");
        Response response =requestSpecification.post("http://coop.apps.symfonycasts.com/api/3043/chickens-feed");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }

    //1.Generate a token at the run time by using token api as these access token can before invalid after a particular duration of time
    //2.String tokenID from the response
    //3.hit the rest of the upcoming apis with this tokenID

    @Test
    public void getAuth2TokenAPITest(){
        RequestSpecification requestSpecification=
        RestAssured.given()
                //These are not path or query parameters these are form parameters asking all the details for
                //getting access token in the form of a form
                .formParam("client_id","My Rest Assured Practice App")
                .formParam("client_secret","bc904c85d1bc991425ec6e2f76debe8c")
                .formParam("grant_type","client_credentials");
        Response response=requestSpecification.post("http://coop.apps.symfonycasts.com/token");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        String tokenID=response.jsonPath().getString("access_token");
        System.out.println("API token id is:"+tokenID);

        //feed chicken api
        RequestSpecification requestSpecification1=
                RestAssured.
                        given()
                        .auth()
                        //removed the hardcoding of access token
                        .oauth2(tokenID);
        Response response1 =requestSpecification1.post("http://coop.apps.symfonycasts.com/api/3043/chickens-feed");
        System.out.println(response1.statusCode());
        System.out.println(response1.prettyPrint());
    }
}

