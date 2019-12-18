package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProduct extends PageMenu {

	@FindBy(xpath = "//tr[2]/td[5]/a")
	WebElement btn_add_to_cart;

	@FindBy(xpath = "//h2[.=\"Tiger Shark\"]")
	WebElement h2_tiger_shark;

	public PageShoppingCart clickAddToCart(WebDriver driver) {
		this.btn_add_to_cart.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}
}
