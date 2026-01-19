package TestPages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;

public class HomeTest extends BaseClass {

	HomePage home;

	@BeforeClass
	public void setUpHomePage() {
		home = new HomePage(driver);

	}

	@Test (priority = 1)
	public void clickOn2ndSectionWomenShoes() {
		try {
			home.click2ndSectionWomenShoesAndCloseTab();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test (priority = 2)
	public void clickOn2ndSectionMenShoes() {
		try {
			home.click2ndSectionMenShoesAndCloseTab();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
