package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement userelement = driver.findElement(By.xpath("//input[@id='username']"));
		userelement.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//9	Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//11	Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//13	Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		//14	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//15	Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(leadID);
		//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
