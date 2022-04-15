package com.rest.apis.authentications;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthApis {

    //basic preemptive auth:
    //username/password

    @Test
    public void basic_auth_Preemptive_API_Test(){
        //basic auth will create an encrypted access token in the background
        /*do remember the sequence
        given()
        auth()
        preemptive()
        basic()
        After that remaining are the same
         */
        given().log().all()
                .auth()
                .preemptive()
                .basic("admin","admin")
                .when().log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    //basic --> username,password
    //preemptive--> we use preemptive auth as when you are using only basic auth then there may be possibilities
    //that server will do some extra processing and internally will require some extra information , so we use preemptive to handle this
    //As preemptive emforces the server that it is a correct user you no need to do extra processing to check its validity
    //digest
    //form
    //Oauth1 --> concept of client secret , client id etc
    //Oauth2 --> concept of bearer token , token ID etc

    //Basic Auth
    @Test
    public void basic_auth_API_Test(){
        given().log().all()
                .auth()
                .basic("admin","admin")
                .when().log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    //digest
    //in digest authentication we are sending username and password in the form of hash codes to the server
    //hence it is more secured than basic authentication
    @Test
    public void basic_auth_digest_API_Test(){
        given().log().all()
                .auth()
                .digest("admin","admin")
                .when().log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    //form
    //it always come from form-based html
    //You can check this site "https://classic.crmpro.com"
    //It is when we have to pass the userid and password from the login webpage
    //So what it will do it will do get() call to get the username and password from the html webpage and then send it to the server
    @Test
    public void basic_auth_form_API_Test(){
        given().log().all()
                .auth()
                .form("admin","admin",new FormAuthConfig("https://classic.freecrm.com/system/authenticate.cfm","username","password"))
                .when().log().all()
                //use the same formAction link for get() call
                .get("https://classic.freecrm.com/system/authenticate.cfm")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    //Oauth2.0 :
    //If you are using:
    //1.with header:append your token with Bearer keyword
    //2.with oauth2() method:No need to add Bearer just pass the token value oauth2() will internally add the Bearer
    @Test
    public void OAuth2_API_Test(){
        given().log().all()
                .auth()
                .oauth2("a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                .when().log().all()
                .get("https://gorest.co.in/public-api/users?first_name=Elva")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void OAuth_API_Test_With_AutoHeader(){
        RestAssured.baseURI="https://gorest.co.in";
        given().log().all()
                .contentType("application/json")
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                .when().log().all()
                .get("/public-api/users?first_name=Elva")
                .then().log().all()
                .statusCode(200)
                .and()
                .header("Server","nginx");
    }

    @Test
    public void OAuth_API_WithTwoQueryParams_API_Test(){
        RestAssured.baseURI="https://gorest.co.in";
        given().log().all()
                .contentType("application/json")
                .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                //queryParam() and param() does the same thing but queryParam() is preferable
                .queryParam("first_name","John")
                .queryParam("gender","male")
                .when().log().all()
                .get("/public-api/users")
                .then().log().all()
                .statusCode(200)
                .and()
                .header("Server","nginx");
    }
}
