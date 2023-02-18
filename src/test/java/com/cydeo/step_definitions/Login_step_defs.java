package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_step_defs {
SeamlessLoginPage seamlessLoginPage =new SeamlessLoginPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }
    @When("the user enter correct username")
    public void the_user_enter_correct_username() {
        seamlessLoginPage.txt_username.sendKeys(ConfigurationReader.getProperty("seamless.username"));
    }
    @When("the user enter valid password")
    public void the_user_enter_valid_password() {
        seamlessLoginPage.txt_password.sendKeys(ConfigurationReader.getProperty("seamless.password"));
    }
    @When("the user click the login button")
    public void the_user_click_the_login_button() {
   seamlessLoginPage.button_login.click();
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Files"));
    }


}
