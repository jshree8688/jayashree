package FrameworkLearning.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(id="userEmail")
	WebElement Email;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement loginsubmit;
	
	
	//div[@class='ng-tns-c4-31 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMessage;
	

	public String Errormessage()
	{
		waitForVisibility(errorMessage);
		System.out.println(errorMessage.getText());
	return errorMessage.getText();
		
	}
	
//	public void LoginApplication(String email,String password)
//	{
//		Email.sendKeys(email);
//		pwd.sendKeys(password);
//		loginsubmit.click();
//	}
	
	

	public Productcatalogue LoginApplication(String email,String password)
	{
		Email.sendKeys(email);
		pwd.sendKeys(password);
		loginsubmit.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
	}
	
	public void redirectpage()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
