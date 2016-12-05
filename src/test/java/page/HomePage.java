package page;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Page;

public class HomePage extends Page{
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

    //Login Scenario
	public LandingPage login(String username, String password) throws IOException{
		
		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : "+Config.getProperty("testsiteurl"));
		//setting the implictlywait
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		driver.findElement(By.xpath(OR.getProperty("username"))).clear();
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("login"))).click();
		log.info("Logged in with username"+username);
		//use the below try catch if the amazon shows captha. Please enter the password and captcha manually
		/*try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Getting the actual title of the page
		String actual_Title=driver.getTitle();
		String expected_Title="Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		if(actual_Title.contains("Amazon.in")){
			
			Assert.assertEquals(actual_Title, expected_Title, "Successfull Login");
			log.debug("Successfull Login");
			Actions action =new Actions(driver);
			WebElement element=driver.findElement(By.xpath(OR.getProperty("logout_mainmenu")));
			
			//WebElement element1=driver.findElement(By.xpath(OR.getProperty("signout")));
			
	//	WebDriverWait wait = new WebDriverWait(driver,40);
		  // WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signout"))));
		 //Explicit wait is not working and hence forced to use the Thread.sleep method, it takes amlost 40 second to get visible
			try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		                        
			//logout
			action.moveToElement(element).moveToElement(driver.findElement(By.xpath(OR.getProperty("signout")))).click().build().perform();
			action.click().build().perform();
			log.info("Logged out successfully");
			
			
			
			
		}
		
		else if(actual_Title.contains("Amazon Sign In")){
			//Reading the error message
			String error_Message=driver.findElement(By.xpath(OR.getProperty("errmsg"))).getText();
			Assert.assertEquals(error_Message, expected_Title, "Invalid Login");
			log.debug("Invalid Login");
			
		}
		
		return new LandingPage();
	}
	
	
	
	


}
