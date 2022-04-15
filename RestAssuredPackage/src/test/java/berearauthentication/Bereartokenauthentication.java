package berearauthentication;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Bereartokenauthentication {
    @Test
    public void tokenauthentication(){
        HashMap<String,String> hashmap=new HashMap<>();
        hashmap.put("name","morpheus");
        hashmap.put("job","leader");
        given()
                .auth().oauth2("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")
                .body(hashmap)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.github.com/user/repos")
                .then()
                .contentType(ContentType.JSON)
                .assertThat()
                .statusCode(201)
                .log().all();

    }
}
