package test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PatchAndDeleteExample {

    @Test
    public void testPut(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        JSONObject request = new JSONObject(map);
        System.out.println(request);

        baseURI = "https://reqres.in";
        given().
            header("Content-Type","application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/api/users/2").
        then().
            statusCode(200).
            log().all();

    }

    @Test
    public void testPatch(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "morpheuss");
        map.put("job", "leaders");

        JSONObject request = new JSONObject(map);
        System.out.println(request);

        baseURI = "https://reqres.in";
        given().
            header("Content-Type","application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/api/users/2").
        then().
            statusCode(200).
            log().all();

    }


    @Test
    public void testDelete(){

        baseURI = "https://reqres.in";
        given().
        when().
            delete("/api/users/2").
        then().
            statusCode(204).
            log().all();

    }
}
