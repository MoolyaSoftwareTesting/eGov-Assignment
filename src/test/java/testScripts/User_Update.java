package testScripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class User_Update {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test(groups = {"positive"})
    public void userUpdate(){
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
                "    \"authToken\": \"accessToken\"\n" +
                "  },\n" +
                "  \"Users\": [\n" +
                "    {\n" +
                "      \"tenantId\": \"string\",\n" +
                "      \"id\": 0,\n" +
                "      \"userName\": \"string\",\n" +
                "      \"authToken\": \"string\",\n" +
                "      \"salutation\": \"string\",\n" +
                "      \"name\": \"string\",\n" +
                "      \"gender\": \"string\",\n" +
                "      \"mobileNumber\": \"9876{{__random(100000, 999999)}}\",\n" +
                "      \"emailId\": \"string\",\n" +
                "      \"aadhaarNumber\": \"4\",\n" +
                "      \"active\": true,\n" +
                "      \"locale\": \"string\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"accountLocked\": false,\n" +
                "      \"roles\": [\n" +
                "        {\n" +
                "          \"name\": \"string\",\n" +
                "          \"description\": \"string\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"userDetails\": {\n" +
                "        \"firstName\": \"string\",\n" +
                "        \"middleName\": \"string\",\n" +
                "        \"lastName\": \"string\",\n" +
                "        \"dob\": \"2023-12-27\",\n" +
                "        \"altContactNumber\": \"string\",\n" +
                "        \"fatherName\": \"string\",\n" +
                "        \"husbandName\": \"string\",\n" +
                "        \"bloodGroup\": \"str\",\n" +
                "        \"pan\": \"string\",\n" +
                "        \"permanentAddress\": \"string\",\n" +
                "        \"permanentCity\": \"string\",\n" +
                "        \"permanentPincode\": \"string\",\n" +
                "        \"correspondenceCity\": \"string\",\n" +
                "        \"correspondencePincode\": \"string\",\n" +
                "        \"correspondenceAddress\": \"string\",\n" +
                "        \"signature\": \"string\",\n" +
                "        \"identificationMark\": \"string\",\n" +
                "        \"photo\": \"string\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                    .post("/users/v110/_update")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().header("Content-Type", "application/json");

    }

    @Test(groups = {"negative"})
    public void userUpdate_MissingMandatoryFields(){
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
                "  \"Users\": [\n" +
                "    {\n" +
                "      \"tenantId\": \"pg.citya\",\n" +
                "      \"id\": 0,\n" +
                "      \"userDetails\": {\n" +
                "        \"firstName\": \"string\",\n" +
                "        \"middleName\": \"string\",\n" +
                "        \"lastName\": \"string\",\n" +
                "        \"correspondenceCity\": \"string\",\n" +
                "        \"correspondencePincode\": \"string\",\n" +
                "        \"correspondenceAddress\": \"string\",\n" +
                "        \"signature\": \"string\",\n" +
                "        \"identificationMark\": \"string\",\n" +
                "        \"photo\": \"string\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                .post("/users/v110/_update")
                .then()
               .statusCode(400)
                .statusLine("HTTP/1.1 400 Bad Request")
                .assertThat().header("Content-Type", "application/json");

    }

}
