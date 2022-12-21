package stepsdefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Oppurtunity extends SalesForceBaseClass{

	public static String oppName;
	@When("Click on toggle menu button from the left corner")
	public void clickOnToggleMenuButtonFromTheLeftCorner() throws InterruptedException {
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(8000);
	}
	@When("Click view All")
	public void clickViewAllAndClickSalesFromAppLauncher() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
	}
	@And ("click Sales from App Launcher")
	public void clickSales()
	{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container']")).click();
		WebElement clk = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();", clk);
	}
	@When("Click on Opportunity tab")
	public void clickOnOpportunityTab() {
		driver.findElement(By.xpath("//div[text()='New']")).click(); 
	}
	@When("Enter Opportunity name as {string}")
	public void enterOpportunityNameAs(String name) {
		WebElement oppNameEle = driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[@class='slds-input']"));
		oppNameEle.sendKeys(name);
		 oppName = oppNameEle.getAttribute("value");
		 System.out.println(oppName);
	}
	@When("Choose close date as Today")
	public void chooseCloseDateAsToday() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		//driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		driver.findElement(By.xpath("//table/thead/following::tr/td[@data-value='2022-12-30']")).click();
	}
	@When("Select {string} as Need Analysis")
	public void selectAsNeedAnalysis(String needAnalysis) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='--None--']")).click();
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Needs Analysis']")).click();
		Thread.sleep(2000);
	}
	@When("Click Save")
	public void clickSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then("VerifyOppurtunity Name")
	public void verifyOppurtunityName() throws InterruptedException {
		Thread.sleep(4000);
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = msg.getText();
		//Soft
		/*if (verify.contains(oppName))
		{
			System.out.println("The opportunity name is matched");
		}
		else
		{
			System.out.println("The opportunity name is not matched");
		}*/
	

	}

	
}
