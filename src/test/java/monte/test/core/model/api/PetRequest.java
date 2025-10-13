package monte.test.core.model.api;

public record PetRequest(
        String name,
        PetType type,   // cat, dog, rabbit
        int age
) { }

