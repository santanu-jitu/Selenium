package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import page.ProductDetailsPage;
import utility.TestUtil;

public class ProductDetail extends TestBase {
	
	@Test(dataProvider="getData")
	public void productDetailMatch(String title) throws IOException{
		ProductDetailsPage prod= new ProductDetailsPage();
		prod.selectProduct(title);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object [][] data=TestUtil.getData("ProductMatch");
			
		return data;
	}
	

}
