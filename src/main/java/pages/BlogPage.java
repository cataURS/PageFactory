package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers{
	
public WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	public By Name = By.xpath("//input[@id='author']"); 
	public By Email = By.xpath("//input[@id='email']");
	public By Comment = By.xpath("//textarea[@id='comment']");
	public By Post = By.xpath("//input[@name='submit' and @id='send_comment']");
	public By Response = By.xpath("//div[@class='comment_not_approved']");
	
	@FindBy(xpath = "//a[contains(text(), '10 Book Recommendations')]")
	public WebElement anyBlog;
	
	@FindBy(xpath = "//a[contains(text(), 'Why')]")
	public WebElement foundBlog;
	
	@FindBy(css = "span[class*='post_info_tags']")
	public WebElement tags;

	
	public void postComment(String name, String email, String comment) {
		driver.findElement(anyBlog).click();
		driver.findElement(Comment).sendKeys(comment);
		driver.findElement(Name).sendKeys(name);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Post).click();
	}
	
	public boolean validate(By locator) {
		   return  driver.findElement(locator).isDisplayed();
		}
	
	public boolean validateTags(WebElement element) {
		   return element.getText().contains("Classic,News,Recommend");
		}
}