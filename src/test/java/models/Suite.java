package models;

import enums.ParentSuite;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Suite {

    private String suiteName;

    @EqualsAndHashCode.Exclude
    private ParentSuite parentSuite;

    private String description;

    @EqualsAndHashCode.Exclude
    private String preconditions;
}
