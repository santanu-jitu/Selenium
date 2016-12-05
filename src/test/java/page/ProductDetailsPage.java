package page;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.Page;

public class ProductDetailsPage extends Page {

	public ProductDetailsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public LandingPage selectProduct(String prod_Title) throws IOException{
		
		
		//clicking the product
		driver.findElement(By.xpath(".//*[@id='result_16']/div/div/div/div[2]/div[2]/div[1]/a/h2")).click();
		Set <String> winids = driver.getWindowHandles();
		Iterator<String> itrate = winids.iterator();
		System.out.println(itrate.next()); //first window 
		String second_window = itrate.next(); //second window
		
		
		System.out.println(second_window);
		
		driver.switchTo().window(second_window);
		String actual_title=driver.findElement(By.xpath(".//*[@id='productTitle']")).getText();
		
		
		Assert.assertEquals(actual_title,prod_Title);
		
		
		return new LandingPage();
		
		
	}
}

