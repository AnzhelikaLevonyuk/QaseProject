package models;

import enums.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class TestCase {
    private String title;
    @EqualsAndHashCode.Exclude
    private Status status;
    private String description;
    @EqualsAndHashCode.Exclude
    private Severity severity;
    @EqualsAndHashCode.Exclude
    private Priority priority;
    @EqualsAndHashCode.Exclude
    private Type type;
    @EqualsAndHashCode.Exclude
    private Layer layer;
    @EqualsAndHashCode.Exclude
    private IsFlaky isFlaky;
    @EqualsAndHashCode.Exclude
    private Behavior behavior;
    @EqualsAndHashCode.Exclude
    private AutomationStatus automationStatus;
    private String preConditions;
    private String postConditions;
    private String parameterTitle;
    private String parameterValue;
    @EqualsAndHashCode.Exclude
    private String stepAction;
    @EqualsAndHashCode.Exclude
    private String data;
    @EqualsAndHashCode.Exclude
    private String expectedResult;
}




