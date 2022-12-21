package stepsdefiniton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSalesforce extends SalesForceBaseClass{
	
	@When("Enter the Username")
	public void username()
	{
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
	}
	@And("Enter the password")
	public void password()
	{
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
	}
	@When("Click on the login button")
	public void clickOnTheLoginButton() {
		driver.findElement(By.id("Login")).click();
	}
	@Then("Verify home page is displayed")
	public void verifyHopePageIsDisplayed() {
	  boolean displayed = driver.findElement(By.xpath("//span[text()='Home']")).isDisplayed();
	  if(displayed)
	  {
		  System.out.println("Home Page is displayed");
	  }
	  else
		  System.out.println("Home Page is not displayed");
	}
		@Given("Enter the Wrong password")
	public void enterThePassword() {
			driver.findElement(By.id("password")).sendKeys("Testleaf321");	
	    
	}

	@But("Verify error page is displayed")
	public void errorPage()
	{
		String errorText = driver.findElement(By.id("error")).getText();
		System.out.println(errorText);
	}

	
}
