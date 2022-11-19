package week2day2Assignments2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Basic Checkbox
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		//Notification
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		//Verify the Notification
		String checknotify = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		if(checknotify.contains(checknotify))
		{
			System.out.println(checknotify + " Tittle is Matched ");
		}else
		{
			System.out.println(checknotify + " Tittle is not matched ");
		}
		//Choose your favorite language(s)
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Others']")).click();
		//Tri State Checkbox
		driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		
		//Toggle Switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		//Verify if check box is disabled
		boolean enabled = driver.findElement(By.xpath("//div[@class='ui-helper-hidden-accessible']/input[@aria-label='Disabled']")).isEnabled();
		if(enabled)
		{
			System.out.println("The Check box is Enabled");
		}else
		{
			System.out.println(enabled + "The Check box is Disabled");
		}
		//Select Multiple
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Select All']/following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();
		Thread.sleep(2000);
		driver.close();
	
	}

}
