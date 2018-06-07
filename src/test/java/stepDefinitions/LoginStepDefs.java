package stepDefinitions;


import java.net.MalformedURLException;

import pageObjects.PageObjects;
import common.BaseTest;
import cucumber.api.java.en.*;
public class LoginStepDefs {


	BaseTest fun=new BaseTest();	
	PageObjects objects=new PageObjects();
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		fun.createDriver();
		objects.clickOnSignIn();
		
	}

	@When("User enters UserName {string} and Password{string}")
	public void user_enters_UserName_and_Password(String userName, String password) {
		objects.enterUserNameAndPwd(userName,password);
	}
	@Then("click on login button")
	public void click_on_login_button() {
		objects.clickOnSignInBtn();
		objects.teardown();
	}
	
	@Given("User login with UserName {string} and Password{string}")
	public void user_login_with_UserName_and_Password(String userName, String password) throws  Throwable{
		fun.createDriver();
		objects.clickOnSignIn();
		objects.enterUserNameAndPwd(userName,password);
		objects.clickOnSignInBtn();
	}

	@When("user clicks on category{string}")
	public void user_clicks_on_category(String catg) {
		objects.clickOnCatg(catg);
	}

	@Then("user select the item")
	public void user_select_the_item() {
		objects.selectItem();
	}

	@Then("user add the item to cart with quantity{string} and size{string}")
	public void user_add_the_item_to_cart_with_quantity_and_size(String qty, String size) throws Exception {
		objects.addToCart(qty,size);
	}


}
