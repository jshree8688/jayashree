package FrameworkLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents
{
	WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement Submit ;
	
	By Submitby = By.xpath("//a[normalize-space()='Place Order']");
	
	
	////a[normalize-space()='Place Order']
	//@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	//WebElement Submit ;
	
	//By Submitby = By.cssSelector(".btnn.action__submit.ng-star-inserted");

	//@FindBy(css = "div[class='form-group'] input")
	//WebElement Country ;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement Country ;
	
	//[placeholder="Select Country"]
	
//	@FindBy(css = "button[class*='list-group-item'] span")
//	List<WebElement> selectcountry;
	
	
	//@FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
	//WebElement selectcountry;
	
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement selectcountry;
	
	By resultsby = By.cssSelector(".ta-results");
	
	public void selectcountrydropdown()
	{
		//Country.sendKeys("ind");
		System.out.println("hai");
		Actions a=new Actions(driver);
		a.sendKeys(Country,"ind").build().perform();
		waitForElementToAppear(resultsby);
		selectcountry.click();
		
//		for (WebElement Choice : selectcountry) {
//			if (Choice.getText().equalsIgnoreCase("India")) {
//				Choice.click();
//				break;
//			}
//		}
		
		//waitForElementToClickable(Submitby);
		
	}
	
	public ConfirmationPage submitOrder()
	{
		waitForElementToClickable(Submitby);
		System.out.println("Confirmation2");
		Submit.click();
		ConfirmationPage ConfirmationPage=new ConfirmationPage(driver);
		return ConfirmationPage;
		
	}
}
