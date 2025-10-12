package monte.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PetResponse(
        @JsonProperty("_id") String id,
        Long petId,
        String name,
        PetType type,
        int age,
        String createdAt,
        String updatedAt
) { }
