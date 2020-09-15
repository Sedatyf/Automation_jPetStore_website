package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageMenu {
	
	private WebDriver driver;

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement input_username;

	@FindBy(name = "password")
	WebElement input_password;

	@FindBy(name = "signon")
	WebElement btn_login;

	@FindBy(xpath = "//p[1]")
	WebElement login_message;

	public PageHome logIn(WebDriver driver, String username, String password) {
		TechnicalTools.fillInput(input_username, username);
		TechnicalTools.fillInput(input_password, password);
		btn_login.click();
		return new PageHome(driver);
	}
}
