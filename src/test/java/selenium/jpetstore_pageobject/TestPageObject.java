package selenium.jpetstore_pageobject;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestPageObject {

	WebDriver driver;

	@Before
	public void launchBrowser() {
		driver = TechnicalTools.chooseBrowser(EBrowsers.Firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// JDD
	String username = "j2ee";
	String password = "j2ee";
	String category_fish = "fish";
	String id_produit_tiger_shark = "FI-SW-02";
	String language_pref = "Japanese";
	String fav_category = "REPTILES";

	@Test
	public void testPage() {
		driver.get("https://jpetstore.cfapps.io/catalog");

		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		page_login.clickSignIn(driver);
		assertEquals("Please enter your username and password.", page_login.login_message.getText());

		PageHome page_home = page_login.logIn(driver, username, password);
		assertEquals("Welcome ABC !", page_home.message_welcome.getText());

		PageCategory page_category = page_home.clickCategory(driver, category_fish);
		assertEquals("Fish", page_category.h2_fish.getText());

		PageProduct page_product = page_category.clickLinkProduct(driver, id_produit_tiger_shark);
		assertEquals("Tiger Shark", page_product.h2_tiger_shark.getText());

		PageShoppingCart page_shopping_cart = page_product.clickAddToCart(driver);
		assertEquals("Shopping Cart", page_shopping_cart.h2_shopping_cart.getText());

		page_shopping_cart.changeQuantity("2");
		float unit_price = TechnicalTools.stringToFloat(page_shopping_cart.unit_price);
		float total_price = TechnicalTools.stringToFloat(page_shopping_cart.total_price);
		assertEquals(unit_price * 2, total_price, 0.0);

		PageAccount page_account = PageMenu.clickMyAccount(driver);
		page_account.setLanguage(language_pref);
		page_account.setFavouriteCategory(fav_category);
		assertEquals("Japanese", page_account.language_selected_value);
		assertEquals("REPTILES", page_account.fav_category_selected_value);

		assertTrue(page_account.mybanner_check.isEnabled());
		assertTrue(page_account.mylist_check.isEnabled());

		page_account.mylist_check.click();
		assertTrue(page_account.mylist_check.isSelected() == false);
	}

}
