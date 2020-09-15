package selenium.jpetstore_pageobject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOrder {

	private WebDriver driver;

	public PageOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[3]/td[2]")
	WebElement field_billingFirstName;
	
	@FindBy(xpath="//tr[4]/td[2]")
	WebElement field_billingLastName;
	
	@FindBy(xpath="//tr[5]/td[2]")
	WebElement field_billingAddress1;
	
	@FindBy(xpath="//tr[6]/td[2]")
	WebElement field_billingAddress2;
	
	@FindBy(xpath="//tr[7]/td[2]")
	WebElement field_billingCity;
	
	@FindBy(xpath="//tr[8]/td[2]")
	WebElement field_billingState;
	
	@FindBy(xpath="//tr[9]/td[2]")
	WebElement field_billingZip;
	
	@FindBy(xpath="//tr[10]/td[2]")
	WebElement field_billingCountry;
	
	@FindBy(xpath="//tr[12]/td[2]")
	WebElement field_shippingFirstName;
	
	@FindBy(xpath="//tr[13]/td[2]")
	WebElement field_shippingLastName;
	
	@FindBy(xpath="//tr[14]/td[2]")
	WebElement field_shippingAddress1;
	
	@FindBy(xpath="//tr[15]/td[2]")
	WebElement field_shippingAddress2;
	
	@FindBy(xpath="//tr[16]/td[2]")
	WebElement field_shippingCity;
	
	@FindBy(xpath="//tr[17]/td[2]")
	WebElement field_shippingState;
	
	@FindBy(xpath="//tr[18]/td[2]")
	WebElement field_shippingZip;
	
	@FindBy(xpath="//tr[19]/td[2]")
	WebElement field_shippingCountry;
	
	@FindBy(xpath="//a[.=\"Confirm\"]")
	WebElement btn_confirm;
	
	public Map<String, String> saveData(WebDriver driver) {
		Map<String, String> paymentDetailsData = new HashMap<String, String>();
		
		paymentDetailsData.put("billingFirstName", field_billingFirstName.getText());
		paymentDetailsData.put("billingLastName", field_billingLastName.getText());
		paymentDetailsData.put("billingAddress1", field_billingAddress1.getText());
		paymentDetailsData.put("billingAddress2", field_billingAddress2.getText());
		paymentDetailsData.put("billingCity", field_billingCity.getText());
		paymentDetailsData.put("billingState", field_billingState.getText());
		paymentDetailsData.put("billingZip", field_billingZip.getText());
		paymentDetailsData.put("billingCountry", field_billingCountry.getText());
		
		paymentDetailsData.put("shippingFirstName", field_shippingFirstName.getText());
		paymentDetailsData.put("shippingLastName", field_shippingLastName.getText());
		paymentDetailsData.put("shippingAddress1", field_shippingAddress1.getText());
		paymentDetailsData.put("shippingAddress2", field_shippingAddress2.getText());
		paymentDetailsData.put("shippingCity", field_shippingCity.getText());
		paymentDetailsData.put("shippingState", field_shippingState.getText());
		paymentDetailsData.put("shippingZip", field_shippingZip.getText());
		paymentDetailsData.put("shippingCountry", field_shippingCountry.getText());
		
		return paymentDetailsData;
	}
}
