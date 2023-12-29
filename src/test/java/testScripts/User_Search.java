package testScripts;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class User_Search{


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test(groups = {"positive"})
    public void userSearch(){
        String jsonRequestBody = "{\n" +
                "  \"apiId\": \"string\",\n" +
                "  \"ver\": \"string\",\n" +
                "  \"ts\": 0,\n" +
                "  \"action\": \"string\",\n" +
                "  \"did\": \"string\",\n" +
                "  \"key\": \"string\",\n" +
                "  \"msgId\": \"string\",\n" +
                "  \"requesterId\": \"string\",\n" +
                "  \"authToken\": \"0b9cb5ce-dbf8-4fb0-b5d1-afc4c6f1bbe7\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                    .post("/users/v110/_search?tenantId=pb.amritsar&userName=ABC")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().header("Content-Type", "application/json");

    }

    @Test(groups = {"negative"})
    public void userSearch_MissingMandatoryFields(){
        String jsonRequestBody = "{\n" +
                "  \"apiId\": \"string\",\n" +
                "  \"ver\": \"string\",\n" +
                "  \"ts\": 0,\n" +
                "  \"action\": \"string\",\n" +
                "  \"did\": \"string\",\n" +
                "  \"key\": \"string\",\n" +
                "  \"msgId\": \"string\",\n" +
                "  \"requesterId\": \"string\",\n" +
                "  \"authToken\": \"0b9cb5ce-dbf8-4fb0-b5d1-afc4c6f1bbe7\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                .post("/users/v110/_search?userName=ABC")
                .then()
                .statusCode(400)
                .statusLine("HTTP/1.1 400 Bad Request")
                .assertThat().header("Content-Type", "application/json");

    }

}
