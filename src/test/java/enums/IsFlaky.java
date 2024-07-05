package enums;

import java.util.Arrays;

public enum IsFlaky {
    YES("Yes"),
    NO("No");

    private final String name;

    IsFlaky(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static IsFlaky getFromName(String name) {
        return Arrays.stream(IsFlaky.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
