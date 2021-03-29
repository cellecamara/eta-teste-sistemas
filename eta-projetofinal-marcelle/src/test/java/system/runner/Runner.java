package system.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/system/resources/features",
    glue="system/stepDefinitions",
        tags = "@",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty",
        monochrome = true)

public class Runner {
}