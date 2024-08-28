package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.BaseClass;
import Pageobjectclass.AccountRegistrationPage;
import Pageobjectclass.AccounttitlePage;
import Pageobjectclass.HomePage;
import Pageobjectclass.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	
	WebDriver driver;
	HomePage hp;
	Loginpage login;
	
	AccounttitlePage ap;
	@Given("user is on nveen automation labs page")
    public void user_is_on_nveen_automation_labs_page() {
        // Set up the WebDriver and navigate to the page
       BaseClass.getLogger().info("Go to my account-->clcik on login");
       hp=new HomePage(BaseClass.getDriver());
       hp.clickonaccount();
       hp.loginfunction();
    }

	@When("user enters the valid credentials {string} and {string}")
    public void user_enters_the_valid_credentials(String username, String password) {
        BaseClass.getLogger().info("enter email and password");
        login = new Loginpage(BaseClass.getDriver());
        login.setemail(username);
        login.setpassword(password);       
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
    	BaseClass.getLogger().info("click on login");
       login.clickonlogin();
    }

    @Then("user should be redirected to the account page")
    public void user_should_be_redirected_to_the_account_page() {
       ap=new AccounttitlePage(BaseClass.getDriver());
       boolean status=ap.pagetitle();
       Assert.assertEquals(status, true);
    }

    @And("user should see a welcome message")
    public void user_should_see_a_welcome_message() {
       System.out.println("hi");
    }

}
