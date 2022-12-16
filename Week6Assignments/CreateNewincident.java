package Week6Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Marathonday3.ReadExcel1;

public class CreateNewincident extends ServiceNowBaseClass{
	
	@BeforeClass
	public void setData() {
		fileName = "Incident";
		sheetIndex = 0;
	}
	@Test(dataProvider ="fetchData")
	public void runCreateNewIncidenet (String description) throws InterruptedException {
		
		shadowDriver.findElementByXPath("//button[text()='New']").click();
		String newIncident = driver.findElement(By.xpath("//input[@type = 'text']")).getText();
		driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys(description);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		String incidentNum = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("New Incident is created");
		
	}

	
		
		
	
	}
		

	
	
		
		
		
		
		
		
	


