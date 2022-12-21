package stepsdefiniton;

import org.openqa.selenium.By;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOppurtunityWithoutMandatoryFields extends SalesForceBaseClass{

	
	@When("Choose close date as Tommorow Date")
	public void choose_close_date_as_tommorow_date() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		//driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		driver.findElement(By.xpath("//table/thead/following::tr/td[@data-value='2022-12-29']")).click();
	}
	@Then("Verify the Alert message")
	public void alertMessage()
	{
		boolean alertMessage = driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).isDisplayed();
		if(alertMessage)
		{
			System.out.println("Alert Message is displayed");
		}
			else
			{
				System.out.println("Alert Message is not displayed");
		}
	}
}
