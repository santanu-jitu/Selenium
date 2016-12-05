package testcases;
import java.io.IOException;
import utility.TestUtil;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import page.LandingPage;
public class LoginTest extends TestBase{

	@Test(dataProvider="getData")
	public void doLogin(String un, String pwd) throws IOException{
		
		HomePage home = new HomePage();
		home.login(un,pwd);
		
	
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object [][] data=TestUtil.getData("LoginTest");
			
		return data;
	}
	
	
}
