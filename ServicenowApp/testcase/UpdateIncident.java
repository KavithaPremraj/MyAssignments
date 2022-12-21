package ServicenowApp.testcase;

import java.time.Duration;
import java.util.List;

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

public class UpdateIncident extends ServiceNowBaseClass {

		
	@Test
	public  void runExistingIncident() throws InterruptedException {
		Thread.sleep(5000);
		WebElement search = shadowDriver.findElementByXPath("//input[@class='form-control']");
		search.sendKeys(""+incidentNum);
		Thread.sleep(4000);
		search.sendKeys(Keys.ENTER);
		System.out.println(incidentNum);
		Thread.sleep(4000);
			

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement findElement = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		//findElement.click();
        Select dd=new Select(findElement);
        dd.selectByVisibleText("1 - High");
        findElement.sendKeys(Keys.ENTER);
        WebElement findElement2 = driver.findElement(By.xpath("//select[@name='incident.urgency']/option[1]"));
       String a1= findElement2.getText();
       System.out.println("The urgency is:" +a1);


      WebElement findElement3 = driver.findElement(By.xpath("//select[@name='incident.state']"));
      Select dd1=new Select(findElement3);
      dd1.selectByVisibleText("In Progress");
      findElement3.sendKeys(Keys.ENTER);
      WebElement findElement4 = driver.findElement(By.xpath("//select[@name='incident.state']/option[2]"));
       String a2= findElement4.getText();
       System.out.println("The state is:" +a2);

     //update
     // driver.findElement(By.xpath("//button[text()='Update']")).click();
       shadowDriver.findElementByXPath("//button[@id='sysverb_update']").click();

       shadowDriver.findElementByXPath("//a[@class='linked formlink']").click();

       WebElement checkUrgency = shadowDriver.findElementByXPath("//select[@name='incident.urgency']/option[1]");
  String text = checkUrgency.getText();

  System.out.println(text);

  WebElement state = shadowDriver.findElementByXPath("//select[@name='incident.state']/option[2]");
  String text1 = state.getText();
  System.out.println(text1);
     if(a1.equals(text)||a2.equals(text1))
     {
    	 System.out.println("The urgency and state are verified");}
     else
    	 {
    		System.out.println("The urgency and state are not verified"); 
    	 }
     }
}