package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Project {
    private String name;
    private String code;
    @EqualsAndHashCode.Exclude
    private String description;
}
