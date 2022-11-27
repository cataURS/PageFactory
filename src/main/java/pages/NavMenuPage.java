package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{
	
	public NavMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(linkText = "BOOKS")
	public WebElement shopLink;
	
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	
	@FindBy(linkText ="CONTACTS")
	public WebElement contactLink;
	
	@FindBy(linkText = "BLOG")
	public WebElement blogLink;
	
	@FindBy(linkText = "Classic")
	public WebElement blogClasic;
	
	@FindBy(linkText = "ABOUT" )
	public WebElement aboutLink;
	
	@FindBy(linkText = "Post Formats" )
	public WebElement postFormatsBlogLink;

	@FindBy(css = "button[class*='search_button']")
	public WebElement searchIcon;
	
	@FindBy(css = "button[class*='search_submit']")
	public WebElement searchIconUp;
	
	@FindBy(css = "header input[class='search_field']")
	public WebElement searchField1;
	
	@FindBy(css = "input[title='Search for:']")
	public WebElement searchField2;
	
	@FindBy(css = "a[href*='wicked-king']")
	public WebElement kingBook;
	
		
	
	public void navigateTo(WebElement element) {
		click(element);
	}
	
	public void searchBook1(String value) {
		click(searchIconUp);
		sendKeys(searchField1, value);
		//click(searchIcon);
	}
	
	public void searchBook2(String value) {
		//click(searchIcon);
		sendKeys(searchField2, value);
		click(searchIcon);
	}
	
	
	public boolean isBookPictureDisplayed(String picture) {
		WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	
	
	
}