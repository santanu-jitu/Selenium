package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


import utility.ExcelReader;

public class Page {
	
	//Initializing the driver and properties file
	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties_testdata\\testdata.xlsx");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	//Initializing the Logger
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	public Page() throws IOException{
		
            if(driver==null){
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties_testdata\\OR.properties");
			//Load Ojject repository properties file
			OR.load(fis);
			//log.info("OR Property file loaded");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties_testdata\\Config.properties");
			//Load Config properties file
			Config.load(fis);
			
			//log.info("config Property file loaded");
			
			
			
			if(Config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				log.info("Firefox Initialized");
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.info("InternetExplorer Initialized");
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				log.info("Chrome Initialized");
			}
			
			
}
            
	}
	
	

	}


