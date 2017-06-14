package pack1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFile {
    public String baseUrl = "http://newtours.demoaut.com/";
    String driverPath = "C:\\geckodriver-v0.17.0-win64\\geckodriver.exe";
    public WebDriver driver ; 
     
  @Test(priority=0)
  public void verifyHomepageTitle() {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.firefox.marionette", "../webdriver_64x/geckodriver.exe");
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.manage().window().maximize();
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
  @Test(priority=1)
  public void testGoogleSearch() throws InterruptedException {
    // Optional, if not specified, WebDriver will search your path for chromedriver.
	System.out.println("launching Chrome browser \n ");  
    System.setProperty("webdriver.chrome.driver", "../webdriver_64x/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com/");
    Thread.sleep(5000);  // Let the user actually see something!
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    Thread.sleep(5000);  // Let the user actually see something!
    driver.quit();
  }
}