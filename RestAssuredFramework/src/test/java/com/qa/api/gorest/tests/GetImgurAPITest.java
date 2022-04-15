package com.qa.api.gorest.tests;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetImgurAPITest {

    Map<Object,Object> tokenMap;
    String accessToken;
    String accountUserName;
    String refreshToken;

    @BeforeMethod
    public void setUp(){
        tokenMap=Token.getAccessToken();
        accessToken=tokenMap.get("access_token").toString();
        accountUserName=tokenMap.get("account_username").toString();
        refreshToken=tokenMap.get("refresh_token").toString();
    }

    @Test
    public void getAccountBlockStatusTest(){

        //wheather it is clientid or authToken it is stored in the string map and then it is passed
        Map<String,String> authTokenMap =Token.getAuthToken();
        Response response =RestClient.doGet(null,"https://api.imgur.com","/account/v1/"+accountUserName+"/block",authTokenMap,null,true);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

    }

    @Test
    public void getAccountImagesTest(){
        Map<String,String> authTokenMap =Token.getAuthToken();
        Response response =RestClient.doGet(null,"https://api.imgur.com","/3/account/me/images",authTokenMap,null,true);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

    }

    @Test
    public void uploadImagePostAPITest(){
        //The image will be uploaded to their server directly you won't be able to see it in its website
        //Will be uploaded to some link given after pretty print in the response like this "link": "https://i.imgur.com/JkKG2Mt.jpg"

        //Multipath is the content type for image
        Map<String,String> clientIdMap =Token.getClientId();

        //Body is in the form of form data
        Map<String,String> formMap = new HashMap<String, String>();
        formMap.put("title", "test title API");
        formMap.put("description","test description API");

        Response response=RestClient.doPost("multipart","https://api.imgur.com","/3/image",clientIdMap,null,true,formMap);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

    }



}
