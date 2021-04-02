package runner;


import io.cucumber.testng.CucumberOptions;
import pages.CucumberBaseClass;

@CucumberOptions(features="src/main/java/features/TC006_CreateNewIncidentWithoutFillingMandatoryFields.feature",
				glue="pages",
				monochrome=true,
				publish=true)
public class ServiceNowTC_runner extends CucumberBaseClass {

}
