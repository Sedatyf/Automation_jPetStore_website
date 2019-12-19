package selenium.jpetstore_pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearch extends PageMenu {

	@FindBy(xpath = "//table")
	WebElement table_search;

	public int getLineTable(WebDriver driver, String value) {
		int currentLine = 1;
		List<WebElement> lines = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement line : lines) {
			System.out.println(currentLine);
			List<WebElement> cells = line.findElements(By.xpath("td"));
			for (WebElement cell : cells) {
				if (cell.getText().equals(value)) {
					return currentLine;
				}
			}
			currentLine++;
		}
		return -1;
	}

	public WebElement getCell(WebDriver driver, int line, int col) {
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr[" + line + "]/td[" + col + "]//a"));
		return element;
	}

	public PageProduct clickLink(WebDriver driver, int line) {
		WebElement link = getCell(driver, line, 2);
		link.click();
		return PageFactory.initElements(driver, PageProduct.class);
	}
}
