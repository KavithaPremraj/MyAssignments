package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DuplicateLead extends LeafTapsBaseClass1 {
	
	//public static String pnum;
	@When("Click phone")
	public void clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@When("Enter phone number as {string}")
	public void enterPhoneNumber(String pnum) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
	}
	@When("Click Find Leads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@And ("Click Duplicate Lead")
	public void clickDuplicate()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@Then("Verify the Tittle page")
	public void verifyTheTittlePage() {
		String duplicatetittle = driver.getTitle();
		System.out.println("The Tittle is :" + duplicatetittle);
	}

}
