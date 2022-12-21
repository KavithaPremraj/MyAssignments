package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLead extends LeafTapsBaseClass1 {
	
	
	public static String leadID;
	@When("Get first resulting LeadID")
	public void getFirstResultingLeadID() throws InterruptedException {
		Thread.sleep(2000);
		WebElement leadIDEle = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		leadID= leadIDEle.getText();
		//leadID = leadIDEle.getAttribute("leadIDEle");
		System.out.println("Lead id is : " + leadID);
	}
	@When ("Click LeadIDInputBox")
	public void clickLeadIDBox()
	{
		driver.findElement(By.xpath("//label[text()='Lead ID:']")).click();
	}
	@When ("Enter LeadID")
	public void enterId() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		
	}
	
	@When("Click LeadID")
	public void clickLeadID() {
		WebElement clickLeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		clickLeadID.click();
	}
	@When("CLick Delete")
	public void cLickDelete() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}
	@When("Enter the leadID")
	public void enterTheLeadID() {
		WebElement idEle = driver.findElement(By.xpath("//input[@name='id']"));
		idEle.sendKeys(leadID);
		leadID = idEle.getAttribute("value");
		System.out.println(leadID);
	}
	@Then("Verify No records to display")
	public void verifyNoRecordsToDisplay() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(text,"No records to display");
		sa.assertAll();
	}
		
		/*if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}*/
	
}
