package example;		

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;		
public class NewTest {		
	    public WebDriver driver;		
	    
		@BeforeTest
		public void beforeTest() {	
			System.out.println("launching firefox browser"); 
			System.setProperty("webdriver.firefox.marionette", "../webdriver_64x/geckodriver.exe");
		    driver = new FirefoxDriver();  
		}
		
		@Test				
		public void testEasy() {	
			driver.get("http://demo.guru99.com/selenium/guru99home/");  
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}