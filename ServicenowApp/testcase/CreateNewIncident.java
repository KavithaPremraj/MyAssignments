package ServicenowApp.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Marathonday3.ReadExcel1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewIncident extends ServiceNowBaseClass {

	@BeforeClass
	public void setData() {
		fileName = "Incident";
		sheetIndex = 0;
	}
	@Test(dataProvider ="fetchData")
	public void runCreateNewIncidenet (String description) throws InterruptedException {
		{
			shadowDriver.findElementByXPath("//button[text()='New']").click();
			WebElement newIncident = driver.findElement(By.xpath("//input[@type = 'text']"));
			incidentNum = newIncident.getAttribute("value");
			
			driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys(description);
			driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
			//String incidentNum = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
			System.out.println("New Incident is created: " +incidentNum);
			Thread.sleep(5000);
			WebElement search = shadowDriver.findElementByXPath("//input[@class='form-control']");
			search.sendKeys(""+incidentNum);
			search.sendKeys(Keys.ENTER);

			Thread.sleep(2000);

			WebElement verify = shadowDriver.findElementByXPath("//a[@class='linked formlink']");
			String searchResult = verify.getText();

			System.out.println("The incident is:" + searchResult);
			if (incidentNum.equals(searchResult)){
				System.out.println("Verified successfully");
			} else {
				System.out.println("Verification Unsuccessful");

			}
		}
	}

}

	

		

	
	
		
		
		
		
		
		
	


