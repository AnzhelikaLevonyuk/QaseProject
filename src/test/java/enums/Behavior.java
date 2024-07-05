package enums;

import java.util.Arrays;

public enum Behavior {
    NOT_SET("Not set"),
    POSITIVE("Positive"),
    NEGATIVE("Negative"),
    DESTRUCTIVE("Desctructive");

    private final String name;

    Behavior(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Behavior getFromName(String name) {
        return Arrays.stream(Behavior.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
