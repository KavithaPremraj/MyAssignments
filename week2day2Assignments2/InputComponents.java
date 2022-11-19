package week2day2Assignments2;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputComponents {

	private static Object username;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml;jsessionid=node01j540a7o52can13p945ps0fry4418339.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Type your name
		WebElement name = driver.findElement(By.xpath("//h5[text()='Type your name']/following::input"));
		name.sendKeys("Kavitha");
		name.sendKeys(Keys.TAB);
		//Append Country to this City.
		WebElement country =  driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input"));
		country.sendKeys(Keys.ARROW_RIGHT);
		country.sendKeys(",TamilNadu");
		country.sendKeys(Keys.TAB);
		//Verify if text box is disabled
		 boolean eletext = driver.findElement(By.xpath("//h5[text()='Verify if text box is disabled']/following::input")).isEnabled();
		 if(eletext)
		 {
			 System.out.println(eletext + "The TextBox is Enabled");
		 }else
		 {
			 System.out.println(eletext + "The TextBox is Disabled");
		 }
		 //Clear the typed text.
		 WebElement cleartext = driver.findElement(By.xpath("//h5[text()='Clear the typed text.']/following::input"));
		 cleartext.clear();
		 cleartext.sendKeys(Keys.TAB);
		 
		 //Retrieve the typed text.
		 WebElement retrivetext = driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']//following::input"));
		 String val = retrivetext.getAttribute("value");
		 System.out.println("Retrive the typed text is: " + val);
		 retrivetext.sendKeys(Keys.TAB);
		 
		 // Type email and Tab. Confirm control moved to next element.
		 WebElement emailtext = driver.findElement(By.xpath("//h5[contains(text(),'Type email and Tab')]//following::input"));
		 emailtext.sendKeys("Kavitha@hcl.com");
		 Point control = emailtext.getLocation();
		 emailtext.sendKeys(Keys.TAB);
		 
		 
		 
		 //Type about yourself
		 
		 WebElement yourself = driver.findElement(By.xpath("//h5[text()='Type about yourself']/following::textarea"));
		 yourself.sendKeys("I am Learning Selenium in Testleaf");
		 if(control.equals(yourself))
		 {
			 System.out.println("Control moved correctly");
		 }
		 yourself.sendKeys(Keys.TAB);
		 		 
		 //Text Editor
		 WebElement texteditor = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		 texteditor.sendKeys("Learning Selenium Automation in TestLeaf");
		 		 
		//Just Press Enter and confirm error message*
		 WebElement mandateele = driver.findElement(By.xpath("//h5[text()='Just Press Enter and confirm error message*']//following::input[@type='text']"));
		 
		 mandateele.sendKeys(Keys.ENTER);
		 String msg = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		 if(msg.contains(msg))
		 {
		 System.out.println("Error Message is matched and the Error Message is: " +msg );
		 }
		 //Click and Confirm Label Position Changes
		 WebElement text = driver.findElement(By.xpath("//h5[text()='Click and Confirm Label Position Changes']//following::input[@type='text']"));
		 
		 Point label = text.getLocation();
		 text.click();
		 text.sendKeys("label check");
		 if (label != text)
		 {
			 System.out.println("Label Position Changes");
			} 
		 else 
			{
				System.out.println("Label Position not Changes" ); 
		 }
		 text.sendKeys(Keys.TAB);
		 
		 //Type your name and choose the third option
		 driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']//following::input")).sendKeys("Kavitha");
		 driver.findElement(By.xpath("//span[@role='listbox']//li[text()='2']")).click();
				 
		 //Type your DOB (mm/dd/yyyy)
		WebElement calender = driver.findElement(By.xpath("//h5[contains(text(),'Type your DOB (mm/dd/yyyy)')]//following::input"));
		calender.sendKeys("11/8/2022");
		//confirm date chosen
		if (calender.equals(calender))
		 {
			 System.out.println("The Date is Matched");
			} 
		 else 
			{
				System.out.println("The Date is Not Matched"); 
		 }
		//Type number and spin to confirm value changed
		WebElement ele = driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input"));
		//ele.sendKeys("6");
		WebElement spinUp = driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']"));
		spinUp.click();
		Thread.sleep(1000);
		String textele = driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input")).getAttribute("aria-valuenow");
		System.out.println(textele);
		//spinup
		
		spinUp.click();
		Thread.sleep(1000);
		//String spinUpNum = driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']")).getText();
		String elementUp = driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input")).getAttribute("aria-valuenow");
		int num1 = Integer.parseInt(textele);
		int spinUpNum = num1+1;
		if(elementUp.equals(Integer.toString(spinUpNum)))
		{
			System.out.println("The Value is Incremented");
		}else
		{
			System.out.println("The Value was not Incremented");
		}
		//spinDown
		WebElement spinDown = driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-s']"));
		spinDown.click();
		Thread.sleep(1000);
		//String spinDownNum = driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-s']")).getText();
		String elementDown = driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input")).getAttribute("aria-valuenow");
		int num = Integer.parseInt(elementUp);	
		int spinDownNum = num-1;
		if(elementDown.equals(Integer.toString(spinDownNum)))
		{
			System.out.println("The Value is Decremented");
		}else
		{
			System.out.println("The Value was not Decremented");
		}
		
		//Type random number (1-100) and confirm slider moves correctly
		WebElement random = driver.findElement(By.xpath("//h5[contains(text(),'Type random number')]/following-sibling::input"));
		WebElement x = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		random.sendKeys("50");
		x.getLocation();
			if (x.getLocation() != null )
				{
					System.out.println("The Slider Moves Correctly");
				}
				else
				{
					System.out.println("The Slider Not Moves Corrctly");
				}
		
		//Click and Confirm Keyboard appears
		WebElement keyboardtextbox = driver.findElement(By.xpath("//h5[text()='Click and Confirm Keyboard appears']/following-sibling::input"));
		keyboardtextbox.click();
		WebElement keyboard = driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']"));
		if (keyboardtextbox.isDisplayed())
		{
			System.out.println("Keyboard is displayed");
		}
		else
		{
			System.out.println("Keyboard not displayed");
		}
		keyboardtextbox.sendKeys(Keys.TAB);
		
		//Custom Toolbar
		WebElement toolbar = driver.findElement(By.xpath(("//div[@data-placeholder='Enter your content']")));
		toolbar.sendKeys("Hello Welcom To TestLeaf");
		Thread.sleep(5000);
		driver.close();
		
		
				 
		 
		
		 
	}

}
