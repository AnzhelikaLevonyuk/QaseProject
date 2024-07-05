package enums;

import java.util.Arrays;

public enum Status {
    ACTUAL("Actual"),
    DRAFT("Draft"),
    DEPRECATED("Deprecated");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Status getFromName(String name) {
        return Arrays.stream(Status.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
