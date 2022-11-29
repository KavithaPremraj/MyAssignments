package week4day1AsignmentsUpdate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ssnceyfd5mtq1u38yu3inp0zh436503.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println("The new window opened and the Title is : " + driver.getTitle());
		//driver.close();
		driver.switchTo().window(windows.get(0));
		//Find the number of opened tabs
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		//Set<String> windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);
		int numberOfTabs = driver.getWindowHandles().size();
		System.out.println("The Number of Tabs Opened: " + numberOfTabs);
		driver.switchTo().window(windows.get(0));
		
		//Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		 String primaryWindow = driver.getWindowHandle();
		    for(String handle : driver.getWindowHandles()) {
		        if (!handle.equals(primaryWindow)) {
		            driver.switchTo().window(handle);
		            driver.close();
		        }
		    }

		    driver.switchTo().window(primaryWindow);
		
	    //Wait for 2 new tabs to open
		    driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> windows1 = new ArrayList<String>(windowHandles1);
			driver.switchTo().window(windows1.get(2));
				
			System.out.println(driver.getTitle());

	
		
		
		
		

	}

}
