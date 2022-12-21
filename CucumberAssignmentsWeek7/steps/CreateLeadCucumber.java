package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadCucumber extends LeafTapsBaseClass1 {
	
	
	@When("Click on the CRMSFA link")
	public void crmsfa()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@And("Click on the leads")
	public void leads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click on the Create Leads")
	public void createLeads()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@And("Enter the CompanyName")
	public void companyName()
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
	}
	@And("Enter the firstName")
	public void firstName()
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavitha");
	}
	@And("Enter the LastName")
	public void lastName()
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Marimuthu");
	}
	@When("Click submit button")
	public void submit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("Verify the Viewlead page should be displayed")
	public void viewLeadPage()
	{
		String createleadtittle = driver.getTitle();
		System.out.println("The Tittle is :" + createleadtittle);
	}
	
	
	
	
	

}
