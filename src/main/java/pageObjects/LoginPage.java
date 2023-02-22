package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath = "//label[text()='Email Address']/..//input")
	private WebElement input_email;
	@FindBy(name = "password")
	private WebElement input_password;
	@FindBy(xpath = "//*[text()='Login']/parent::button")
	private WebElement btn_login;
	
	//by locators
	By by_loginHeader = By.xpath("//h2[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Login using a valid credentials: pt_test@gmail.com Test@1234 1. Enter Email
	 * Address 2. Enter Password 3. Click Login Button
	 *  We split this to three methods 
	 */
	public void enterEmail(String email) {
		input_email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		input_password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		btn_login.click();
	}
	

	
	
	public void verifyPageHeader() {
		driver.findElement(by_loginHeader);
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfElementLocated(by_loginHeader));
		
	}
	

}
