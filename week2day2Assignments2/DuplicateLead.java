package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		//8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//9	Enter Email
		driver.findElement(By.xpath("//label[text()='Email Address:']/following::input[@name='emailAddress']")).sendKeys("Testleaf@gmail.com");
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//11	Capture name of First Resulting lead
		String leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		//13	Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		//14	Verify the title as 'Duplicate Lead'
		driver.findElement(By.id("sectionHeaderTitle_leads"));
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("The Tittle contains \" Duplicate Lead\" ");
		}
		else
		 System.out.println("Page title doesn't contains \"Duplicate Lead\" ");
		//15	Click Create Lead button
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//16	Confirm the duplicated lead name is same as captured name
		String duplicateleadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(leadName.equals(duplicateleadName))
		{
			System.out.println("The duplicated lead name is same as captured name");
		}else
			System.out.println("The duplicated lead name is not same as captured name");
		
	}
	

}
