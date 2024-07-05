package enums;

import java.util.Arrays;

public enum Layer {
    E2E("E2E"),
    API("API"),
    UNIT("Unit");

    private final String name;

    Layer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Layer getFromName(String name) {
        return Arrays.stream(Layer.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
