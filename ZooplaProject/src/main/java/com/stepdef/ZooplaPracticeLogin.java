package com.stepdef;

import org.openqa.selenium.WebDriver;

import com.generic.code.BaseLogin;
import com.generic.code.CucumberLogin;
import com.page.object.model.LoginPage;
import com.page.object.model.PropertyPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZooplaPracticeLogin {
	//LoginPage pf;
	protected static  WebDriver driver;
	
	@Given("User open browser")
	public void user_open_browser() throws Throwable {
	   driver=CucumberLogin.setup();
	}

	@Given("open URL")
	public void open_URL() throws Throwable {
	  CucumberLogin.getUrl(driver);
	}

	@Given("User accept all cookies")
	public void user_accept_all_cookies() {
		CucumberLogin.acceptCookies(driver);
		
	   	}

	@Given("User click on SignIn button")
	public void user_click_on_SignIn_button() {
	  CucumberLogin.clickSignIn(driver);
	}

	@When("User Enter Email and password")
	public void user_Enter_Email_and_password() throws Throwable {
		CucumberLogin.enterCredentials(driver);
	  }

	@When("User click on Log In button")
	public void user_click_on_Sign_In_button() {
		CucumberLogin.clickLogin(driver);
	   
	}

	@Then("User shold be bale to login successfully and navigate to the homepage")
	public void user_shold_be_bale_to_login_successfully_and_navigate_to_the_homepage() {
		CucumberLogin.userLogIn(driver);
	   
	}


	

}
