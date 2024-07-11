package enums;

import java.util.Arrays;

public enum ParentSuite {
    PROJECT_ROOT("Project root"),
    TEST_SUITE("TestSuite");
    private final String name;

    ParentSuite(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ParentSuite getFromName(String name) {
        return Arrays.stream(ParentSuite.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
