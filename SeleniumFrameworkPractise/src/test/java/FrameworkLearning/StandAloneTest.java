//Back up

package FrameworkLearning;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import org.openqa.selenium.interactions.Actions;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitly);
		driver.get("https://rahulshettyacademy.com/client");
		
		
		driver.findElement(By.id("userEmail")).sendKeys("nakshathra06@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shree@8688");
		driver.findElement(By.id("login")).click();
		
		//Dynamically get all the Products List
		String prodname="ADIDAS ORIGINAL";
		List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));
		//System.out.println(Products);
	    WebElement Prod=
			Products.stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst().orElse(null);
	    Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//Redirecting to My cart Page Details
		List<WebElement> CartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	    Boolean match=	CartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(prodname));
		Assert.assertTrue(match);
		
		
		// Click on the button to proceed to checkout
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='totalRow'] button")));
        checkoutButton.click();
        
        //Capture Card Details Info
        driver.findElement(By.cssSelector("div[class='form-group'] input")).sendKeys("ind");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='list-group-item'] span")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='list-group-item'] span")));
        Thread.sleep(7000);
    	
    	WebElement selectcountry=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
       // List<WebElement> country= driver.findElements(By.cssSelector("button[class*='list-group-item'] span"));
       // System.out.println(country);
        Actions a=new Actions(driver);
		a.sendKeys(selectcountry,"ind").build().perform();
//        for(WebElement Choice:country)
//	    {
//	    	if (Choice.getText().equalsIgnoreCase("India"))
//	    			{
//	    		Choice.click();
//	    		break;
//	    			}
//	    }
        
        
    
        
        driver.findElement(By.cssSelector(".action__submit")).click();
        
      String Orderplacedmsg=  driver.findElement(By.cssSelector(".hero-primary")).getText();
      Assert.assertTrue(Orderplacedmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(Orderplacedmsg);
		driver.close();
	}

}
