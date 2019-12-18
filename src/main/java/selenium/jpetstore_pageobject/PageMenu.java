package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageMenu {

	@FindBy(linkText = "Sign In")
	WebElement link_signin;

	@FindBy(linkText = "Sign Out")
	WebElement link_signout;

	@FindBy(name = "img_cart")
	WebElement btn_cart;

	@FindBy(xpath = "//img[contains(@src, 'fish.gif')]")
	WebElement btn_fish;
	
	@FindBy(name="keywords")
	static WebElement input_search;
	
	@FindBy(id="searchProducts")
	static WebElement btn_search;

	@FindBy(linkText = "My Account")
	static WebElement link_myaccount;

	public PageLogin clickSignIn(WebDriver driver) {
		link_signin.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}

	public PageShoppingCart clickShoppingCart(WebDriver driver) {
		btn_cart.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

	public PageCategory clickFish(WebDriver driver) {
		btn_fish.click();
		return PageFactory.initElements(driver, PageCategory.class);
	}

	public static PageAccount clickMyAccount(WebDriver driver) {
		link_myaccount.click();
		return PageFactory.initElements(driver, PageAccount.class);
	}
	
	public static PageSearch clickSearch(WebDriver driver) {
		btn_search.click();
		return PageFactory.initElements(driver, PageSearch.class);
	}
}
