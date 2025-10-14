package monte.test.core.utils;

import io.restassured.response.Response;
import monte.test.core.client.TestPetApiClient;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTestHelper {

    private final TestPetApiClient petApiClient;

    public PetTestHelper(TestPetApiClient petApiClient) {
        this.petApiClient = petApiClient;
    }

    /**
     * Creates a new pet with random data and asserts that creation succeeded.
     *
     * @return the created PetResponse object
     */
    public PetResponse createTestPet() {
        PetRequest request = PetDataGenerator.randomPet();
        Response response = petApiClient.createPet(request);
        assertThat(response.statusCode())
                .as("Pet creation should return 201")
                .isEqualTo(201);

        return response.body().as(PetResponse.class);
    }

    /**
     * Deletes a pet and validates the response.
     */
    public void deleteTestPet(String petId) {
        Response response = petApiClient.deletePet(petId);
        assertThat(response.statusCode())
                .as("Pet deletion should return 200 or 204")
                .isIn(200, 204);
    }
}
