package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	private WebDriver driver;

	@FindBy(linkText = "Welcome!")
	private WebElement welcomeLink;

//	@FindBy(xpath = "//button[text()='Login']")
//	WebElement loginButton;
	// there is another way to locate this to avoid any exception null by using BY

	By by_LoginBtn = By.xpath("//button[text()='Login']");

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // we do this because we ask the driver to locate the element
		// there is big down for using pageFactory which is some element could take too
		// long to appear
	}

}
