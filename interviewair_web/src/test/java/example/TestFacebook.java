package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFacebook {
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {	
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.firefox.marionette", "../webdriver_64x/geckodriver.exe");
		driver = new FirefoxDriver();  
		driver.manage().window().maximize();
	}	

	@Test
	public void TestOR() throws IOException{

		// Specify the file location I used . operation here because
		//we have object repository inside project directory only
		//interviewair_web/src/test/resources/

		File src=new File("../interviewair_web/src/test/resources/homepage_Repo.properties");

		// Create  FileInputStream object
		FileInputStream fis=new FileInputStream(src);

		// Create Properties class object to read properties file
		Properties pro=new Properties();

		// Load file so we can use into our script
		pro.load(fis);

		System.out.println("Property class loaded");

		driver.get("http://www.facebook.com");
		
		// Enter username here I used keys which is specified in Object repository.
		// Here getProperty is method which
		// will accept key and will return value for the same
		driver.findElement(By.xpath(pro.getProperty("facebook.login.username.xpath"))).
		sendKeys("Selenium@gmail.com");

		// Enter password here I used keys which is specified in Object repository.
		// Here getProperty is method which
		// will accept key and will return value for the same
		driver.findElement(By.xpath(pro.getProperty("facebook.login.password.xpath"))).
		sendKeys("adsadasdas");

		// Click on login button here I used keys which is specified in Object repository.
		// Here getProperty is method which
		// will accept key and will return value for the same
		driver.findElement(By.xpath(pro.getProperty("facebook.login.Signup.xpath"))).click();

	}

}
