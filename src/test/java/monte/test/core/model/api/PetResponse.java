package monte.test.core.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PetResponse(
        @JsonProperty("_id") String id,
        String petId,
        String name,
        PetType type,
        int age
) { }
