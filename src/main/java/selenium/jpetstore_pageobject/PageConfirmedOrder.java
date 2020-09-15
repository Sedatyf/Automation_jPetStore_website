package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConfirmedOrder extends PageMenu {
	
	private WebDriver driver;

	public PageConfirmedOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li")
	WebElement message_confirmation;
	
	@FindBy(xpath="//tr[2]/td[5]")
	WebElement field_total_cost;

}
