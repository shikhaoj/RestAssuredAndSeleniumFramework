package com.qa.api.gorest.restclient;

import com.qa.api.gorest.util.TestUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.Map;

/**
 * This class is having all http methods which will call the apis and having generic methods
 * for getting the response and fetch the values from response
 * @author Shikha Rani
 */
public class RestClient {

    //Whenever we create a RestClient we have to write
    //HTTP Methods: GET POST PUT DELETE

    //User will get confused if all the methods will be visible to him once he does "RestClient."
    //Hence , we are doing encapsulation here by making all the methods private except doGet which should be only visible to the client

    //All the below methods are wrappers

    /**
     * This method is used to call GET API
     * @param contentType
     * @param baseURI
     * @param basePath
     * @param token
     * @param paramsMap
     * @param log
     * @return this method is returning response from the GET call
     */

    public static Response doGet(String contentType, String baseURI, String basePath, Map<String,String> token, Map<String,String> paramsMap, boolean log){
        if(setBaseURI(baseURI)){
            //Preparing the request
            RequestSpecification request=createRequest(contentType, token, paramsMap, log);
            return getResponse("GET",request,basePath);
        }
        return null;
    }

    /**
     * This method is used to call POST API
     * @param contentType
     * @param baseURI
     * @param basePath
     * @param token
     * @param paramsMap
     * @param log
     * @param obj
     * @return this method is returning response from the POST call
     */

    public static Response doPost(String contentType, String baseURI, String basePath, Map<String,String> token, Map<String,String> paramsMap, boolean log, Object obj){
        //If base URI is not passed it will return null
        if(setBaseURI(baseURI)){
            //Preparing the request
            RequestSpecification request=createRequest(contentType, token, paramsMap, log);
            addRequestPayload(request,obj);
            return getResponse("POST",request,basePath);
        }
        return null;
    }

    /**
     * This method is for adding the payload by converting the POJO to JSON String using serialization
     * @param request
     * @param obj
     */
    public static void addRequestPayload(RequestSpecification request, Object obj){

        //If the passed object is the hashMap then we will use it a form parameters
        if(obj instanceof Map){
            request.formParams((Map<String,String>)obj);
        }else {
            String jsonPayload = TestUtil.getSerialization(obj);
            request.body(jsonPayload);
        }
    }

    /**
     * This method is for setting the base url
     * @param baseURI
     * @return
     */
    private static boolean setBaseURI(String baseURI){

        //In case null is passed as the baseURI
        if(baseURI==null || baseURI.isEmpty()){
            System.out.println("Please pass the correct baseURI.....either it is null or blank/empty....");
            return false;
        }

        //Hardly some exception will come but for safety we put the try and catch
        try {
            RestAssured.baseURI=baseURI;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method is for request creation
     * @param contentType
     * @param token
     * @param paramsMap
     * @param log
     * @return
     */
    private static RequestSpecification createRequest(String contentType, Map<String,String> token, Map<String,String> paramsMap, boolean log){

        RequestSpecification request;
        if(log){
            request= RestAssured.given().log().all();
        }else {
            request=RestAssured.given();
        }
        if (token.size()>0){
           // request.header("Authorization","Bearer "+token);
            // under headers we can pass the whole maps
            //Doing this as for imgur apis we have different Authorization some asking for client id or some for berear token etc.
            request.headers(token);
        }

        if(!(paramsMap==null)){
            request.queryParams(paramsMap);
        }

        if(contentType != null) {
            if (contentType.equalsIgnoreCase("JSON")) {
                request.contentType(ContentType.JSON);
            } else if (contentType.equalsIgnoreCase("XML")) {
                request.contentType(ContentType.XML);
            } else if (contentType.equalsIgnoreCase("TEXT")) {
                request.contentType(ContentType.TEXT);
            }
            //Interview type question what is the content type for an image
            else if (contentType.equalsIgnoreCase("multipart")) {
                request.multiPart("image", new File("/home/raramuri/Downloads/powerpuff_girls.jpeg"));
            }
        }

        return request;
    }

    /**
     * THis method is for getting the response
     * @param httpMethod
     * @param request
     * @param basePath
     * @return
     */

    private static Response getResponse(String httpMethod, RequestSpecification request, String basePath){
        return executeAPI(httpMethod,request,basePath);
    }

    /**
     * THis method is for executing the API calls
     * @param httpMethod
     * @param request
     * @param basePath
     * @return
     */
    private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath){
        Response response=null;
        switch (httpMethod){
            case "GET":
                response = request.get(basePath);
                break;
            case "POST":
                response = request.post(basePath);
                break;
            case "PUT":
                response = request.put(basePath);
                break;
            case "DELETE":
                response = request.delete(basePath);
                break;
            default:
                System.out.println("Please pass the correct http method....");
                break;
        }

        return response;
    }

}
