package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TechnicalTools {

	static WebDriver driver;

	static WebDriver chooseBrowser(EBrowsers e) {
		switch (e) {
		case Firefox:
			System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Le choix du navigateur est Firefox");
			return driver;
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Le choix du navigateur est Chrome");
			return driver;
		default:
			System.out.println("Default");
			return null;
		}
	}
	
	static void fillInput(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}
	
	public static float stringToFloat(WebElement e) {
		return Float.parseFloat(e.getText().substring(1).replace(',', '.'));
	}
	
	public static Select selectMenu(WebElement menu, String value) {
		Select select = new Select(menu);
		select.selectByValue(value);
		return select;
	}
}
