package selenium.jpetstore_pageobject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePaymentDetails {
	
	private WebDriver driver;

	public PagePaymentDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="order.cardType")
	WebElement select_cardType;
	
	@FindBy(name="order.creditCard")
	WebElement input_cardNumber;
	
	@FindBy(name="order.expiryDate")
	WebElement input_expiryDate;
	
	@FindBy(name="order.billToFirstName")
	WebElement input_firstName;
	
	@FindBy(name="order.billToLastName")
	WebElement input_lastName;
	
	@FindBy(name="order.billAddress1")
	WebElement input_address1;
	
	@FindBy(name="order.billAddress2")
	WebElement input_address2;
	
	@FindBy(name="order.billCity")
	WebElement input_city;
	
	@FindBy(name="order.billState")
	WebElement input_state;
	
	@FindBy(name="order.billZip")
	WebElement input_zip;
	
	@FindBy(name="order.billCountry")
	WebElement input_country;
	
	@FindBy(name="newOrder")
	WebElement btn_continue;
	
	public Map<String, String> saveData(WebDriver driver) {
		Map<String, String> paymentDetailsData = new HashMap<String, String>();
		paymentDetailsData.put("firstName", input_firstName.getAttribute("value"));
		paymentDetailsData.put("lastName", input_lastName.getAttribute("value"));
		paymentDetailsData.put("address1", input_address1.getAttribute("value"));
		paymentDetailsData.put("address2", input_address2.getAttribute("value"));
		paymentDetailsData.put("city", input_city.getAttribute("value"));
		paymentDetailsData.put("state", input_state.getAttribute("value"));
		paymentDetailsData.put("zip", input_zip.getAttribute("value"));
		paymentDetailsData.put("country", input_country.getAttribute("value"));
		
		return paymentDetailsData;
	}
}
