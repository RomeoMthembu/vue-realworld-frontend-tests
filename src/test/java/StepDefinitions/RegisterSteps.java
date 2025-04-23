package StepDefinitions;

import Pages.RegistrationPage;
import TestBase.BaseClass;
import io.cucumber.java.en.*;

public class RegisterSteps extends BaseClass {

    RegistrationPage registration;


    @Given("A new customer launches the Website")
    public void a_new_customer_launches_the_website() throws InterruptedException {

        registration = new RegistrationPage(webDriver) ;
        registration.launchRegistrationPage();

    }

    @When("Customer registers with valid credentials on the website")
    public void customer_registers_with_valid_credentials_on_the_website() throws InterruptedException {

        registration.EnterInRegistrationCredentials();

    }

    @Then("Customer must be able to register successfully")
    public void customer_must_be_able_to_register_successfully() throws InterruptedException {

        registration.AssertCustomerName();

    }

    @When("Customer registers using existing email address")
    public void customer_registers_using_existing_email_address() throws InterruptedException {

        registration.EnterInExistingEmail();

    }

    @Then("An invalid registration credentials error must be displayed")
    public void an_invalid_registration_credentials_error_must_be_displayed() throws InterruptedException {

        registration.ValidateExistingEmailErrorMessage();

    }


    @When("User attempts to register with an invalid email")
    public void user_attempts_to_register_with_an_invalid_email()throws InterruptedException {

        registration.RegisterWithInvalidEmail();

    }
    @Then("A email validation error must be displayed")
    public void a_email_validation_error_must_be_displayed() throws InterruptedException {

        registration.AssertInvalidEmailError();

    }
}
