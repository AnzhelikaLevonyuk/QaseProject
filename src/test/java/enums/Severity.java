package enums;

import java.util.Arrays;

public enum Severity {
    NOT_SET("Not set"),
    BLOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    NORMAL("Normal"),
    MINOR("Minor"),
    TRIVIAL("Trivial");

    private final String name;

    Severity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Severity getFromName(String name) {
        return Arrays.stream(Severity.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
