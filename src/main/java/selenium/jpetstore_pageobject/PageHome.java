package selenium.jpetstore_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHome extends PageMenu {

	private WebDriver driver;

	public PageHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Bouton et message de bienvenue situé sur la gauche
	@FindBy(xpath = "//*[@id=\"WelcomeContent\"]")
	WebElement message_welcome;
	
	

	public PageCategory clickCategory(WebDriver driver, String category) {
		driver.findElement(By.xpath("//*[contains(@href, \""+category+"\")]")).click();
		return new PageCategory(driver);
	}
}
