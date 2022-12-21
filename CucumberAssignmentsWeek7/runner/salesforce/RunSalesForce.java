package runner.salesforce;
import Hooks.SalesForceBaseClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;



@CucumberOptions(features = "src/test/java/salesforce/CreateAccount.feature",
						glue = "stepsdefiniton",
						monochrome = true,
						publish = true
						//dryRun = true, snippets = SnippetType.CAMELCASE
						)
public class RunSalesForce extends SalesForceBaseClass {
	

}
