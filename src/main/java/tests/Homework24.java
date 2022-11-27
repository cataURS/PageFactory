package tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class Homework24 extends BaseTest {
	
	@Test(groups="Search")
	public void Test1() {

		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.searchBook1("king");
		navMenu.click(navMenu.kingBook);
		ShopPage shop = new ShopPage(driver);
		shop.validate(shop.category, "New releases");
		shop.validate(shop.id, "1709");
		
		String[] pictures = {
				"TheWickedKing1.png",
				"TheWickedKing3.png",
				"TheWickedKing4.png",
				"TheWickedKing2.png"
		};
		
		List<WebElement> imgList = driver.findElements(shop.image);
		
		for(int i=0; i<4;i++) {
		      assertTrue(imgList.get(i).getAttribute("data-src").contains(pictures[i]));
		   }
		
		

	}

}
