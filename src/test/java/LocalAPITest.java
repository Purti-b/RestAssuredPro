import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class LocalAPITest {

    //@Test
    public void GetLocal(){

        baseURI="http://localhost:3000/";
        given().
            get("/users").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void PostLocal(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "James");
        map.put("LastName", "Bond");

        JSONObject request = new JSONObject(map);

        baseURI="http://localhost:3000/";
        given().
               contentType(ContentType.JSON).
               accept(ContentType.JSON).
               body(request.toJSONString()).
        when().
              post("/users").
        then().
              statusCode(201);
    }

    @Test
    public void PutLocal(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Jameson");
        map.put("LastName", "Bond");

        JSONObject request = new JSONObject(map);

        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200);
    }

    @Test
    public void DeleteLocal(){

        baseURI="http://localhost:3000/";

        when().delete("/users/2").then().statusCode(200);
    }
}
