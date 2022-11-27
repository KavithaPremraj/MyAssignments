package week4day1Asignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement userelement = driver.findElement(By.xpath("//input[@id='username']"));
		userelement.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
		//6. Click on Create Contact
		driver.findElement(By.xpath("//li/a[text()='Create Contact']")).click();
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		//8. Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(windows.get(0));
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		//10. Click on Second Resulting Contact
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(windows1.get(0));
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		//String text = driver.findElement(By.xpath("//div[text()='View Contact']")).getText();
		String title = driver.getTitle();
		System.out.println("\"The Title is :\"" + title);
		driver.close();
		
		
	}

}
