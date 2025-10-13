package monte.test.core.utils;

import monte.test.core.model.api.PetRequest;
import monte.test.core.model.api.PetType;

import java.util.concurrent.ThreadLocalRandom;

public class PetDataGenerator {

    private static final String[] NAMES = {
            "Fluffy", "Buddy", "Mittens", "Charlie", "Bella", "Coco", "Luna", "Max"
    };

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static PetRequest randomPet() {
        return PetRequest.builder()
                .name(randomName())
                .type(PetType.random())
                .age(randomAge())
                .build();
    }

    private static String randomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    private static int randomAge() {
        return RANDOM.nextInt(1, 15); // 1–14 years
    }
}
