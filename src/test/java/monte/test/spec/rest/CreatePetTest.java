package monte.test.spec.rest;

import monte.test.spec.rest.base.AbstractTest;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetResponse;
import monte.test.core.utils.PetDataGenerator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePetTest extends AbstractTest {

    @Test
    public void testCreatePet() {
        // Prepare request data
        PetRequest request = PetDataGenerator.randomPet();

        // Create pet via API client
        PetResponse response = petApiClient.createPet(request);

        // Assertions
        assertThat(response).isNotNull();
        assertThat(response.petId()).isGreaterThan(0);
        assertThat(response.name()).isEqualTo(request.name());
        assertThat(response.type()).isEqualTo(request.type());
        assertThat(response.age()).isEqualTo(request.age());
    }
}
