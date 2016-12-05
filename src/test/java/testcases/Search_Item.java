package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Page;
import base.TestBase;
import page.LandingPage;
import page.TopNavigation;
import utility.TestUtil;

public class Search_Item extends TestBase {
	
	@Test(dataProvider="getData",priority=1)
	public void searchItem( String username, String pwd,String itemName) throws IOException{
		
		TopNavigation topNav= new TopNavigation();
		
		LandingPage lp = topNav.doSearch(username,pwd,itemName);
		
	
		
	}
	
	@Test(dataProvider="getData", priority=2)
	public void displayItem( String username, String pwd,String itemName) throws IOException{
		
		TopNavigation topNav= new TopNavigation();
		
		LandingPage lp = topNav.validateSearchItem(itemName);
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][]data=TestUtil.getData("SearchItem");
		return data;
		
		
	}


}
