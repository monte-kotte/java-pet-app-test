package monte.test.core.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PetType {
    @JsonProperty("cat")
    CAT,
    @JsonProperty("dog")
    DOG,
    @JsonProperty("rabbit")
    RABBIT;

    public static PetType random() {
        PetType[] values = PetType.values();
        return values[(int) (Math.random() * values.length)];
    }
}
