package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class EditLead2 extends LeafTapsBaseClass1  {

	@When("Click Find leads")
	public void clickFindLeads() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	    
	}
	@When("Enter first name")
	public void enterFirstName() {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Kavitha");
	}
	@When("Click Find leads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@When("Click on first resulting lead")
	public void clickOnFirstResultingLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
	}
	@When("Verify title of the page")
	public void verifyTitleOfThePage() {
		driver.findElement(By.xpath("//div[text()='View Lead']"));
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("The Tittle contains \" View Lead \" ");
		}
		else
		 System.out.println("Page title doesn't contains \" View Lead \" ");
	}
	@When("Click Edit")
	public void clickEdit() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	@When("Change the company name")
	public void changeTheCompanyName() {
		driver.findElement(By.xpath("//td/input[@name='companyName']")).clear();
		driver.findElement(By.xpath("//td/input[@name='companyName']")).sendKeys("HCLTechnologies");
	}
	@When("Click Update")
	public void clickUpdate() {
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();
	}
	@Then("Confirm the changed name appears")
	public void confirmTheChangedNameAppears() {
		String changeName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String newName = changeName.replaceAll("[^a-zA-Z]", "");
		System.out.println(newName);
	}
}
