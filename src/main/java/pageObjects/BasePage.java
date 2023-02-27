package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	private WebDriver driver;
	@FindBy(linkText = "Welcome!")
	private WebElement welcomeLink;
	@FindBy(xpath= "//h1[@class='logo']")
	private WebElement logo_appLogo;
	
	
	By by_LoginBtn = By.xpath("//button[text()='Login']");
	By by_SignoutBtn = By.xpath("//button[text()='Sign Out']");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void verifyURL(String pageURL) throws InterruptedException {
		//verify URL
		Thread.sleep(3000);
		String actualURL = driver.getCurrentUrl();
		if (!actualURL.equals(pageURL)) {
			throw new RuntimeException("Actual URL is not matching with expected url:- Actual "+ actualURL +" VS Expected"+ pageURL);
		}
	}
	
	
	public void clickWelcomeLink() {
		// Click Welcome dropdown link
//		driver.findElement(By.linkText("Welcome!")).click();
		welcomeLink.click();
	}
	
	
	public void clickLoginButton() {
		
		// Waiting for the Login Button to be clickable within 10 seconds
		//here since we try to use pageFactory we cant use the wait method
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginElem = wait
				.until(ExpectedConditions.elementToBeClickable(by_LoginBtn));
		// Click login Element
		loginElem.click();
//	  loginButton.click();	
	}
	
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Prime Tech Store";
		if (!actualTitle.equals(expectedTitle)) {
			throw new RuntimeException("Title of the page does not match as expected: " + expectedTitle);
			
		}
	}
	
	public void verifyLogo() {
		
		String actualLogText = logo_appLogo.getText().trim();
		String expectedLogoText = "Sporting Goods Shop";
		if (!actualLogText.equals(expectedLogoText)) {
			throw new RuntimeException("Actual Log Text is not matching with expected logo text: " + expectedLogoText);
		}
	}
	
	public void clickAccountDropdown(String firstName ) {
		 driver.findElement(By.linkText(firstName)).click();
	}
	
	public void clickSignoutButton() {
		
	 // Locate the Account Dropdown
	 
	 new WebDriverWait(driver, Duration.ofSeconds(10))
	 .until(ExpectedConditions.elementToBeClickable(by_SignoutBtn)).click();
}
	
	

}
