package monte.test.utils;

import monte.test.model.PetRequest;
import monte.test.model.PetType;

import java.util.concurrent.ThreadLocalRandom;

public class PetDataGenerator {

    private static final String[] NAMES = {
            "Fluffy", "Buddy", "Mittens", "Charlie", "Bella", "Coco", "Luna", "Max"
    };

    public static PetRequest randomPet() {
        String name = NAMES[ThreadLocalRandom.current().nextInt(NAMES.length)];
        PetType type = PetType.random();
        int age = ThreadLocalRandom.current().nextInt(1, 15); // 1-14 years
        return new PetRequest(name, type, age);
    }
}
