package testScripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class Nologin_Update {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test(groups = {"positive"})
    public void nologinPasswordUpdate(){
        String jsonRequestBody = "{\n" +
                "  \"RequestInfo\": {\n" +
                "    \"apiId\": \"string\",\n" +
                "    \"ver\": \"string\",\n" +
                "    \"ts\": 0,\n" +
                "    \"action\": \"string\",\n" +
                "    \"did\": \"string\",\n" +
                "    \"key\": \"string\",\n" +
                "    \"msgId\": \"string\",\n" +
                "    \"requesterId\": \"string\",\n" +
                "    \"authToken\": \"0b9cb5ce-dbf8-4fb0-b5d1-afc4c6f1bbe7\"\n" +
                "  },\n" +
                "  \"otpReference\": \"764537\",\n" +
                "  \"userName\": \"LATANAIK\",\n" +
                "  \"newPassword\": \"12345678\",\n" +
                "  \"tenantId\": \"string\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                .post("/users/v110/password/nologin/_update")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().header("Content-Type", "application/json");

    }

    @Test(groups = {"negative"})
    public void nologinPasswordUpdate_MissingMandatoryFields(){
        String jsonRequestBody = "{\n" +
                "  \"RequestInfo\": {\n" +
                "    \"apiId\": \"string\",\n" +
                "    \"ver\": \"string\",\n" +
                "    \"ts\": 0,\n" +
                "    \"action\": \"string\",\n" +
                "    \"did\": \"string\",\n" +
                "    \"key\": \"string\",\n" +
                "    \"msgId\": \"string\",\n" +
                "    \"requesterId\": \"string\",\n" +
                "    \"authToken\": \"string\"\n" +
                "  },\n" +
                "  \"tenantId\": \"pg.citya\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                .post("/users/v110/password/nologin/_update")
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 ")
                .assertThat().header("Content-Type", "application/json");

    }
}
