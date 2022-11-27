package test;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExample {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[1].first_name",equalTo("Lindsay")).
                body("data.first_name",hasItems("George","Lindsay"));
    }

    @Test
    public void testPost(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        JSONObject request = new JSONObject(map);
        System.out.println(request);

        baseURI = "https://reqres.in/api";
        given().
        header("Content-Type","application/json").
        contentType(ContentType.JSON).
        accept(ContentType.JSON).
        body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();

    }
}
