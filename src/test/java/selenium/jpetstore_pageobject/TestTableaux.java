package selenium.jpetstore_pageobject;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestTableaux {

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
	String research = "fish";
	String research_value = "Angelfish";

	@Test
	public void test() {
		driver.get("https://jpetstore.cfapps.io/catalog");

		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		page_login.clickSignIn(driver);
		assertEquals("Please enter your username and password.", page_login.login_message.getText());

		PageHome page_home = page_login.logIn(driver, username, password);
		assertEquals("Welcome ABC !", page_home.message_welcome.getText());

		TechnicalTools.fillInput(PageMenu.input_search, research);
		PageSearch page_search = PageMenu.clickSearch(driver);
		assertEquals("Product ID", driver.findElement(By.xpath("//tr[1]/th[2]")).getText());

		//driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]//a")).click();
		int line = page_search.getLineTable(research_value);
		PageProduct page_product = page_search.clickLink(driver, line);
		assertEquals(research_value, driver.findElement(By.xpath("//h2")).getText());
	}

}
