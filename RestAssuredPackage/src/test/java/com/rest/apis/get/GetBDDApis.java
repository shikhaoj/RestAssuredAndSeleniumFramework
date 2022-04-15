package com.rest.apis.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBDDApis {
    //REST ASSURED BDD: Since we are using given when and then it's a BDD approach
    /*given()
        when()
            then()
                and()*/
    @Test
    public void getAPICircuitTest_1(){
        given().log().all()
                .when().log().all()
                .get("http://ergast.com/api/f1/2017/circuits.json")
                .then().log().all()
                .assertThat()
                .body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));

    }
    @Test
    public void getAPICircuitTest_2(){
        //MORE PREFERABLE AS YOU CAN DO A LOT MANY THINGS WHILE YOU GET THE RESPONSE
        Response response=
        given().log().all()
                .when().log().all()
                .get("http://ergast.com/api/f1/2017/circuits.json");
                int statusCodeOfResponse=response.statusCode();
                System.out.println("api response status code: "+statusCodeOfResponse);
        Assert.assertEquals(statusCodeOfResponse,200);
        System.out.println(response.prettyPrint());
    }
    @Test
    public void getAPICircuitsTest_contentLength(){
        //from given() upto get() it is a response and then() is the separator
        RestAssured.baseURI="http://ergast.com";
        given().log().all()
                .when().log().all()
                .get("/api/f1/2017/circuits.json")//service url
        .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("Content-Length",equalTo("4551"));
                //.header("User-Agent",equalTo("PostmanRuntime/7.29.0"));
    }
    @Test
    //query parameter '?' and path parameter '/'
    //Trying to hit this api with query parameter along with rest assured and what to verify wheather the value of md5 is correct or not
    public void getJsonAPI_VerifyMD5Value(){
        String paramValue="test";
        String expectedMd5Value="098f6bcd4621d373cade4e832627b4f6";
        given().log().all()
                .param("text",paramValue)
                .when().log().all()
                .get("http://md5.jsontest.com")
                .then().log().all()
                .assertThat()
                .body("md5",equalTo(expectedMd5Value));
    }
    //2017--20 Circuits
    //2016--21 Circuits
    //1966--9 Circuits
    //Rather than writing 3 seperate test cases can write a single one by using a dataProvider
    //2-D Object Array is the return type of dataprovider
    @DataProvider(name = "getCircuitYearData")
    public Object[][] getCircuitYearInfo(){
        return new Object[][]{
                {"2017",20},
                {"2016",21},
                {"1996",16}
        };
    }
    @Test(dataProvider = "getCircuitYearData")
    //Mapping the dataProvider with the test script by passing the parameters
    public void numberOfCircuitsYearTest(String seasonYear,int circuitNumber){
        given().log().all()
                .pathParam("raceSeason",seasonYear)
                .when().log().all()
                //removing the hardCoded code
                .get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
                .then().log().all()
                .assertThat()
                .body("MRData.CircuitTable.Circuits.circuitId",hasSize(circuitNumber));
    }

    @Test
    public void getUserResponseXml_Test(){
        RestAssured.baseURI="https://gorest.co.in";
        Response response= given().log().all()
                        //.contentType("application/json")
                        .header("Authorization","Bearer a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8")
                        .header("Accept","application/xml")
                        .when().log().all()
                        .get("/public-api/users?last_name=Kuhn&first_name=Alvina");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

        XmlPath xmlPath =response.xmlPath();
        String totalValue=xmlPath.get("response.pagination.total");
        System.out.println("total value : "+totalValue);

        Assert.assertEquals(totalValue,12);

    }
}

