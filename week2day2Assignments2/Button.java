package week2day2Assignments2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click and Confirm title.
		driver.findElement(By.xpath("//h5[text()='Click and Confirm title.']/following-sibling::button")).click();
		String tittle = driver.findElement(By.xpath("//div[text()='Dashboard']")).getText();
		if(tittle.contains(tittle))
		{
			System.out.println("Tittle is matched");
		}
		driver.navigate().back();
		//Confirm if the button is disabled
		boolean enabled = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following-sibling::button")).isEnabled();
		if(enabled)
		{
			System.out.println("The button is enabled" + enabled);
		}
		else
		{
				System.out.println("The button is disabled" + enabled);
		}
		//Find the position of the Submit button
		Point position = driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/following::span")).getLocation();
		{
			System.out.println("The position of the button is: " + position);
		}
		//Find the Save button color
		String buttoncolor = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-secondary mr-2 mb-2']")).getCssValue("background").toString();		
		System.out.println("line 48");
		System.out.println("The Save Button Color is : " + Color.fromString(buttoncolor.substring(0, 17).trim()).asHex());
		
		
		//Find the height and width of this button
		Dimension size = driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']/following-sibling::button")).getSize();
		{
			System.out.println("The Button Size is " + size);
		}
		//Mouse over and confirm the color changed
		WebElement mouse = driver.findElement(By.xpath("//h5[text()='Mouse over and confirm the color changed']/following-sibling::button"));
		boolean changecolor = driver.findElement(By.xpath("//h5[text()='Mouse over and confirm the color changed']/following::span[text()='Success']")).isDisplayed();
		Actions action = new Actions(driver);
		action.moveToElement(mouse);
		if(changecolor)
		{
			System.out.println(changecolor + " The color is changed ");
		}
		//Click Image Button and Click on any hidden button
		WebElement click = driver.findElement(By.xpath("//span[text()='Image']"));
		click.click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
