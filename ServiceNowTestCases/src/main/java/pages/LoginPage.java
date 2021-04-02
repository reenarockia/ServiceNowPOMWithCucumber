package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPage extends CucumberBaseClass{
	
//	public LoginPage(ChromeDriver driver) {
//		this.driver=driver;	
//	}
	@Given("Enter username as admin")
	public void enterUserName() {
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
	}
	@Given("Enter password as India@123")
	public void enterPassword() {
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		
	}
	@When("Click on Login Button")
	public void clickLogin() {
		driver.findElement(By.id("sysverb_login")).click();
		
	}
	

}
