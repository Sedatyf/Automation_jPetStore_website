package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageShoppingCart extends PageMenu {

	@FindBy(xpath = "//*[@id=\"lines0.quantity\"]")
	WebElement input_quantity;

	@FindBy(xpath = "//h2[.=\"Shopping Cart\"]")
	WebElement h2_shopping_cart;

	@FindBy(name = "update")
	WebElement btn_update_cart;

	@FindBy(xpath = "//tr[2]/td[6]")
	WebElement unit_price;

	@FindBy(xpath = "//tr[2]/td[7]")
	WebElement total_price;

	public void changeQuantity(String quantity) {
		TechnicalTools.fillInput(input_quantity, quantity);
		btn_update_cart.click();
	}
}
