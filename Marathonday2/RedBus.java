package Marathonday2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Type ""Chennai"" in the FROM text box and select the first option
		WebElement fromEle = driver.findElement(By.xpath("//input[@id='src']"));
		fromEle.click();
		fromEle.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@class='sub-city']")).click();
		//Type ""Bangalore"" in the To text box and select the first option
		WebElement toEle = driver.findElement(By.xpath("//input[@id='dest']"));
		toEle.click();
		toEle.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@class='sub-city']")).click();
		driver.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr/td[@class='next']/button")).click();
		
		//Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr/td[@class='wd day']")).click();
		//Click Search Buses
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		//Print the number of buses shown as results
		String noOfBusses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The Number of Busses found : " + noOfBusses);
		//Choose SLEEPER in the left menu 
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		//Print the name of the second resulting bus 
		String secondBus = driver.findElement(By.xpath("(//li[@class='row-sec clearfix']//div[@class='clearfix row-one'])[2]")).getText();
		System.out.println("The second Resulting Bus is : "+ secondBus);
		Thread.sleep(2000);
		
		//Click the VIEW SEATS of that bus
		WebElement clk = driver.findElement(By.xpath("(//div[@class='clearfix bus-item-details']/following::div[@class='button view-seats fr'])[2]"));
        driver.executeScript("arguments[0].click();", clk);

		//driver.findElement(By.xpath("(//div[@class='clearfix bus-item-details']/following::div[@class='button view-seats fr'])[2]")).click();
		//Take screenshot and close browser
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File myFile = new File("./snaps/RedBus.png");
		FileUtils.copyFile(screenshotAs, myFile);
		driver.quit();
		
		
		

	}

}
