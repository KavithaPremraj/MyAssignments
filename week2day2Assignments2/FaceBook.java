package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[text()='Create New Account']")).click();
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//div[@class='_5dbb']/input")).sendKeys("Kavitha");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//div[text()='Surname']/following-sibling::input")).sendKeys("Marimuthu");
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("kavitha@gmail.com");
		driver.findElement(By.xpath("//div[text()='Re-enter email address']/following-sibling::input")).sendKeys("kavitha@gmail.com");
		// Step 10: Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("Welcome@123");
		// Step 11: Handle all the three drop downs
		//1st dropdown
		WebElement selectElement1 = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dd1 = new Select(selectElement1);
		dd1.selectByValue("9");
		//2nd dropdown
		WebElement selectElement2 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		selectElement2.click();
		Select dd2 = new Select(selectElement2);
		dd2.selectByVisibleText("Dec");
		//3rd dropdown
		WebElement selectElement3 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		selectElement3.click();
		Select dd3 = new Select(selectElement3);
		dd3.selectByValue("1990");
		// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/label")).click();
		

	}

}
