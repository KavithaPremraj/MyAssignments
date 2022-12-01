package week4day1day2Asignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

import org.apache.commons.collections4.list.TreeList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		//Go to Sports Shoes
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mens)
		.pause(Duration.ofSeconds(1))
		.click(shoes)
		.perform();
		
		Thread.sleep(2000);
		//Get the count of the sports shoes
		String shoesCount = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("sports shoes count : " + shoesCount);
		//Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//Sort by Low to High
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		//Check if the items displayed are sorted correctly
		List<WebElement> sortedPriceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> priceList = new TreeList<String>();
		for (WebElement e : sortedPriceList) {
			priceList.add(e.getText());
		}
		System.out.println("The sorted List is : " + priceList);
		
		//Select the price range (900-1200)
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(2000);
		//Filter with color Navy 
		/*WebElement clolorNavy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']/span "));
		clolorNavy.click();
		String clorText = clolorNavy.getText();
		System.out.println(clorText);*/
				
		//verify the all applied filters 
		String priceFilter = driver.findElement(By.xpath("//div[text()='Price: ']/a")).getText();
		System.out.println(priceFilter);
		//String colorFilter = driver.findElement(By.xpath("//a[@class='clear-filter-pill  ']")).getText();
		//System.out.println(colorFilter);
		if(priceFilter.contains("900"))
		{
			System.out.println("Price Filter is Matched");
		}
		else
		{
			System.out.println("Price Filter is not Matched");
		}
		/*if(colorFilter.contains(clorText))
		{
			System.out.println("The filter color is matched with the selected color");
		}
		else
		{
			System.out.println("The filter color is not matched with the selected color");
		}	*/	
		//Mouse Hover on first resulting Training shoes
		WebElement mouseHoverQuickView = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		
		builder.moveToElement(mouseHoverQuickView).perform();
		//click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		//Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		//System.out.println("The show amount: " + cost);
		String productDiscount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The product cost and discount of the product is : " + cost + productDiscount);
		//Take the snapshot of the shoes.
		Thread.sleep(1000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File myFile = new File("./snaps/shoes.png");
		FileUtils.copyFile(screenshotAs, myFile);
		System.out.println("Screenshot Captured");
		//Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		//Close the main window
		Thread.sleep(2000);
		driver.close();
		
		}

}
