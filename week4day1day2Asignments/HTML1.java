package week4day1day2Asignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr"));
		int sizeRow = rowElements.size();
		System.out.println("The Number of Rows are : " + sizeRow);
		/*List<String> rowList = new ArrayList<String>();
		for (int i = 2; i <=sizeRow; i++) {
			WebElement row = driver.findElement(By.xpath("//div[@class='related-pages']/table/tbody/tr[" + i + "]/td"));
			rowList.add(row.getText());
			
		}
		int noOfRows = rowList.size();
		System.out.println("The Number of Rows are : " + noOfRows );*/
		//Get the count of Number of Columns
		List<WebElement> colElements = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr/th"));
		int sizeCol = colElements.size();
		System.out.println("The Number of columuns are : " + sizeCol);
		/*List<String> colList = new ArrayList<String>();
		for (int j = 1; j <=sizeCol; j++) {
			WebElement col = driver.findElement(By.xpath("//div[@class='related-pages']/table/tbody/tr/th[" + j + "]"));
			colList.add(col.getText());
			
		}
		int noOfCol = rowList.size();
		System.out.println("The Number of columuns are : " + noOfCol );*/
		

	}

}
