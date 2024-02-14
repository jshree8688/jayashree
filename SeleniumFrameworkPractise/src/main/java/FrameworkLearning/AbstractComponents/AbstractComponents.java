package FrameworkLearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkLearning.pageObjects.OrderPage;
import FrameworkLearning.pageObjects.cartPage;

public class AbstractComponents
{
    WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement Orderheader;

	By cartHeaderby = By.cssSelector("[routerlink*='cart']");
	
	public cartPage goToCartPage()
	{
		waitForElementToClickable(cartHeaderby);
		cartHeader.click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
	
	public OrderPage goToOrderPage()
	{
		Orderheader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForVisibility(WebElement wbele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(wbele));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public WebElement waitForElementToClickable(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

}
