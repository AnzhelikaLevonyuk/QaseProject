package enums;

import java.util.Arrays;

public enum Type {
    OTHER("Other"),
    FUNCTIONAL("Functional"),
    SMOKE("Smoke"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    USABILITY("Usability"),
    PERFORMANCE("Performance"),
    ACCEPTANCE("Acceptance"),
    COMPATIBILITY("Compatibility"),
    INTEGRATION("Integration"),
    EXPLORATORY("Exploratory");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Type getFromName(String name) {
        return Arrays.stream(Type.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
