package stepsdefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewDashboard extends SalesForceBaseClass {
	
	@And ("click Dashboards  from App Launcher")
	public void clickDashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("dashboard");
		//driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		//driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container']")).click();
		WebElement clk = driver.findElement(By.xpath("//p[@class='slds-truncate']"));
        driver.executeScript("arguments[0].click();", clk);
	}
        @When("Click on the New Dashboard option")
        public void clickOnTheNewDashboardOption() throws InterruptedException {
        	Thread.sleep(4000);
            driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
        }
        @When("Enter Name as {string}")
        public void enterNameAs(String name) throws InterruptedException {
        	Thread.sleep(3000);
        	driver.switchTo().frame(0);
        	driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(name);
            
        }
        @When("Click on Create")
        public void clickOnCreate() throws InterruptedException {
        	Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Create']")).click();
        }
        @When("Click on Save")
        public void clickOnSave() throws InterruptedException {
        	Thread.sleep(4000);
        	driver.switchTo().frame(0);
        	Thread.sleep(4000);
        	driver.findElement(By.xpath("//button[text()='Save']")).click(); 
        }
        @Then("Verify Dashboard name")
        public void verifyDashboardName() throws InterruptedException {
        Thread.sleep(1000);	
        String dashName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        if	(dashName.contains("Dashboard"))
        {
        	System.out.println("dashboard name is dispalyed");
        }
        else
        	System.out.println("Dashboard name is not displayed");
        }
	
}
