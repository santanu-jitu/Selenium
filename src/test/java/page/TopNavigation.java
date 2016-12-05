package page;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.Page;
import page.LandingPage;
//This is the class after login but having the top search and other facilites
public class TopNavigation extends Page{

	
	public TopNavigation() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

		
	
	public LandingPage doSearch(String username, String pwd, String itemName) throws IOException{
		driver.findElement(By.xpath(OR.getProperty("username"))).clear();
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(pwd);
		driver.findElement(By.xpath(OR.getProperty("login"))).click();
		log.info("Logged in Successfully");
		//use the below try catch if the amazon shows captha. Please enter the password and captcha manually
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		Page.driver.findElement(By.xpath(OR.getProperty("searchbox"))).sendKeys(itemName);
		WebElement mainMenu= driver.findElement(By.id("suggestions"));
		//Finding the suggestion items
		List <WebElement> suggestions=mainMenu.findElements(By.className("s-suggestion"));
		for(WebElement suggestion: suggestions){
			
			String text= suggestion.getAttribute("data-keyword");
			Assert.assertTrue(text.contains(itemName), "Suggestion is correct");
		}
		
		
		
			return new LandingPage();
		
	}
	
	
	public LandingPage validateSearchItem(String itemName) throws IOException{
		SoftAssert s_assert = new SoftAssert();
		driver.findElement(By.xpath(OR.getProperty("searchbutton"))).click();
		String totalPageCount=driver.findElement(By.xpath(".//*[@id='pagn']/span[6]")).getText();
		//System.out.println("The total page count is"+totalPageCount);
		int totalpage=Integer.parseInt(totalPageCount);
		WebElement block= driver.findElement(By.xpath(".//ul[@id='s-results-list-atf']"));
		//for(int i=1; i<=totalpage;i++){
		List <WebElement> displayItems= block.findElements(By.tagName("li"));
		//System.out.println("The size is:"+displayItems.size());
		
	for(WebElement item: displayItems){
			
			
			List <WebElement> links=item.findElements(By.tagName("a"));
			for(WebElement link: links){
				String title= link.getAttribute("title");
			String link1=title.toLowerCase();
					
			if(link1!=null && link1!=""){
				
				
			s_assert.assertTrue(link1.contains(itemName.toLowerCase()),"Displayed product is correct");
			
		}
			}
			//Clicking the next button
			driver.findElement(By.xpath(OR.getProperty("paginationnext"))).click();
			
			
			
		} 
	//	}
		
		s_assert.assertAll();
		
			return new LandingPage();
		
	}
	

	
	
}
