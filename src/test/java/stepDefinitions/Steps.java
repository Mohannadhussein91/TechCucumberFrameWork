package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    
    
	@Given("user is on the Home Page")
	public void user_is_on_the_home_page() throws InterruptedException {
		/*
		 * Starting the Chrome Driver
		 * 
		 */
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://primetech-store-qa.herokuapp.com/");

		/*
		 * Verify the correct Page is loaded
		 *	1. Verify the page title: Prime Tech School
		 *	2.Verify the URL: https://primetech-store-qa.herokuapp.com/
		 * 	3. Verify Logo: Sporting Goods Shop
		 */
		
		// we will create object of Home Page class
		homePage = new HomePage(driver);
		
		// we will call the verify page Logo methods
		homePage.verifyLogo();
		// we will call the verify page URl method 
		homePage.verifyURL("https://primetech-store-qa.herokuapp.com/");
		// we will call the verify page title method
		homePage.verifyTitle();
		
	}
	@Given("user clicks on Login button")
	public void user_clicks_on_login_button() {
		homePage.clickWelcomeLink();
		homePage.clickLoginButton();
		
	}
	
	@Then("user verify Login page URL")
	public void user_verify_login_page_url() throws InterruptedException {
	 loginPage = new LoginPage(driver);
	 loginPage.verifyURL("https://primetech-store-qa.herokuapp.com/login");
	
	}
	
	
	@Then("user verify Login Page logo")
	public void user_verify_login_page_logo() {
		loginPage.verifyPageHeader();

	}
	
	
	@Then("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		loginPage.enterEmail("pt_test@gmail.com");
		loginPage.enterPassword("Test@1234");
		loginPage.clickLoginButton();
	
	}
	
	@When("user dashboard is displayed")
	public void user_dashboard_is_displayed() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.verifyURL("https://primetech-store-qa.herokuapp.com/dashboard");
		
	}
	@Then("user verify email")
	public void user_verify_email() {
		// Verify User Email
		dashboardPage.verifyEmail("pt_test@gmail.com");
					
	}
	@Then("user verify Account type")
	public void user_verify_account_type() {
		dashboardPage.verifyAccountType("Member");
	   
	}
	@Then("user verify First Name")
	public void user_verify_first_name() {
		dashboardPage.verifyFirstName("PT");
	}
	@Then("user Verify Last Name")
	public void user_verify_last_name() {
		dashboardPage.verifyLastName("Test");
	  
	}
	@When("user clicks Logout button")
	public void user_clicks_logout_button() {
	   dashboardPage.clickAccountDropdown("PT");
	   dashboardPage.clickSignoutButton();
	}
	
	@Then("user closes the browser")
	public void user_closes_the_browser(){
		driver.quit();
	}
	

}
