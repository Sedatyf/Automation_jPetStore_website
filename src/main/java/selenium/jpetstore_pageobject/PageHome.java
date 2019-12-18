package selenium.jpetstore_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHome extends PageMenu {

	// Bouton et message de bienvenue situé sur la gauche
	@FindBy(xpath = "//*[@id=\"WelcomeContent\"]/div")
	WebElement message_welcome;

	public PageCategory clickCategory(WebDriver driver, String category) {
		driver.findElement(By.xpath("//img[contains(@src, '" + category + "_icon.gif')]")).click();
		return PageFactory.initElements(driver, PageCategory.class);
	}
}
