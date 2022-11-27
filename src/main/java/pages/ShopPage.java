package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers {
	
	
//	public WebDriver driver;
	public WebElement dropdown;
	public Select select;
	
	public ShopPage(WebDriver driver) {
		//this.driver = driver; 
	super(driver);	
	PageFactory.initElements(driver, this);
	}
	
	public By anyBook = By.xpath("//a[contains(text(), 'Cooking with love')]");
	public By h1title = By.xpath("//h1[@class='product_title entry-title']");
	public By stars = By.xpath("//div[@class='star-rating']");
	public By zoom = By.xpath("//a[contains(@class, 'gallery__trigger')]");
	public By price = By.xpath("//p[@class='price']");
	public By description = By.xpath("//div[contains(@class, 'short-description')]");
	public By amount = By.xpath("//div[@class='quantity']");
	public By addCart = By.xpath("//button[@type='submit' and @name='add-to-cart']");
	public By tags = By.xpath("//div[@class='product_meta']");
	
	public By orderDropdown =  By.name("orderby");
	public By sliderInitialPosition = By.cssSelector("span[style='left: 0%;']");
	public By sliderFinalPosition = By.cssSelector("span[style='left: 100%;']");
	
	@FindBy(css="a[href*='cookbooks']")
	public WebElement filterCook;
	
	public By resultBook = By.cssSelector("div[class='post_featured']");
	
	@FindBy(css="span[class='onsale']")
	public By sale = By.cssSelector("span[class='onsale']");
	
	@FindBy(css="span[class='posted_in']")
	public WebElement category;
	
	@FindBy(css="span[class='product_id']")
	public WebElement id;
	
	public By image = By.cssSelector("div[class*='gallery__image'] a img");
	
	
	
	public void selectByValue(String value) {
		dropdown =  driver.findElement(orderDropdown);
		select =  new Select(dropdown);
		select.selectByValue(value);
	}
	
	public void selectByIndex(int index) {
		dropdown =  driver.findElement(orderDropdown);
		select =  new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public void selectByVisibleText(String text) {
		dropdown =  driver.findElement(orderDropdown);
		select =  new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	public String getSelectedOption() {
		dropdown =  driver.findElement(orderDropdown);
		select =  new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	public void checkSale() {
		
		List<WebElement> bookList = driver.findElements(resultBook);
		System.out.println(bookList);

		for(int i=0; i<bookList.size();i++) {
		      assertTrue(bookList.get(i).findElement(sale).isDisplayed());
		      System.out.println(bookList.get(i).getText());
		   }
		
	}
	
	public boolean validate(WebElement element, String text) {
		   return  element.getText().contains(text);
		}

}