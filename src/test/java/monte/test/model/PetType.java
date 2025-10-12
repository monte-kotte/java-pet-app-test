package monte.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

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
