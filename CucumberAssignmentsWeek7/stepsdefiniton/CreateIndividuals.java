package stepsdefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateIndividuals extends SalesForceBaseClass {
	
	public static String lName;
	
	@And ("click Individuals   from App Launcher")
	public void individualsLauncher() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("individuals");
		WebElement clk = driver.findElement(By.xpath("//p[@class='slds-truncate']"));
        driver.executeScript("arguments[0].click();", clk);
	}
	@And ("Click on the Individuals tab")
	public void individulsTab()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Individuals')]")).click();
	}
	@And ("Click on New Individual")
	public void newIndividual()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	@And ("Enter the Last Name {string}")
	public void lastName(String name)
	{
		WebElement lNameEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lNameEle.sendKeys(name);
		lName = lNameEle.getAttribute("value");
		System.out.println(lName);
		
	}
	@And ("Click save Individual")
	public void save()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click(); 
	}
	@Then ("Verify Individuals Name")
	public void verify() throws InterruptedException
		{
		Thread.sleep(3000);
		String verifyLastName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		if(verifyLastName.contains(lName))
		{
			System.out.println("Name is matched");
		}
		else
		{
			System.out.println("Name is not matched");
		}
	}

}