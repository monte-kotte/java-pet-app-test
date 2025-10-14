package monte.test.spec.rest.base;

import monte.test.core.client.TestPetApiClient;
import monte.test.core.utils.PetTestHelper;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected TestPetApiClient petApiClient;
    protected PetTestHelper petHelper;

    @BeforeClass
    public void setup() {
        petApiClient = new TestPetApiClient();
        petHelper = new PetTestHelper(petApiClient);
    }
}
