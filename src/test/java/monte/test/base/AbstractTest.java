package monte.test.base;

import monte.test.client.TestPetApiClient;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected TestPetApiClient petApiClient;

    @BeforeClass
    public void setup() {
        petApiClient = new TestPetApiClient();
    }
}
