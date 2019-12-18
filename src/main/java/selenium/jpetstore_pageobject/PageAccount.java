package selenium.jpetstore_pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageAccount {

	@FindBy(id = "languagePreference")
	WebElement language_select;

	@FindBy(id = "favouriteCategoryId")
	WebElement fav_category_select;

	@FindBy(id = "listOption1")
	WebElement mylist_check;

	@FindBy(id = "bannerOption1")
	WebElement mybanner_check;

	public String fav_category_selected_value;
	public String language_selected_value;

	public String setLanguage(String value) {
		return this.language_selected_value = TechnicalTools.selectMenu(language_select, value)
				.getFirstSelectedOption().getText();

	}

	public String setFavouriteCategory(String value) {
		return this.fav_category_selected_value = TechnicalTools.selectMenu(fav_category_select, value)
				.getFirstSelectedOption().getText();

	}
}
