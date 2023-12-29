package testScripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;


import static io.restassured.RestAssured.*;

public class User_Create{

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }


    @Test(groups = {"positive"})
    public void userCreate(){
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
                "      \"userName\": \"user_{{__randomString(5)}}\",\n" +
                "      \"salutation\": \"Miss\",\n" +
                "      \"name\": \"Lata\",\n" +
                "      \"gender\": \"Female\",\n" +
                "      \"mobileNumber\": \"9876{{__random(100000, 999999)}}\",\n" +
                "      \"emailId\": \"lata@abc.com\",\n" +
                "      \"aadhaarNumber\": \"2\",\n" +
                "      \"active\": true,\n" +
                "      \"locale\": \"en_IN\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"accountLocked\": false,\n" +
                "      \"roles\": [\n" +
                "        {\n" +
                "          \"name\": \"string\",\n" +
                "          \"description\": \"string\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"userDetails\": {\n" +
                "        \"firstName\": \"abc_{{__randomString(5)}}\",\n" +
                "        \"middleName\": \"Ganesh\",\n" +
                "        \"lastName\": \"Naik\",\n" +
                "        \"dob\": \"2023-12-27\",\n" +
                "        \"altContactNumber\": \"string\",\n" +
                "        \"fatherName\": \"Ganesh\",\n" +
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
                    .post("/users/v110/_create")
                .then()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 OK")
                .assertThat()
                .header("Content-Type", "application/json");

    }

    @Test(groups = {"negative"})
    public void userCreate_withPartialInfo(){

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
                "      \"accountLocked\": false,\n" +
                "      \"roles\": [\n" +
                "        {\n" +
                "          \"name\": \"string\",\n" +
                "          \"description\": \"string\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"userDetails\": {\n" +
                "        \"firstName\": \"abc_{{__randomString(5)}}\",\n" +
                "        \"middleName\": \"Ganesh\",\n" +
                "        \"lastName\": \"Naik\",\n" +
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
                .post("/users/v110/_create")
                .then()
                .statusCode(400)
                .statusLine("HTTP/1.1 400 Bad Request")
                .assertThat().header("Content-Type", "application/json");

    }

    @Test(groups = {"negative"})
    public void userCreate_invalidEmployeeRole(){

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
                "      \"userName\": \"user_{{__randomString(5)}}\",\n" +
                "      \"salutation\": \"Miss\",\n" +
                "      \"name\": \"Lata\",\n" +
                "      \"gender\": \"Female\",\n" +
                "      \"mobileNumber\": \"9876{{__random(100000, 999999)}}\",\n" +
                "      \"emailId\": \"lata@abc.com\",\n" +
                "      \"aadhaarNumber\": \"2\",\n" +
                "      \"active\": true,\n" +
                "      \"locale\": \"en_IN\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"accountLocked\": false,\n" +
                "      \"roles\": [\n" +
                "        {\n" +
                "          \"name\": \"string\",\n" +
                "          \"description\": \"string\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"userDetails\": {\n" +
                "        \"firstName\": \"abc_{{__randomString(5)}}\",\n" +
                "        \"middleName\": \"Ganesh\",\n" +
                "        \"lastName\": \"Naik\",\n" +
                "        \"dob\": \"2023-12-27\",\n" +
                "        \"altContactNumber\": \"string\",\n" +
                "        \"fatherName\": \"Ganesh\",\n" +
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
                .post("/users/v110/_create")
                .then()
                .statusCode(401)
                .statusLine("HTTP/1.1 401 Unauthorized")
                .assertThat().header("Content-Type", "application/json");

    }


}
