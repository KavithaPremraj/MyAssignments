package ServicenowApp.testcase;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AssignIncident extends ServiceNowBaseClass {
	
@Test

	public  void runAssignIncident() throws InterruptedException {
	
	Thread.sleep(5000);
	WebElement search = shadowDriver.findElementByXPath("//input[@class='form-control']");
	search.sendKeys(""+incidentNum);
	Thread.sleep(4000);
	search.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[@aria-label='additional actions menu']")).click();
	driver.findElement(By.xpath("//div[text()='View']")).click();
	driver.findElement(By.xpath("//div[text()='Workspace']")).click();
	driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
         List<String> windowList = new ArrayList<String>(windowHandles);
         System.out.println(windowList.size());
		System.out.println(windowList);
		Thread.sleep(3000);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("software",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Software']")).click();

		driver.switchTo().window(windowList.get(0));
		Thread.sleep(3000);
		WebElement view1 = shadowDriver.findElementByXPath("//iframe");

	    driver.switchTo().frame(view1);

		WebElement a2 = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		




		shadowDriver.findElementByXPath("//textarea[@id='activity-stream-textarea']").sendKeys("This is a software group");
		Thread.sleep(10000);
		

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		

	 WebElement inci = driver.findElement(By.xpath("//input[@name='incident.number']"));

	 String att1 = inci.getAttribute("value");
	 System.out.println("The Incident Number is:"+att1);

	 WebElement assi = shadowDriver.findElementByXPath("//input[@id='sys_display.incident.assignment_group']");
	 String att2 = assi.getAttribute("value");
	 System.out.println("The assiged group is:" +att2);

	 if(incidentNum.equals(att1))
	 {
		 System.out.println("The assigned incident is verified");
	 }
	 else
	 {
		 System.out.println("The assigned incident is not verified");
	 }



	}

}