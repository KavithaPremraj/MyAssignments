package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Your most favorite browser
		driver.findElement(By.xpath("//label[text()='Chrome']")).click();
		WebElement selected = driver.findElement(By.xpath("//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default']/following::label[text()='Bengaluru']"));
		if(selected.isSelected())
		{
		System.out.println("The button is Unselected");
		}
		else
		{
			System.out.println("The button is Unselected");
		}
		//Find the default select radio button
		boolean selected2 = driver.findElement(By.xpath("(//label[text()='Safari'])[2]")).isSelected();
		System.out.println("The Selected Button is Safari: " + selected2);
		
		//Select the age group (only if not selected)
		WebElement select = driver.findElement(By.xpath("//label[text()='1-20 Years']"));
		if(!select.isSelected())
		{
		driver.findElement(By.xpath("//label[text()='1-20 Years']")).click();
		}
		Thread.sleep(2000);
		driver.close();
		
	}
	
}
