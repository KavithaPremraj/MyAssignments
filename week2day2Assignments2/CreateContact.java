package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
		//6. Click on Create Contact
		driver.findElement(By.xpath("//li/a[text()='Create Contact']")).click();
		//7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Kavitha");
		//8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Premraj");
		//9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Valapady");
		//10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Salem");
		//11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Technology");
		//12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium Testing Training Nov 22 batch");
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Kavitha@hcl.com");
		//14. Select State/Province as NewYork Using Visible Text
		WebElement statedd1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(statedd1);
		dd.selectByVisibleText("New York");
		//15. Click on Create Contact
		driver.findElement(By.xpath("//td/input[@value='Create Contact']")).click();
		//16. Click on edit button 
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		//17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		//18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Learning is important");
		//19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();
		//20. Get the Title of Resulting Page.
		String tittle = driver.getTitle();
		System.out.println("\"The Tittle is :\"" + tittle);
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
