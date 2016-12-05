package base;

import org.testng.annotations.AfterSuite;

import sun.util.logging.resources.logging;

public class TestBase {
	
	
	
	public void setUp(){
		
		//set up the required DataBase connection
		
	}
	
	
	@AfterSuite
	public void tearDown(){
		// Quit the driver after the suite is executed
		Page.driver.quit();
		
	}

}
