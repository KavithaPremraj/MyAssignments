package Week6Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident extends ServiceNowBaseClass {
	 @SuppressWarnings("unlikely-arg-type")
		@Test
		public void runDeleteIncident() throws InterruptedException
		 {
				
				WebElement IncidenetEle1 = driver.findElement(By.xpath("//a[@class='linked formlink']"));
				IncidenetEle1.click();
				String IncidentNum = driver.findElement(By.id("incident.number")).getText();
				System.out.println(IncidentNum);
				System.out.println("To be Deleted :" + IncidentNum);
				shadowDriver.findElementByXPath("//button[text()='Delete']").click();
				driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
				List<WebElement> incidentList = driver.findElements(By.xpath("//a[@class='linked formlink']"));
				
				
				if(incidentList.contains(IncidentNum))
					
					{
						System.out.println("The Incident is not deleted");
					}else
					{
						System.out.println("The Incident is deleted");
					}
					
					
				}

}
