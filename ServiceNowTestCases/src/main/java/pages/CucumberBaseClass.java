package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberBaseClass extends AbstractTestNGCucumberTests{

	public static ChromeDriver driver;
	public static String newlyCreatedIncidentNum;
	public List<String> windowHandlesList;
	
	@BeforeMethod
	public void preConditions() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://dev68594.service-now.com");
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void postConditions() {
		
		//driver.switchTo().defaultContent();
		driver.quit();
	}
	
	
	
}
