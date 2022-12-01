package week4day1day2Asignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().frame("frame1");
		WebElement frame1element = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
		frame1element.sendKeys("Learn Frame");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement selectelement = driver.findElement(By.xpath("//select[@id='animals']"));
		selectelement.click();
		Select dd = new Select(selectelement);
		dd.selectByVisibleText("Baby Cat");
		driver.switchTo().defaultContent();
		System.out.println("Frame fields Entered Successfully");
		driver.close();
		

	}

}
