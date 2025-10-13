package monte.test.spec.rest.base;

import monte.test.core.client.TestPetApiClient;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected TestPetApiClient petApiClient;

    @BeforeClass
    public void setup() {
        petApiClient = new TestPetApiClient();
    }
}
