package FrameworkLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents
{
	
	WebDriver driver;

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> Productnames ;
	
	public boolean verifyOrderDisplay(String prodname)
	{
	Boolean match = Productnames.stream().anyMatch(orderproduct -> orderproduct.getText().equals(prodname));
	return match;
	}

}
