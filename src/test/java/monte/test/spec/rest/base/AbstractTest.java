package monte.test.spec.rest.base;

import monte.test.core.client.PetApiClient;
import monte.test.core.utils.PetTestApiHelper;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected PetApiClient petApiClient;
    protected PetTestApiHelper petHelper;

    @BeforeClass
    public void setup() {
        petApiClient = new PetApiClient();
        petHelper = new PetTestApiHelper(petApiClient);
    }
}
