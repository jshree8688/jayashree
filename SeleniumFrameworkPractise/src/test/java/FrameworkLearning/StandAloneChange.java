//Back up

package FrameworkLearning;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkLearning.PageComponents.BaseTest;
import FrameworkLearning.pageObjects.CheckoutPage;
import FrameworkLearning.pageObjects.ConfirmationPage;
import FrameworkLearning.pageObjects.LandingPage;
import FrameworkLearning.pageObjects.OrderPage;
import FrameworkLearning.pageObjects.Productcatalogue;
import FrameworkLearning.pageObjects.cartPage;

import org.openqa.selenium.interactions.Actions;

public class StandAloneChange extends BaseTest {

	String prodname = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getdata", groups = { "Purchase" })

	public void StandAlone(HashMap<String,String> input) throws IOException, InterruptedException {

                            
        LandingPage landingpage=LaunchApplication();
        Productcatalogue productcatalogue=landingpage.LoginApplication(input.get("Email"), input.get("pwd"));
		List<WebElement> Products = productcatalogue.getProductLists();
		productcatalogue.addProductToCart(prodname);
		cartPage cartpage = productcatalogue.goToCartPage();

		Boolean match = cartpage.verifyproductDisplay(prodname);
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage = cartpage.goToCheckout();
		// Thread.sleep(7000);
		CheckoutPage.selectcountrydropdown();
		// Thread.sleep(7000);
		System.out.println("Country");
		ConfirmationPage ConfirmationPage = CheckoutPage.submitOrder();
		System.out.println("Confirm");
		String Orderplacedmsg = ConfirmationPage.verifyConfirmationMessage();
		System.out.println(Orderplacedmsg);
		Assert.assertTrue(Orderplacedmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//Assert.assertTrue(Orderplacedmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//Assert.assertTrue(Orderplacedmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("THANKYOU FOR THE ORDER");
		System.out.println("THANKYOU FOR THE ORDER1");
		System.out.println("THANKYOU FOR THE ORDER2");
		System.out.println("THANKYOU FOR THE ORDER3");
	}

	// To verify the order display values
//	@Test(dependsOnMethods = { "StandAlone" })
//	public void OrderHistoryTest() {
//		Productcatalogue productcatalogue = landingpage.LoginApplication("nakshathra06@gmail.com", "Shree@8688");
//		OrderPage orderpage = productcatalogue.goToOrderPage();
//		Assert.assertTrue(orderpage.verifyOrderDisplay(prodname));
//	}

	
	//How to get the data from @DataProvider
//	@DataProvider
//	public Object[][] getdata()
//	{
//		
//		return new Object[][] { { "nakshathra06@gmail.com", "Shree@8688", "ADIDAS ORIGINAL" },
//				{ "shree123@gmail.com", "Shree@8688", "ZARA COAT 3" } };
//	}
	
	
	//Hashmap to DataProvider to send data as a one Hash Object

	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Email", "nakshathra06@gmail.com");
		map.put("pwd", "Shree@8688");
		map.put("prodname", "ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("Email", "nakshathra06@gmail.com");
		map1.put("pwd", "Shree@8688");
		map1.put("prodname", "ADIDAS ORIGINAL");

		return new Object[][] { { map }, { map1 } };
	}
	
//To read data from the Json Files and create list of hashMaps for testing
	
//	@DataProvider
//	public Object[][] getdata()
//	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("Email", "nakshathra06@gmail.com");
//		map.put("pwd", "Shree@8688");
//		map.put("prodname", "ADIDAS ORIGINAL");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("Email", "nakshathra06@gmail.com");
//		map1.put("pwd", "Shree@8688");
//		map1.put("prodname", "ADIDAS ORIGINAL");
//
//		return new Object[][] { { map }, { map1 } };
//	}

}
