package Marathonday1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

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
		//4) Click on Global Actions SVG icon
		driver.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[text()='Global Actions']")));
		//5) Click New Task 
		driver.findElement(By.xpath("//a/span[text()='New Task']")).click();
		//6) Enter subject as ""Bootcamp "" 
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("\"\"Bootcamp \"\"");
		//7) Select status as 'Waiting on someone else'
		driver.findElement(By.xpath("//a[text()='Not Started']")).click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		//9) Save and verify the 'Task created' message"
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = msg.getText();
		if (verify.contains("camp"))
		{
			System.out.println("The Task name is matched");
		}
		else
		{
			System.out.println("The Task name is not matched");
		}
	}

}
