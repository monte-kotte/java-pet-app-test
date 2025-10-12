package monte.test;

import monte.test.base.AbstractTest;
import monte.test.model.PetRequest;
import monte.test.model.PetResponse;
import monte.test.utils.PetDataGenerator;
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
