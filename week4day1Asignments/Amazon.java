package week4day1Asignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchElement = driver.findElement(By.id("twotabsearchtextbox"));
		searchElement.sendKeys("oneplus 9 pro");
		searchElement.sendKeys(Keys.ENTER);
		//Get the price of the first product
		List<WebElement> firstelement = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		firstelement.size();
		List<Integer> pricelist = new ArrayList<Integer>();
		for (WebElement eachMobile : firstelement	) {
			String text = eachMobile.getText();
			System.out.println(text);
			String replace = text.replace(",","");
			if(replace.trim().length()>0)
			{
				int price = Integer.parseInt(replace);
				pricelist.add(price);
			}
		}
		System.out.println("The first product price is : " + pricelist.get(0));
		//Print the number of customer ratings for the first displayed product
		String noOfCustomerRatings = driver.findElement(By.xpath("//span[@class='a-declarative']//following::span[@class]")).getText();
		System.out.println("The number Of Customer Ratings : " + noOfCustomerRatings );
		//Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		//Take a screen shot of the product displayed
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File myFile = new File("./snaps/amazon.png");
		FileUtils.copyFile(screenshotAs, myFile);
	
		//driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).click();
		//See All Buying Options
		//driver.findElement(By.xpath("//a[text()=' See All Buying Options ']")).click();
		//driver.findElement(By.xpath("//span[text()=' Add to Cart ']")).click();
		//Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);
		System.out.println(windows);
		//Get Cart Subtotal
		
		String text2 = driver.findElement(By.xpath("//span[text()=' (1 item): ']")).getText();
		System.out.println("The text is : " + text2);
		String totalAmount = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("The Cart Total Amount is :" + totalAmount);
		String replace1 = totalAmount.replace("\\D", "").replace(",", "").replace("₹", "");
		System.out.println(replace1);
		int amountNum = Integer.parseInt(replace1);
		System.out.println(amountNum);
		if(amountNum == pricelist.get(0))
		{
			System.out.println("The cart Amount is matched");
		}
		else
		{
			System.out.println("The cart Amount is not matched");
		}
		
		
		
		
	}

}
