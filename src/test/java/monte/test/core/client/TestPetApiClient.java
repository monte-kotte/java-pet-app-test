package monte.test.core.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetResponse;
import monte.test.core.utils.ConfigFileReader;

import java.util.List;

public class TestPetApiClient {

    private final String petServiceUrl = ConfigFileReader.getPetServiceUrl();
    private final String petServiceEndpoint = ConfigFileReader.getPetServiceEndpoint();

    private final RequestSpecification requestSpec;

    public TestPetApiClient() {
        // Create a reusable instance of RequestSpecification
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(petServiceUrl)
                .setContentType(ContentType.JSON)
                .build();
    }

    // ------------------- CREATE -------------------
    public PetResponse createPet(PetRequest request) {
        return RestAssured.given(requestSpec)
                .body(request)
                .post(petServiceEndpoint)
                .then()
                .statusCode(201)
                .extract()
                .as(PetResponse.class);
    }

    // ------------------- GET BY ID -------------------
    public PetResponse getPetById(String id) {
        return RestAssured.given(requestSpec)
                .get(petServiceEndpoint + "/" + id)
                .then()
                .statusCode(200)
                .extract()
                .as(PetResponse.class);
    }

    // ------------------- GET ALL -------------------
    public List<PetResponse> getAllPets() {
        Response response = RestAssured.given(requestSpec)
                .get(petServiceEndpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getList("", PetResponse.class);
    }

    // ------------------- UPDATE -------------------
    public PetResponse updatePet(String id, PetRequest request) {
        return RestAssured.given(requestSpec)
                .body(request)
                .put(petServiceEndpoint + "/" + id)
                .then()
                .statusCode(200)
                .extract()
                .as(PetResponse.class);
    }

    // ------------------- DELETE -------------------
    public void deletePet(String id) {
        RestAssured.given(requestSpec)
                .delete(petServiceEndpoint + "/" + id)
                .then()
                .statusCode(204);
    }
}
