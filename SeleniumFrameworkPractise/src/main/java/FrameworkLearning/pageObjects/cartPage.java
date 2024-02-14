package FrameworkLearning.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkLearning.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {
	WebDriver driver;

	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> CartProducts;
	
	@FindBy(css = "li[class='totalRow'] button")
	WebElement Checkout ;
	
		
	By checkoutButton = By.cssSelector("\"li[class='totalRow'] button\"");

	public boolean verifyproductDisplay(String prodname)
	{
	Boolean match = CartProducts.stream().anyMatch(cartproduct -> cartproduct.getText().equals(prodname));
	return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		
		Checkout.click();
		CheckoutPage CheckoutPage=new CheckoutPage(driver);
				return CheckoutPage;
	}

}
