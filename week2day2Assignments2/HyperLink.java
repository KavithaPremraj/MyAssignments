package week2day2Assignments2;

import java.awt.List;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args, Object WebUiCommonHelper) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Take me to dashboard
		WebElement dashboard = driver.findElement(By.xpath("//a[text()='Go to Dashboard']"));
		dashboard.click();
		driver.navigate().back();
		
		//Find my destination
		String url = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']")).getAttribute("href");
		url = driver.getCurrentUrl();
		System.out.println("The destination URL is : " + url);
						
		//Count Links
		String url1 = "https://leafground.com/link.xhtml";
		driver.get(url1);
		java.util.List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("The number of links is " + link.size());
	      
	     //Count Layout Links
		
	      driver.close();

	}

}
