package enums;

import java.util.Arrays;

public enum AutomationStatus {
    NOT_AUTOMATED("Not automated"),
    TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private final String name;

    AutomationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static AutomationStatus getFromName(String name) {
        return Arrays.stream(AutomationStatus.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
