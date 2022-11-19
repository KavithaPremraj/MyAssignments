package Marathonday1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {

	public static void main(String[] args) throws InterruptedException {
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
		//4. Click on Accounts tab 
		WebElement accounttab = driver.findElement(By.xpath("//a[contains(@class,'dndItem')]/span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounttab);
		//5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//6. Enter 'your name' as account name
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[@class='slds-input' and @name='Name']")).sendKeys("Kavitha");
		//7. Select Ownership as Public
		Thread.sleep(3000);
		WebElement ownclick = driver.findElement(By.xpath("//button[@type='button'][@data-value='--None--'][@aria-label='Ownership, --None--']"));
        driver.executeScript("arguments[0].click();", ownclick);
        WebElement pub = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']"));
        driver.executeScript("arguments[0].click();", pub);
        //8. Click save and verify Account name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement name = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = name.getText();
		if (verify.contains("Kavitha"))
		{
			System.out.println("The Account name is matched");
		}
		else
		{
			System.out.println("The Account name is not matched");
		}

	}

}
