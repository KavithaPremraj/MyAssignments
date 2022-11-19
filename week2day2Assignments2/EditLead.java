package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		//* 1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//* 2	Enter the username
		WebElement userelement = driver.findElement(By.xpath("//input[@id='username']"));
		userelement.sendKeys("DemoSalesManager");
		//* 3	Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		//* 4	Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//* 5	Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		//* 6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//* 7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//* 8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Kavitha");
		//* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//* 10 Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		//* 11 Verify title of the page
		driver.findElement(By.xpath("//div[text()='View Lead']"));
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("The Tittle contains \" View Lead \" ");
		}
		else
		 System.out.println("Page title doesn't contains \" View Lead \" ");
		//* 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//* 13 Change the company name
		driver.findElement(By.xpath("//td/input[@name='companyName']")).clear();
		driver.findElement(By.xpath("//td/input[@name='companyName']")).sendKeys("HCLTechnologies");
		//* 14 Click Update
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();
		//* 15 Confirm the changed name appears
		String changeName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String newName = changeName.replaceAll("[^a-zA-Z]", "");
		System.out.println(newName);
		Thread.sleep(2000);
		driver.close();
	
		
	}

}
