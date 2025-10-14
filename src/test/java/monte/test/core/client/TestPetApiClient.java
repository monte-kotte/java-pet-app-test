package monte.test.core.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import monte.test.core.model.api.PetRequest;
import monte.test.core.utils.ConfigFileReader;

public class TestPetApiClient {

    private final String petServiceUrl = ConfigFileReader.getPetServiceUrl();
    private final String petServiceEndpoint = ConfigFileReader.getPetServiceEndpoint();

    private final RequestSpecification requestSpec;

    public TestPetApiClient() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(petServiceUrl)
                .setContentType(ContentType.JSON)
                .build();
    }

    // ------------------- CREATE -------------------
    public Response createPet(PetRequest request) {
        return RestAssured.given(requestSpec)
                .body(request)
                .post(petServiceEndpoint)
                .then()
                .extract()
                .response();
    }

    // ------------------- GET BY ID -------------------
    public Response getPetById(String id) {
        return RestAssured.given(requestSpec)
                .get(petServiceEndpoint + "/" + id)
                .then()
                .extract()
                .response();
    }

    // ------------------- GET ALL -------------------
    public Response getAllPets() {
        return RestAssured.given(requestSpec)
                .get(petServiceEndpoint)
                .then()
                .extract()
                .response();
    }

    // ------------------- UPDATE -------------------
    public Response updatePet(String id, PetRequest request) {
        return RestAssured.given(requestSpec)
                .body(request)
                .put(petServiceEndpoint + "/" + id)
                .then()
                .extract()
                .response();
    }

    // ------------------- DELETE -------------------
    public Response deletePet(String id) {
        return RestAssured.given(requestSpec)
                .delete(petServiceEndpoint + "/" + id)
                .then()
                .extract()
                .response();
    }
}
