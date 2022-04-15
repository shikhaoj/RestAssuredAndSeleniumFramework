package com.qa.api.gorest.tests;

import com.qa.api.gorest.restclient.RestClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GetUserTest {
    String baseURI="https://gorest.co.in";
    String basePath="/public-api/users";
    String token="a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8";

    @Test(priority = 1)
    public void getAllUserListAPITest(){
        //Here we have not directly used Token.getAuthToken() as its token is different those token were for imgur apis
        Map<String,String> authTokenMap = new HashMap<String,String>();
        authTokenMap.put("Authentication","Bearer "+token);
        Response response =RestClient.doGet("JSON",baseURI,basePath,authTokenMap,null,true);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test(priority = 2)
    public void getUserWithQueryParamsAPITest(){
        Map<String,String> authTokenMap = new HashMap<String,String>();
        authTokenMap.put("Authentication","Bearer "+token);

        Map<String,String> params = new HashMap<String, String>();
        params.put("first_name","John");
        params.put("gender","male");
        Response response =RestClient.doGet("JSON",baseURI,basePath,authTokenMap,params,true);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
}

