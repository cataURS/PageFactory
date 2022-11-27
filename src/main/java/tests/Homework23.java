package tests;

import org.testng.annotations.Test;

import pages.BlogPage;
import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class Homework23 extends BaseTest {

	@Test(groups="Search")
	public void Test1() {

		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.hoverElement(navMenu.blogLink);
		navMenu.navigateTo(navMenu.blogClasic);
		navMenu.searchBook2("why");
		BlogPage blog = new BlogPage(driver);
		blog.click(blog.foundBlog);
		blog.validateTags(blog.tags);

	}
	
	@Test
	public void Test2() {

		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.shopLink);
		ShopPage shop = new ShopPage(driver);
		shop.click(shop.filterCook);
		shop.checkSale();
		

	}
	
}
