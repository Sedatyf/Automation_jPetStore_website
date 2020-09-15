package selenium.jpetstore_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategory extends PageMenu {
	
	private WebDriver driver;

	public PageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[.=\"Fish\"]")
	WebElement h2_fish;

	@FindBy(xpath = "//h2[.=\"Dogs\"]")
	WebElement h2_dogs;

	public PageProduct clickLinkProduct(WebDriver driver, String produit) {
		driver.findElement(By.linkText(produit)).click();
		return new PageProduct(driver);
	}
}
