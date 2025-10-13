package monte.test.core.model.api;
import lombok.Builder;
import lombok.With;

@Builder
@With
public record PetRequest(
        String name,
        PetType type,
        int age
) { }
