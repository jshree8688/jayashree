package FrameworkLearning.PageComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import FrameworkLearning.pageObjects.LandingPage;
import FrameworkLearning.pageObjects.Productcatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {
	
	public WebDriver driver;
	//public Productcatalogue productcatalogue;
	
	public WebDriver intializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fileinput= new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//FrameworkLearning//resource//GlobalData.properties");
		prop.load(fileinput);
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		return driver;
	}
	@BeforeMethod
	public LandingPage LaunchApplication() throws IOException
	{
		driver=intializeDriver();
		LandingPage landingpage = new LandingPage(driver);
		//landingpage.LoginApplication(Email,Pwd);
		return landingpage;
	    
		

	}
	
	public void LoginpageURL()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	

}
