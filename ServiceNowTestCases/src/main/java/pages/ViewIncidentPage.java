package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewIncidentPage extends CucumberBaseClass{
	@Given("Update the incident with Urgency as {string}")
	public void UpdateUrgencyAsHigh(String urgencyToSelect) {
//		driver.switchTo().frame(0);
		Select urgency=new Select(driver.findElement(By.id("incident.urgency")));
		urgency.selectByVisibleText(urgencyToSelect);
	}
	@Given("Update the incident with State as {string}")
	public void UpdateStateAsInProgress(String stateToSelect) {
		Select state=new Select(driver.findElement(By.xpath("//select[@id='incident.state']")));
		state.selectByVisibleText(stateToSelect);
	}
	@Given("Update the Assignment Group to {string}")
	public void UpdateAssignmentGroup(String assignmentToUpdate) {
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> allHandles=driver.getWindowHandles();
		windowHandlesList=new ArrayList<String>(allHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//a[text()='Software']")).click();
	}
	@Given("Add Work notes")
	public void addWorkNote() {
		Set<String> allHandles=driver.getWindowHandles();
		windowHandlesList=new ArrayList<String>(allHandles);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigned group is Software");
	}
	@Given("Enter Reolution Information with Resolve Code as {string}")
	public void enterResolutionInformation(String resolutionCodeToUpdate) {
		Actions pressDown=new Actions(driver);
		pressDown.sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		Select resolutionCode=new Select(driver.findElement(By.id("incident.close_code")));
		resolutionCode.selectByVisibleText(resolutionCodeToUpdate);
		
		driver.findElement(By.id("incident.close_notes")).sendKeys("Resolved the incident Permanently");
	}
	
	@When("click button {string}")
	public void clickButton(String buttonToClick) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='"+buttonToClick+"'])[1]")).click();
		Thread.sleep(3000);
	}
	@Then("Click Delete in the warning box")
	public void clickDeleteInWarning() throws InterruptedException {
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(3000);
		Set<String> allHandles=driver.getWindowHandles();
		windowHandlesList=new ArrayList<String>(allHandles);
		driver.switchTo().window(windowHandlesList.get(0));
	}
	
}
