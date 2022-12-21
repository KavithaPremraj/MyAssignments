package Marathonday2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login with Provided Credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on Learn More link in Mobile Publisher  and click Confirm
		driver.findElement(By.xpath("//div[@class='tileNavButton']/button[@class='slds-button slds-button--neutral navButton newWindow uiButton']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//and Click Learning and Mouse hover on Learning On Trailhead
		Shadow dom =new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//span[text()='Learning']").click();
		Actions builder = new Actions(driver);
		WebElement traiHeadEle = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(traiHeadEle).perform();
		//Select SalesForce Certification
		Thread.sleep(2000);
		WebElement clk = dom.findElementByXPath("//a[text()='Salesforce Certification']");
        driver.executeScript("arguments[0].click();", clk);
		
		//Choose Your Role as Salesforce Architect and verify the URL
		WebElement archele = driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']"));
		archele.click();
		String  currentUrl = driver.getCurrentUrl();
		System.out.println("The current URL is : " + currentUrl);
		if(currentUrl.contains("architect"))
		{
			System.out.println("The URL is Architect");
		}
		else
		{
			System.out.println("The URL is not Architect");
		}
		//Get the Text(Summary) of Salesforce Architect 
		String summaryArch = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div")).getText();
		System.out.println("The Salesforce Architect Summary is : " + summaryArch);
		// Get the List of Salesforce Architect Certifications Available
		List<WebElement> certificationsAtchitect = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		List<String> listCert = new ArrayList<String>();
		for (WebElement webElement : certificationsAtchitect) {
			//String listOFCert = driver.findElement(By.xpath("//div[@class='credentials-card_title']")).getText();
			String listCerti = webElement.getText();
			listCert.add(listCerti);
					}
		System.out.println("The Available Salesforce Architect Certifications are : " + listCert);
		
		//Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		//Get the List of Certifications available
		List<WebElement> availableCert = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		List<String> listavaiCert = new ArrayList<String>();
		for (WebElement webElement : availableCert) {
			String avaiCert = webElement.getText();
			listavaiCert.add(avaiCert);
			
		}
		System.out.println("List of Certifications available : " + listavaiCert);
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
	
	}

}
