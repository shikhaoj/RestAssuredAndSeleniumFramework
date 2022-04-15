package com.qa.api.gorest.pojo;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserResultFinalPOJOComplexJson {

    @Test
    /**
     * This is the method where we are combining all the key-value pairs with parent or without parent together
     * We can also do this with the help of a tool which will be the last option i.e. "jsonschema2pojo" ,it will create all the classes as per the complex json on its own
     */
    public void createUserWithFullJSON() {
        String token="a93c92148b4a2a439422b7914d6b74cd810adafe5588ba621928b61679baf7b8";

        SelfComplexJson sf = new SelfComplexJson("http://www.sf.com");
        EditComplexJson ed = new EditComplexJson("http://www.ed.com");
        AvatarComplexJson av = new AvatarComplexJson("http://www.av.com");

        LinksComplexJSON ln = new LinksComplexJSON(sf, ed, av);

        UserInfoComplexJson uf = new UserInfoComplexJson("Tom", "Petter", "male", "09-09-1998", "tom11@gmail.com", "89898899", "http://www.tom12.com", "test address", "active", ln);

        String UserJsonPayload=TestUtil.getSerialization(uf);
        System.out.println(UserJsonPayload);

        Map<String,String> authTokenMap = new HashMap<String, String>();
        authTokenMap.put("Autorization", "Bearer "+token);

        Response response =RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", authTokenMap, null, true, UserJsonPayload);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
 }

}
