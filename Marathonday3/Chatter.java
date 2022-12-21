package Marathonday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chatter extends SalesForce {
	@BeforeClass
	public void setData() {
		fileName = "Chatter";
		sheetIndex = 0;
	}
	@Test(dataProvider = "fetchData")
	public void runSalesChrome(String Question, String Details) throws InterruptedException {
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		WebElement clk = driver.findElement(By.xpath("//span[text()='Chatter']"));
        driver.executeScript("arguments[0].click();", clk);
        Thread.sleep(3000);
		String titleChatter = driver.getTitle();
		System.out.println(titleChatter);
		if(titleChatter.contains("Chatter"))
		{
			System.out.println("Tittle is matched");
			
		}else
		{
			System.out.println("Tittle is not matched");
		}
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(Question);
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(Details);
		driver.findElement(By.xpath("//div[@class='bottomBarRight slds-col--bump-left']/button[@type='button']")).click();
		String textQuestion = driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span[@class='uiOutputText']")).getText();
		System.out.println(textQuestion);
		if(textQuestion.contains("Explain Testng"))
		{
			System.out.println("The question is matched");
		}else
		{
			System.out.println("The question is not matched");
		}
		
		
		

	}

}
