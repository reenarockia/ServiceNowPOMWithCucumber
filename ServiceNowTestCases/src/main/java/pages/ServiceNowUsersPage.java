package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.When;

public class ServiceNowUsersPage extends CucumberBaseClass{
	
//	public ServiceNowUsersPage(ChromeDriver driver) {
//		this.driver=driver;	
//	}
	@When("Select the caller in ServiceNow Users page")
	public void selectOneCaller() {
		driver.findElement(By.xpath("//a[text()='Abraham Lincoln']")).click();
		Set<String> allWindowHandles=driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println("Caller Selected=Abraham Lincoln");
		
	}
	
}
