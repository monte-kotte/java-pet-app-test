package monte.test.model;

public record PetRequest(
        String name,
        PetType type,   // cat, dog, rabbit
        int age
) { }

