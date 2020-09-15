package selenium.jpetstore_pageobject;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class TestBuyDog {

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
	String category_dog = "DOGS";
	String id_product_golden_retriever = "K9-RT-01";

	@Test
	public void testPage() {
		driver.get("http://localhost:8100/jpetstore/actions/Catalog.action");

		PageLogin page_login = new PageLogin(driver);
		page_login.clickSignIn(driver);
		assertEquals("Please enter your username and password.", page_login.login_message.getText());

		PageHome page_home = page_login.logIn(driver, username, password);
		assertEquals("Welcome ABC!", page_home.message_welcome.getText());

		PageCategory page_category = page_home.clickCategory(driver, category_dog);
		assertEquals("Dogs", page_category.h2_dogs.getText());

		PageProduct page_product = page_category.clickLinkProduct(driver, id_product_golden_retriever);
		assertEquals("Golden Retriever", page_product.h2_golden_retriever.getText());

		PageShoppingCart page_shopping_cart = page_product.clickAddToCart(driver);
		assertEquals("Shopping Cart", page_shopping_cart.h2_shopping_cart.getText());

		// Buying two products and checking if the total price has the correct value
		page_shopping_cart.changeQuantity("2");
		float unit_price = TechnicalTools.stringToFloat(page_shopping_cart.unit_price);
		float total_price = TechnicalTools.stringToFloat(page_shopping_cart.total_price);
		assertEquals(unit_price * 2, total_price, 0.0);

		page_shopping_cart.btn_proceed_checkout.click();
		PagePaymentDetails paymentDetailsPage = new PagePaymentDetails(driver);
		Map<String, String> paymentData = paymentDetailsPage.saveData(driver);
		
		paymentDetailsPage.btn_continue.click();
		PageOrder orderPage = new PageOrder(driver);
		Map<String, String> orderData = orderPage.saveData(driver);
		
		assertEquals(paymentData.get("firstName"), orderData.get("billingFirstName"));
		assertEquals(paymentData.get("lastName"), orderData.get("billingLastName"));
		assertEquals(paymentData.get("address1"), orderData.get("billingAddress1"));
		assertEquals(paymentData.get("address2"), orderData.get("billingAddress2"));
		assertEquals(paymentData.get("city"), orderData.get("billingCity"));
		assertEquals(paymentData.get("state"), orderData.get("billingState"));
		assertEquals(paymentData.get("zip"), orderData.get("billingZip"));
		assertEquals(paymentData.get("country"), orderData.get("billingCountry"));
		
		assertEquals(paymentData.get("firstName"), orderData.get("shippingFirstName"));
		assertEquals(paymentData.get("lastName"), orderData.get("shippingLastName"));
		assertEquals(paymentData.get("address1"), orderData.get("shippingAddress1"));
		assertEquals(paymentData.get("address2"), orderData.get("shippingAddress2"));
		assertEquals(paymentData.get("city"), orderData.get("shippingCity"));
		assertEquals(paymentData.get("state"), orderData.get("shippingState"));
		assertEquals(paymentData.get("zip"), orderData.get("shippingZip"));
		assertEquals(paymentData.get("country"), orderData.get("shippingCountry"));
		
		orderPage.btn_confirm.click();
		PageConfirmedOrder confirmedOrderPage = new PageConfirmedOrder(driver);
		assertEquals("Thank you, your order has been submitted.", confirmedOrderPage.message_confirmation.getText());
		String correctTotalPrice = "$" + String.valueOf(total_price).replace(".", ",");
		assertEquals(correctTotalPrice, confirmedOrderPage.field_total_cost.getText());
		
		confirmedOrderPage.link_returnToMainMenu.click();
	}

}
