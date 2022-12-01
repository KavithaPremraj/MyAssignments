package week4day1day2Asignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// You have to print the respective values based on given Library
		//(hint: if the library was absolute usage, then print all its value)
		String marketShare = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr[1]")).getText();
		//System.out.println(marketShare);
		String absoluteUsagae = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr[2]")).getText();
		//System.out.println(absoluteUsagae);
		if(absoluteUsagae.contains("Absolute Usage"))
		{
			System.out.println(absoluteUsagae);
		}
		else
		{
			System.out.println(marketShare);
		}
	}

}
