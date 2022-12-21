package stepsdefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Hooks.SalesForceBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends SalesForceBaseClass {
	
	public static String name; 
	
	@When("Click on Accounts tab")
	public void accountsTab() {
		WebElement accounttab = driver.findElement(By.xpath("//a[contains(@class,'dndItem')]/span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounttab);
	}
	@When("Click on New button")
	public void newButton() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	@When("Enter {string} as account name")
	public void enterAccountName(String myName) {
		WebElement nameEle = driver.findElement(By.xpath("//label[text()='Account Name']/following::input[@class='slds-input' and @name='Name']"));
		nameEle.sendKeys(myName);
		name = nameEle.getAttribute("value");
		System.out.println(name);
	}
	@When("Select Ownership as Public")
	public void selectOwnershipPublic() throws InterruptedException {
		Thread.sleep(3000);
		WebElement ownclick = driver.findElement(By.xpath("//button[@type='button'][@data-value='--None--'][@aria-label='Ownership, --None--']"));
        driver.executeScript("arguments[0].click();", ownclick);
        WebElement pub = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']"));
        driver.executeScript("arguments[0].click();", pub);
	}
	@When("Click Save Account")
	public void click_save() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then("verify Account name")
	public void verifyAccountName() throws InterruptedException {
		Thread.sleep(1000);
		WebElement name1 = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String verify = name1.getText();
		System.out.println(verify);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(verify.contains(name));
		sa.assertAll();
		//System.out.println("The Account name is matched");
		
		/*if (verify.contains(name))
		{
			System.out.println("The Account name is matched");
		}
		else
		{
			System.out.println("The Account name is not matched");
		}*/
	}


}
