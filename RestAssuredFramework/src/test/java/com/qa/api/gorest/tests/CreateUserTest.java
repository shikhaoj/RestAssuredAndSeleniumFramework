package com.qa.api.gorest.tests;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateUserTest {


    String baseURI="https://gorest.co.in";
    String basePath="/public-api/users";
    String token="a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8";
    //public static Map<String,String> token=new HashMap<String, String>();

    @DataProvider
    //The return type of a dataProvider is a 2-d object array

    public Object[][] getUserData() throws IOException {
        Object userData[][]= ExcelUtil.getTestData("userdata");
        return userData;
    }

    @Test(dataProvider = "getUserData")//Made a connection of Test script with the data provider

    public void createUserAPIPOSTTest(String firstname, String lastname, String gender, String dob, String email,String phoneNumber , String website, String address, String status){

        //User user=new User("Adita","R","male","01-01-1999","adita@gmail.com","9898989999","http://www.aditya.com","tset address, bangalore","active");
        Map<String,String> authTokenMap = new HashMap<String,String>();
        authTokenMap.put("Authentication","Bearer "+token);

        User user=new User(firstname, lastname, gender, dob, email,phoneNumber , website, address, status);
        Response response=RestClient.doPost("JSON",baseURI,basePath,authTokenMap,null,true,user);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        System.out.println("========================================================");
    }

}
