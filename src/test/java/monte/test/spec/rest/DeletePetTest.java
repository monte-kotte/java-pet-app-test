package monte.test.spec.rest;

import io.restassured.response.Response;
import monte.test.core.constants.ErrorMessages;
import monte.test.core.constants.DeleteMessages;
import monte.test.core.model.api.ErrorResponse;
import monte.test.core.model.api.DeleteResponse;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetResponse;
import monte.test.core.utils.PetDataGenerator;
import monte.test.spec.rest.base.AbstractTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletePetTest extends AbstractTest {

    @Test
    public void testDeletePet() {
        // Prepare request data
        PetRequest request = PetDataGenerator.randomPet();
        // Create a pet
        Response responseCreate = petApiClient.createPet(request);
        PetResponse createdPet = responseCreate
                .body()
                .as(PetResponse.class);

        String petId = createdPet.petId();

        // Delete the pet
        Response response = petApiClient.deletePet(petId);

        // Asserting deletion
        assertThat(response.statusCode())
                .isEqualTo(200);

        DeleteResponse deleteResponse = response
                .body()
                .as(DeleteResponse.class);

        assertThat(deleteResponse.message())
                .isEqualTo(DeleteMessages.PET_DELETED);

        // Verify that pet not found on get by id
        response = petApiClient.getPetById(petId);
        assertThat(response.statusCode())
                .isEqualTo(404);

        ErrorResponse errorResponse = response
                .body()
                .as(ErrorResponse.class);

        assertThat(errorResponse.message())
                .isEqualTo(ErrorMessages.PET_NOT_FOUND);
    }
}
