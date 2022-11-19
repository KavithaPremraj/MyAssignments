package Week2Day1Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateAccount {
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
		driver.findElement(By.className("x-panel-header-text")).click();
		driver.findElement(By.name("accountName")).sendKeys("Kavitha");
		driver.findElement(By.name("primaryPhoneAreaCode")).sendKeys("20");
		driver.findElement(By.name("primaryPhoneNumber")).sendKeys("9535917048");
		driver.findElement(By.name("primaryEmail")).sendKeys("kavithamarimuthu61@gmail.com");
		driver.findElement(By.className("Create Account")).click();
		//Thread.sleep(2000);
		//driver.close();
	}

}
