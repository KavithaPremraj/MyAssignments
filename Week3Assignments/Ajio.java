package Week3Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchelement = driver.findElement(By.xpath("//input[@name='searchVal']"));
		searchelement.sendKeys("bags");
		searchelement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		//Total No Of Items
		String noOfItems = driver.findElement(By.className("length")).getText();
		System.out.println("The total number of items: " + noOfItems );
		//List of Brand names
		List<WebElement> allBrandList = driver.findElements(By.className("brand"));
		System.out.println("The Brand List is:");
		for (WebElement Element1 : allBrandList) {
			String text1 = Element1.getText();
			System.out.println(text1);
		}
		Thread.sleep(2000);	
		//List of Bag Names
		List<WebElement> bagsNameList = driver.findElements(By.xpath("//div[@class='nameCls']"));
		Thread.sleep(2000);
		System.out.println("The Bag Name list is: ");
		for (WebElement Element2 : bagsNameList) {
			String text2 = Element2.getText();
			System.out.println(text2);
		}
		int size = bagsNameList.size();
		System.out.println("The size of the bagname List is: " + size);
		boolean add = bagsNameList.add(searchelement);
		System.out.println("The add list:" +add);
		Thread.sleep(2000);
		driver.close();		
	}
}
