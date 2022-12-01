package week4day1day2Asignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		//Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		//Get all the Security names
		String security1 = driver.findElement(By.xpath("//div[@class='table-responsive']/table//tr/td[3]")).getText();
		System.out.println(security1);
		List<WebElement> securityNamesListRow = driver.findElements(By.xpath("//div[@class='table-responsive']/table//tr/td[1]"));
		int sizeListRow = securityNamesListRow.size();
		List<WebElement> securityNamesListCol = driver.findElements(By.xpath("//div[@class='table-responsive']/table//tr[1]/td"));
		securityNamesListCol.size();
		List<String> securityNames = new ArrayList<String>();
		for (int i = 1; i <= sizeListRow; i++) {
			WebElement col = driver.findElement(By.xpath("//div[@class='table-responsive']/table//tr[ " + i + "]/td[3]"));
			securityNames.add(col.getText());
				
	}
		System.out.println( securityNames);
		//Ensure whether there are duplicate Security names
		//covert list to set to remove duplicates
		Set<String> removeDuplicates = new HashSet<String>(securityNames);
		int sizeSet = removeDuplicates.size(); 
		System.out.println(removeDuplicates);

		if(sizeListRow == sizeSet) {
			System.out.println("No Duplicates");
		} else {
			System.out.println("Duplicates are present in the list and it is removed by the set");
		}
		
	}

}
