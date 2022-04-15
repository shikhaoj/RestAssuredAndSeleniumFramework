package com.qa.api.gorest.util;

import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Token {

    public static Map<Object,Object> appTokenMap;
    //Created this tokenMap to send the authorization in the header with "Authorization" as the key remaining as the value
    public static Map<String,String> tokenMap = new HashMap<String, String>();
    public static String clientId ="e2b77d1f0271ec3";

    public static Map<Object, Object> getAccessToken(){

        Map<String,String> formParameters = new HashMap<String,String>();
        formParameters.put("refresh_token", "7e99b56709d3665ded38547b8158aeb8f506e0b9");
        formParameters.put("client_id","e2b77d1f0271ec3");
        formParameters.put("client_secret","a9a93d386621f67d923b7f003e58c688c5eac526");
        formParameters.put("grant_type", "refresh_token");

        //tokenJson is having the complete json response with it
        JsonPath tokenJson=
        given()
                .formParams(formParameters)
                .when()
                .post("https://api.imgur.com/oauth2/token")
                .then()
                .extract()
                .jsonPath();

        //Under the .getMap() if you will pass empty string it means you want to print the whole json body
        //if passed some particular attribute then only that attribute value would have been printed
        System.out.println(tokenJson.getMap(""));
        appTokenMap=tokenJson.getMap("");
        return appTokenMap;
    }

    public static Map<String, String> getAuthToken(){
        String authToken=appTokenMap.get("access_token").toString();
        System.out.println("Auth token ====> "+authToken);
        tokenMap.put("Authorization", "Bearer "+authToken);
        return tokenMap;
    }

    public static Map<String, String> getClientId(){
        //Since we already have clientId , we are not getting it from response we no need to get it from appTokenMap
        System.out.println("Client id ====> "+ clientId);
        tokenMap.put("Authorization", "Client-ID "+clientId);
        return tokenMap;
    }

}
