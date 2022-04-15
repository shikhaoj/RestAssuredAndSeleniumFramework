package com.rest.apis.get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

//In non-BDD approach we no need to remember the sequence of given, when,then etc
public class GetNonBDDApis {

    //prepare the request
    //hit the API
    //get the response
    //fetch the values from response

    @Test
    public void getUser_Non_Bdd_Test(){

        RestAssured.baseURI="https://gorest.co.in";

        //Preparing the request
        RequestSpecification request =RestAssured.given();
        request.header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8");
        //hitting the API and getting the response
        Response response =request.get("/public/v2/users/");
        //and then fetching the values from response
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        System.out.println(response.getHeader("Server"));


    }

    @Test
    public void getUser_Non_Bdd_WithQueryParams_Test(){

        RestAssured.baseURI="https://gorest.co.in";

        //Preparing the request
        RequestSpecification request =RestAssured.given();
        request.header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8");
        request.queryParam("first_name","John");
        request.queryParam("gender","male");
        //hitting the API and getting the response
        Response response =request.get("/public-api/users/");
        //and then fetching the values from response
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        System.out.println(response.getHeader("Server"));

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getHeader("Server"),"nginx");

    }

    //HashMap is non-synchronised as you can not handle the multithreading as updating ,reading and writing all can attack at the same time
    //While HashTable is synchronized so, we should use hashTable where multithreading is taking place
    //HashMap can be passed with null pointers and null values
    //HashTable can't be passed with null values and null pointers

    @Test
    //HashMaps are better in comparison with normal above queryParam method as these while we are using HashMaps we can not hardcoded parameters
    //Hence we always prefer HashMaps and in framework also we use it
    public void getUser_Non_Bdd_HashMap_QueryParams_Test(){

        RestAssured.baseURI="https://gorest.co.in";

        //Preparing the request
        RequestSpecification request =RestAssured.given();
        request.header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8");

        Map<String,String> params=new HashMap<String,String>();
        params.put("first_name","john");
        params.put("gender","female");
        //used the queryparams with map as a parameter
        request.queryParams(params);
        //hitting the API and getting the response
        Response response = request.get("/public-api/users/");
        //and then fetching the values from response
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        System.out.println(response.getHeader("Server"));
        System.out.println(response.getStatusLine());

        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getString("meta"));

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getHeader("Server"),"nginx");
    }
}

