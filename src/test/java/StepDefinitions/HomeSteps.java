package StepDefinitions;

import Pages.HomePage;
import TestBase.BaseClass;
import io.cucumber.java.en.*;


public class HomeSteps extends BaseClass {


    HomePage homepage;

    @Given("A user launches Conduit website")
    public void a_user_launches_conduit_website() {


        homepage = new HomePage(webDriver);

      homepage.LaunchWebsite();

    }

    @When("The page has fully loaded")
    public void the_page_has_fully_loaded() throws InterruptedException {

        homepage.WaitForPageToLoad();

    }

    @Then("Verify the page title is correctly displayed")
    public void verify_the_page_title_is_correctly_displayed() throws InterruptedException {

        homepage.VerifyPageTitle();

    }
}
