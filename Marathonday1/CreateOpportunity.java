package Marathonday1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//4. Click on Opportunity tab
		WebElement eleclick = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", eleclick);
		//5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[@class='slds-input']")).sendKeys("Salesforce Automation by Kavitha");
		//7. Choose close date as Today
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[@class='slds-input']")).sendKeys("11/16/2022");
		//8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//span[text()='--None--']")).click();
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Needs Analysis']")).click();
		//9. click Save and VerifyOppurtunity Name"
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = msg.getText();
		if (verify.contains("Kavitha"))
		{
			System.out.println("The opportunity name is matched");
		}
		else
		{
			System.out.println("The opportunity name is not matched");
		}
	

	}

}
