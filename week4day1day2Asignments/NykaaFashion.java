package week4day1day2Asignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaFashion {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		WebElement brandsEle = driver.findElement(By.xpath("//li/a[text()='brands']"));
			
		builder.moveToElement(brandsEle).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(1000);
		WebElement lParisElement = driver.findElement(By.xpath("//div[@id='list_topbrands']/following::a"));
		lParisElement.click();
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		driver.findElement(By.xpath("//span[text()='Category']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Hair']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[@class='control-indicator checkbox ']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[@class='control-indicator checkbox ']")).click();
		String filtelEle = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println(filtelEle);
		if(filtelEle.contains("Shampoo"))
		{
			System.out.println("The filter text is matched");
		}
		else
		{
			System.out.println("The filter Text is not Matched");
		}
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		String title1 = driver.getTitle();
		System.out.println("New Window Tittle : " + title1);
		WebElement selectSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select(selectSize);
		dd.selectByVisibleText("175ml");
		String eleMRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("The Mrp of the product is : "+ eleMRP);
		String mrpPrice = eleMRP.replace("₹", "");
		int mrp = Integer.parseInt(mrpPrice);
		System.out.println("The Mrp of the product is : " + mrp);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);
		//driver.switchTo().window(windows.get(1));
		//System.out.println(windows);
		driver.switchTo().frame(0);
		String grandTotalEle = driver.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[@class='css-n8gwxi e171rb9k3']")).getText();
		System.out.println("The Grand Total is : " + grandTotalEle);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		String priceDetailsEle = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']")).getText();
		//System.out.println(priceDetailsEle);
		String totalPrice = priceDetailsEle.replace("₹", "");
		int grandTotal = Integer.parseInt(totalPrice);
		System.out.println("The Grand Total including shipping charge is : " + grandTotal);
		if(mrp == grandTotal)
		{
			System.out.println("Grand Total is Matched");
		}
		else
		{
			System.out.println("Grand Total is not Matched");
		}
		driver.quit();
		
		

	}

}
