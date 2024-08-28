package StepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import Pageobjectclass.AccountRegistrationPage;
import Pageobjectclass.AccounttitlePage;
import Pageobjectclass.HomePage;
import Pageobjectclass.Loginpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationSteps {

	WebDriver driver;
	HomePage home;
	Loginpage lp;
	AccountRegistrationPage register;
	
	
	@Given("the user navigates to Register Account page")
    public void the_user_navigates_to_register_account_page() {
	try {	
       home=new HomePage(BaseClass.getDriver());
       home.clickonaccount();
       home.clickonregister();
    }
	catch(Exception e)
	{
		 System.out.println("Error navigating to Register Account page: " + e.getMessage());
         throw e;
	}
	}

    @When("the user enters the details into below fields")
    public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
    	try {
         Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
         
    	
    	register=new AccountRegistrationPage(BaseClass.getDriver());
        register.setname(dataMap.get("firstName"));
        register.setLastName(dataMap.get("lastName"));
        register.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
        register.setTelephone(dataMap.get("telephone"));
        register.setPassword(dataMap.get("password"));
       register.setConfirmPassword(dataMap.get("password"));
    }
catch(Exception e) {

	 System.out.println("Error navigating to Register Account page: " + e.getMessage());
    throw e;
}
    }
    @When("the user selects Privacy Policy")
    public void the_user_selects_privacy_policy() {
      register.setPrivacyPolicy();
    }

    @Then("the user clicks on Continue button")
    public void the_user_clicks_on_continue_button() {
    	register.clickContinue();
      
    }

    @Then("the user account should get created successfully")
    public void the_user_account_should_get_created_successfully() {
        String expected = "Your Account Has Been Created!";
        String status = register.getmessageconfirmation();
        System.out.println("Expected message: " + expected);
        System.out.println("Actual message: " + status);
        Assert.assertEquals(expected, status);
    }
}
 
