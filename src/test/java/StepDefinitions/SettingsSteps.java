package StepDefinitions;

import Pages.SettingsPage;
import TestBase.BaseClass;
import io.cucumber.java.en.*;


public class SettingsSteps extends BaseClass {


    SettingsPage settings;

    @Given("An unregistered user launches Auth page \\(Settings)")
    public void an_unregistered_user_launches_auth_page_settings() throws InterruptedException {

        settings = new SettingsPage(webDriver);
        settings.LaunchSettingsPage();
    }

    @When("User updates user details in settings page")
    public void user_updates_user_details_in_settings_page()throws InterruptedException {

        settings.EnterDetailstoUpdate();

    }

    @Then("The user must not be update details without being registered")
    public void the_user_must_not_be_update_details_without_being_registered() throws InterruptedException {

            settings.AssertNoUpdateWasMade();
    }
}
