package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IncidentsPage extends CucumberBaseClass{
	
//	public IncidentsPage(ChromeDriver driver) {
//		this.driver=driver;	
//	}
	@When("Click on Incidents Link")
	public void clickIncidentsLink() throws InterruptedException {
		driver.findElement(By.xpath("//a[@data-original-title='Incidents opened on your behalf']")).click();
		Thread.sleep(3000);
	}
	@When("Click on Create New Link")
	public void clickCreateNewButton() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		Thread.sleep(3000);
		
	}
	@Given("Search by incidentNumber")
	public void searchByIncidentNum() {
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(newlyCreatedIncidentNum);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		
	}
	@Given("Search by incident {string}")
	public void searchByIncidentNumer(String incidentNumber) throws InterruptedException {
		//WebElement frameElement=driver.findElement(By.xpath("//iframe[@aria-label='Main content']"));
		driver.findElement(By.xpath("(//li//div[text()='All'])[2]")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on All");
		
		
		WebElement frameNew=driver.findElement(By.xpath("//iframe[@aria-label='Main content']"));
		driver.switchTo().frame(frameNew);

		driver.findElement(By.xpath("//div[@class='input-group']//input[@placeholder='Search']")).sendKeys(incidentNumber);
		Actions obj=new Actions(driver);
		obj.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}
	@When("Click on the first resulting Incident Number in Edit mode")
	public void clickFirstResultingIncidentNumLink() throws InterruptedException {
		driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]//td[3]//a")).click();
		Thread.sleep(3000);
	}
	
	
	@When("Click on the first resulting Incident Number")
	public void previewFirstResultingIncidentNumLink() {
		driver.findElement(By.xpath("//a[contains(@aria-label,'Preview record')]")).click();
		
		
	}
	@Then("Verify whether the First Resulting Incident number is the same as that of the stored incident Number")
	public void VerifySuccessfulCreationOfNewIncident() {	
		
		if(driver.findElement(By.id("sys_readonly.incident.number")).getAttribute("value").equalsIgnoreCase(newlyCreatedIncidentNum)) {
			System.out.println("Incident "+ newlyCreatedIncidentNum +" is created successfully");
		}else {
			System.out.println("Incident "+ newlyCreatedIncidentNum +" is not created successfully");
		}
		
	}
	@Then("Verify whether the Urgency is {string}")
	public void VerifyUrgency(String urgencySelected) {
		if(driver.findElement(By.id("sys_readonly.incident.urgency")).getAttribute("value").equalsIgnoreCase(urgencySelected)) {
			System.out.println("Updated urgency of the incident: "+ urgencySelected);
		}else {
			System.out.println("Urgency updation is failed");
		}
	}
	@Then("Verify whether the State is {string}")
	public void verifyState(String stateSelected) {
		if(driver.findElement(By.id("sys_readonly.incident.state")).getAttribute("value").equalsIgnoreCase(stateSelected)) {
			System.out.println("Updated State of the incident: "+ stateSelected);
		}else {
			System.out.println("State updation is failed");
		}
	}
	@Then("Verify whether the Assignment Group is {string}")
	public void verifyAssignmentGroup(String assignmentGroupSelected) {
		if(driver.findElement(By.id("incident.assignment_group_label")).getAttribute("value").equalsIgnoreCase(assignmentGroupSelected)) {
			System.out.println("Updated Assignment Group of the incident: "+ assignmentGroupSelected);
		}else {
			System.out.println("Assignment Group updation is failed");
		}
	}
	@Then("Verify for No Records to Display for incident {string}")
	public void verifyNoRecords(String incidentNumber) {
		if(driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed()) {
			System.out.println(incidentNumber+" is deleted successfully");
		}else {
			System.out.println(incidentNumber+" is not deleted successfully");
		}
	}
	
}
