package automationSample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class hello {
    @Test
    void getPetDetailsTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
        final RequestSpecification httpRequest = RestAssured.given();
        final Response response = httpRequest.request(Method.GET, "1774313072");
        final int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);

    };

    @Test
    void postPetDetailsTest() {

        final String NAME = "hippo";
        final String STATUS = "available";
        final String PHOTO_URL = "www.myphoto.com";

        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        final RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        /** Build out Our Pet Object using the PetShope API Specification */
        final JSONObject category = new JSONObject();
        category.put("id", 100);
        category.put("name", "cuddly");

        final JSONArray tags = new JSONArray();

        final JSONArray photoUrls = new JSONArray();
        photoUrls.add(PHOTO_URL);

        final JSONObject pet = new JSONObject();
        pet.put("id", 0);
        pet.put("name", NAME);
        pet.put("status", STATUS);
        pet.put("tags", tags);
        pet.put("photoUrls", photoUrls);
        pet.put("category", category);
        /*****************************************************************/

        httpRequest.body(pet.toJSONString());
        final Response response = httpRequest.request(Method.POST);
        final int statusCode = response.getStatusCode();

        // PET API uses 200 instead of 201 for successful POST
        assertEquals(statusCode, 200);

        // Use JSON Path to Verify Specific Info
        final JsonPath petResponse = response.jsonPath();

        final String name = petResponse.get("name");
        assertEquals(name, NAME);

        final String status = petResponse.get("status");
        assertEquals(status, STATUS);

        final ArrayList photos = petResponse.get("photoUrls");
        assertEquals(photos.size(), 1);
        assertEquals(photos.get(0), PHOTO_URL);

        
    }
}