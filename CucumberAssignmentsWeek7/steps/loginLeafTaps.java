package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;

public class loginLeafTaps extends LeafTapsBaseClass1 {
	@And("Enter the Username as {string}")
	public void username( String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
	}
	@And("Enter the password as {string}")
	public void password(String pwd)
	{
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	@And("Click on the login button")
	public void login()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Verify the homepage should be displayed")
	public void verifyHomePage()
	{
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if(displayed) {
			System.out.println("Homepage is displayed");
		} else {
			System.out.println("Homepage is not displayed");
		}
	}
	@But("Verify the error message should be displayed")
	public void verifyErrorMessage() {
		String text = driver.findElement(By.id("errorDiv")).getText();
		System.out.println(text);
	}
}
