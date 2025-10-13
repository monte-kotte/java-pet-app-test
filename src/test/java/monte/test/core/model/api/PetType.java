package monte.test.core.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.ThreadLocalRandom;

public enum PetType {
    @JsonProperty("cat")
    CAT,
    @JsonProperty("dog")
    DOG,
    @JsonProperty("rabbit")
    RABBIT,
    @JsonProperty("not_existing_pet_type")
    NOT_EXISTING_PET_TYPE;

    public static PetType random() {
        PetType[] validValues = {CAT, DOG, RABBIT};
        return validValues[ThreadLocalRandom.current().nextInt(validValues.length)];
    }
}
