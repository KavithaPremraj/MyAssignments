package ServicenowApp.testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Marathonday3.ReadExcel1;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowBaseClass {
	
	public ChromeDriver driver;
	public static Shadow shadowDriver;
	public static String incidentNum;
	public String fileName;
	public int sheetIndex;
	
	@Parameters({"url", "username","password"})
  @BeforeMethod(alwaysRun = true)
  public void preCondition(String url, String uName, String pwd) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		shadowDriver =new Shadow(driver);
		shadowDriver.setImplicitWait(60);
		shadowDriver.findElementByXPath("//div[text()='All']").click();
		
		Actions shadowmouse = new Actions(driver);
		shadowmouse.moveToElement(shadowDriver.findElementByXPath("//span[text()='Incidents']")).click().perform();
		
		
		Thread.sleep(3000);
		WebElement frameELE = shadowDriver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameELE);
  }
  		@AfterMethod(alwaysRun = true)
  		public void postCondition() {
  		driver.close();
  		}
  		
  		@DataProvider(name = "fetchData")
  		public String[][] getData() throws IOException {
  			return ReadExcel1.readData(fileName,sheetIndex);
  			
  		}	
  
}