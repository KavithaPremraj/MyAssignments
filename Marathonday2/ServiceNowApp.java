package Marathonday2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowApp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://dev138589.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("mc/-vASs9V1E");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow shadowDriver =new Shadow(driver);
		shadowDriver.setImplicitWait(40);
		shadowDriver.findElementByXPath("//div[@id='all']").click();
		//WebElement filterField = dom.findElementByXPath("//input[@id='filter']");
		//filterField.click();
		//filterField.sendKeys("Service catalog");
		Actions shadowmouse = new Actions(driver);
		shadowmouse.moveToElement(shadowDriver.findElementByXPath("//span[text()='Service Catalog']")).click().perform();
		//dom.findElementByXPath("//mark[@class='filter-match']").click();
		//driver.findElement(By.xpath("//span[text()='Service Catalog']")).click();
		// Click on  mobiles
		WebElement fameELE = shadowDriver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(fameELE);
		driver.findElement(By.xpath("//span/h2[contains(text(),'Mobiles')]")).click();
		//Select Apple iphone6s
		
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		//Update color field to rose gold and storage field to 128GB
		
		WebElement selectColorElement = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		selectColorElement.click();
		Select dd = new Select(selectColorElement);
		dd.selectByVisibleText("Gold");
		WebElement selectStorageElement = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		selectStorageElement.click();
		Select dd1 = new Select(selectStorageElement);
		dd1.selectByVisibleText("128");
		//Select  Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		//Verify order is placed and copy the request number"
		//fRAME
		
		driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		String reqNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("The Request Num is : " + reqNum);
		
		
		
		
		

	}

}
