package Marathonday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Oppurtunity extends SalesForce {
	@BeforeClass
	public void setData() {
		fileName = "Chatter";
		sheetIndex = 1;
	}
	@Test(dataProvider = "fetchData")
	public void runOppurtunity(String name,String Amount) throws InterruptedException {
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
	
		driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container']")).click();
		WebElement clk = driver.findElement(By.xpath("//span[text()='All Opportunities']"));
        driver.executeScript("arguments[0].click();", clk);
        
		//4. Click on Opportunity tab
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[@class='slds-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(Amount);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		//7. Choose close date as Today
		//driver.findElement(By.xpath("//lightning-primitive-icon/svg[@class='lightning-primitive-icon']"))
		driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		driver.findElement(By.xpath("//table/thead/following::tr/td[@data-value='2023-01-20']")).click();
		
		//8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//span[text()='--None--']")).click();
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Needs Analysis']")).click();
		// Serach compagin
		Thread.sleep(2000);
		WebElement clk1 = driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']"));
        driver.executeScript("arguments[0].click();", clk1);
		//WebElement searchCmpEle = driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='BootCamp']")).click();
		//9. click Save and VerifyOppurtunity Name"
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = msg.getText();
		if (verify.contains("Kavitha"))
		{
			System.out.println("The opportunity name is matched");
		}
		else
		{
			System.out.println("The opportunity name is not matched");
		}
	

	}

	

}
