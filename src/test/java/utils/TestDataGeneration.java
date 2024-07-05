package utils;

import com.github.javafaker.Faker;
import enums.*;
import models.Project;
import models.Suite;
import models.TestCase;

public class TestDataGeneration {
    static Faker faker = new Faker();

    public static Project generateProject() {
        return Project.builder()
                .setName(faker.animal().name() + faker.number().randomDigit())
                .setCode(String.valueOf(faker.number().numberBetween(10, 99)))
                .setDescription(faker.currency().name() + faker.number().randomDigit())
                .build();
    }

    public static TestCase generateTestCase() {
        return TestCase.builder()
                .setTitle(faker.country().name())
                .setStatus(Status.ACTUAL)
                .setDescription("Description for test-case")
                .setSeverity(Severity.CRITICAL)
                .setPriority(Priority.HIGH)
                .setType(Type.SMOKE)
                .setLayer(Layer.E2E)
                .setIsFlaky(IsFlaky.NO)
                .setBehavior(Behavior.POSITIVE)
                .setAutomationStatus(AutomationStatus.AUTOMATED)
                .setPreConditions("Pre-conditions")
                .setPostConditions("Post-conditions")
                .setParameterTitle("Parameter Title")
                .setParameterValue("Parameter Value")
                .setStepAction("Step Action")
                .setData("Data")
                .setExpectedResult("Expected result")
                .build();

    }

    public static Suite generateSuite() {
        return Suite.builder()
                .setSuiteName(faker.job().title() + faker.number().randomDigit())
                .setParentSuite(ParentSuite.PROJECT_ROOT)
                .setDescription(faker.currency().name() + faker.number().randomDigit())
                .setPreconditions(faker.country().name())
                .build();
    }
}
