package monte.test.core.utils;

import com.github.javafaker.Faker;
import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetType;

import java.util.concurrent.ThreadLocalRandom;

public class PetDataGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final Faker FAKER = new Faker();

    public static PetRequest randomPet() {
        return PetRequest.builder()
                .name(randomName())
                .type(PetType.random())
                .age(randomAge())
                .build();
    }

    private static String randomName() {
        return FAKER.animal().name();
    }

    private static int randomAge() {
        return RANDOM.nextInt(1, 21);
    }
}
