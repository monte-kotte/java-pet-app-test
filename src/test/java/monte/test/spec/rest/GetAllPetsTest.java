package monte.test.spec.rest;

import monte.test.spec.rest.base.AbstractTest;
import monte.test.core.model.api.PetResponse;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllPetsTest extends AbstractTest {

    @Test
    public void testGetAllPets() {
        // Call the client
        List<PetResponse> allPets = petApiClient.getAllPets();

        // Basic assertions
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isGreaterThanOrEqualTo(0);
    }
}
