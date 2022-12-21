package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.LeafTapsBaseClass1;

@CucumberOptions(features = "src/test/java/feature/deleteLead.feature",
						glue = "steps",
						monochrome = true,
						publish = true
						//dryRun = true, snippets = SnippetType.CAMELCASE
						)
public class RunLeafTaps extends LeafTapsBaseClass1 {
	

}
