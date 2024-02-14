package FrameworkLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.AbstractComponents.AbstractComponents;

public class Productcatalogue extends AbstractComponents {
	WebDriver driver;

	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> Products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By Productsby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");

	public List<WebElement> getProductLists() {
		waitForElementToAppear(Productsby);
		return Products;
	}

	public WebElement getProductName(String prodname) {
		WebElement Prod = getProductLists().stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst()
				.orElse(null);
		return Prod;
	}

	public void addProductToCart(String prodname) {
		WebElement Prod = getProductName(prodname);
		Prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
