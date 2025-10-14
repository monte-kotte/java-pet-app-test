package monte.test.spec.rest;

import io.restassured.response.Response;
import monte.test.core.model.api.PetResponse;
import monte.test.spec.rest.base.AbstractTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllPetsTest extends AbstractTest {

    @Test
    public void testGetAllPets() {
        // Call the client
        Response response = petApiClient.getAllPets();

        // Asserting response
        assertThat(response.statusCode()).isEqualTo(200);

        PetResponse[] allPets = response
                .body()
                .as(PetResponse[].class);

        assertThat(allPets).isNotNull();
        assertThat(allPets.length).isGreaterThanOrEqualTo(0);
    }
}
