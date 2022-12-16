package Week6Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends ServiceNowBaseClass {
	 
	 @Test
		public void runUpdateIncident() throws InterruptedException {
		//WebElement newInc = shadowDriver.findElementByXPath("//input[@placeholder='Search']");
		//newInc.sendKeys(incidentNum);
		//newInc.sendKeys(Keys.ENTER);
	WebElement IncidenetEle = driver.findElement(By.xpath("//a[@class='linked formlink']"));
	IncidenetEle.click();
	WebElement selectUrgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
	selectUrgency.click();
	Select dd1 = new Select(selectUrgency);
	dd1.selectByValue("1");
	
	WebElement selectState = driver.findElement(By.xpath("//select[@id='incident.state']"));
	selectState.click();
	Select dd2 = new Select(selectState);
	dd2.selectByValue("2");
	shadowDriver.findElementByXPath("//button[text()='Update']").click();
	System.out.println("The Incident is updated");
		
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	String Urgencytext = driver.findElement(By.xpath("//select[@choice='3']")).getText();
	 
	 if(Urgencytext.contains("High"))
	 {
		 System.out.println("Type is Matched");
	 }
	 else
	 {
		 System.out.println("Type is not Matched");
	 }
	String Statetext = driver.findElement(By.xpath("//select[@id='incident.state']")).getText();
	
	 if(Statetext.contains("In Progress"))
	 {
		 System.out.println("Type is Matched");
	 }
	 else
	 {
		 System.out.println("Type is not Matched");
	 }
	
		
}

}
