package monte.test.core.utils;

import io.restassured.response.Response;
import monte.test.core.client.PetApiClient;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTestApiHelper {

    private final PetApiClient petApiClient;

    public PetTestApiHelper(PetApiClient petApiClient) {
        this.petApiClient = petApiClient;
    }

    public PetResponse createTestPet() {
        PetRequest request = PetDataGenerator.randomPet();
        Response response = petApiClient.createPet(request);
        assertThat(response.statusCode())
                .as("Pet creation should return 201")
                .isEqualTo(201);

        return response.body().as(PetResponse.class);
    }

    public void deleteTestPet(String petId) {
        Response response = petApiClient.deletePet(petId);
        assertThat(response.statusCode())
                .as("Pet deletion should return 200 or 204")
                .isIn(200, 204);
    }
}
