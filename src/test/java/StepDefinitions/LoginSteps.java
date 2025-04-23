package StepDefinitions;

import Pages.LoginPage;
import TestBase.BaseClass;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {


    LoginPage login;

    @Given("An existing customer")
    public void an_existing_customer() throws InterruptedException {

        login = new LoginPage(webDriver);
        login.SignIn();

    }

    @When("Customer logs in with valid username and password")
    public void customer_logs_in_with_valid_username_and_password() throws InterruptedException {

        login.EnterLoginDetails();

    }

    @Then("The customer must be successfully logged in")
    public void the_customer_must_be_successfully_logged_in() throws InterruptedException {

        login.AssertLoginName();

    }
}
