package com.cucumber.stepDefinitions;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.cucumber.selenium.SeleniumFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class tuentiloginSD {

    SeleniumFunctions sf = new SeleniumFunctions();

    @Given("^user is on Home Page$")
    public void user_is_on_github_homepage() throws MalformedURLException,
            InterruptedException {
        sf.createDriver();
        sf.ishomepageDisplayed();
    }

    @When("^user clicks on Sign in button$")
    public void user_clicks_on_Sign_in_button() {
        sf.clickSigninLink();
    }

    @Then("^user is displayed login screen$")
    public void user_is_displayed_login_screen() {
        sf.isloginsectionDisplayed();
        sf.teardown();
    }

	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser_and_Test(DataTable usercredentials) throws Throwable {

		//Write the code to handle Data Table
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
	    sf.insert_user_and_password(data.get(0).get("Username"), data.get(0).get("Password"));
     }
	
    @When("^user LogOut from the Applicatio$")
    public void LogOut() {
        sf.clickLogoutinLink();
    }
	
	@Then("^Message displayed Login Successfully$")
	    public void Message_displayedLoginSuccessfully() {
	        sf.isloginsectionDisplayed();
	        sf.teardown();
	    }
	
	@Then("^Message displayed Login Error$")
	    public void Message_displayedLoginError() {
	        sf.isloginsectionDisplayedError();
	        sf.teardown();
	    }
	
	 @Then("^Message displayed Login Error$")
	    public void Message_displayedLogoutSuccessfully() {
	        sf.islogoutsectionDisplayed();
	        sf.teardown();
	    }
	
	
}
