package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewIncidentPage extends CucumberBaseClass{
//	public CreateNewIncidentPage(ChromeDriver driver) {
//		this.driver=driver;
//		
//	}
	
	@Then("Store the Incident Number")
	public void storeIncidentNumber() {
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement);
		newlyCreatedIncidentNum=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		
	}
	@When("Select caller by clicking on the Lookup")
	public void selectCaller() throws InterruptedException {
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Thread.sleep(3000);
		Set<String> allWindowHandles=driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(allWindowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		
	}
	@Given("Enter Short Description")
	public void enterShortDescription() {
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("Abraham Lincoln is selected as a caller");
		
	}
	@When("Click on Submit button")
	public void clickSubmitButton() throws InterruptedException {
		driver.findElement(By.id("sysverb_insert")).click();
		Thread.sleep(3000);
		
	}
	@When("Enter the frame")
	public void enterTheFrame() {
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement);	
	}
	@Then("check for the error message")
	public void checkForErrorMessageWithoutMandatoryFields() {
		Assert.assertTrue(driver.findElement(By.className("outputmsg_text")).getText().
				contains("The following mandatory fields are not filled in: Short description, Caller"));
		System.out.println("Error message is displayed as expected");
	}


}
