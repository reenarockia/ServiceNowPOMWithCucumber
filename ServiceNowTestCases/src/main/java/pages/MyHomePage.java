package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;

public class MyHomePage extends CucumberBaseClass{
//	public MyHomePage(ChromeDriver driver) {
//		this.driver=driver;	
//	}
	
	@Given("Enter Incident in Filter navigator and press ENTER")
	public void searchIncidentInFilterNav() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
}
