package ServicenowApp.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident extends ServiceNowBaseClass {
@Test
	public  void runDeleteIncident() throws InterruptedException {


		
	Thread.sleep(5000);
		WebElement search = shadowDriver.findElementByXPath("//input[@class='form-control']");
		search.sendKeys(""+incidentNum);
		Thread.sleep(4000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
		Thread.sleep(5000);

		//Capture Incident Number
		WebElement incident = driver.findElement(By.xpath("//input[@id='incident.number']"));
		incident.sendKeys(incidentNum);
		//String num1=incident.getAttribute("value");
		//System.out.println(num1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();

	

		WebElement delete = driver.findElement(By.xpath("//button[@class='btn btn-destructive']"));
		
		delete.click();

		Thread.sleep(8000);



		WebElement del = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String d=del.getText();
		System.out.println("The message is:"+d);

		if(d.contains("No records to display"))
		{
			System.out.println("The incident deleted is verified");
		}
		else
		{
			System.out.println("Not verified");

		}

		



	}

}