package enums;

import java.util.Arrays;

public enum Priority {
    NOT_SET("Not set"), HIGH("High"), MEDIUM("Medium"), LOW("Low");

    private final String name;

    Priority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Priority getFromName(String name) {
        return Arrays.stream(Priority.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
