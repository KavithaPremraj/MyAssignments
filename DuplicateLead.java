package Assignments.week2.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement userelement = driver.findElement(By.id("username"));
		userelement.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavitha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Marimuthu");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Premraj");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("SeleniumTesting Team Nov 22 Batch Group 3");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kavithamarimuthu61@gmail.com");
		WebElement element = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select dd = new Select(element);
		dd.selectByVisibleText("Indiana");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		WebElement elecompany = driver.findElement(By.id("createLeadForm_companyName"));
		elecompany.clear();
		elecompany.sendKeys("HCLTech");
		WebElement elefirstname = driver.findElement(By.id("createLeadForm_firstName"));
		elefirstname.clear();
		elefirstname.sendKeys("Premraj");
		driver.findElement(By.name("submitButton")).click();
		String duplicatetittle = driver.getTitle();
		System.out.println("The Tittle is :" + duplicatetittle);
		Thread.sleep(2000);
		driver.close();
	}

}
