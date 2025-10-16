package monte.test.spec.rest;

import io.restassured.response.Response;
import monte.test.core.model.api.PetResponse;
import monte.test.spec.rest.base.AbstractTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetPetTest extends AbstractTest {

    @Test
    public void testGetPetByPetId() {
        // Given a pet created
        PetResponse createdPet = petHelper.createTestPet();
        String petId = createdPet.petId();

        // Get pet by id
        Response response = petApiClient.getPetById(petId);

        // Asserting response
        assertThat(response.statusCode())
                .isEqualTo(200);

        PetResponse petResponse = response
                .body()
                .as(PetResponse.class);

        assertThat(petResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(createdPet);
    }
}
