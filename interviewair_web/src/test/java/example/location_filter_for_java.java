package example;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import utility01.systemProperty;

public class location_filter_for_java {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  systemProperty set = new systemProperty();
	  set.setdriver(driver);
	  driver = new FirefoxDriver();
	  baseUrl = "https://test.interviewair.com";
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @Test
  public void testLocationFilterForJobInTestng() throws Exception {
	String  valuefromfilter = null;
	String  valuefromfiltertagbar = null;
    int i; 
    driver.get(baseUrl + "/");
    Thread.sleep(2*1000);
    driver.findElement(By.cssSelector("input.search-btn.md-display")).click();	
    Thread.sleep(4*1000);
    for(i = 2; i < 6; i++){
    	driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div["+i+"]/md-checkbox/div")).click();
    	
    	valuefromfilter = driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div["+i+"]/md-checkbox/div[2]/span")).getText();
        System.out.println("valuefromfilter= "+ valuefromfilter);
        
        Thread.sleep(1*1000);
        
        valuefromfiltertagbar = driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div[2]/div[2]/div/div/div["+(i-1)+"]/span")).getText();
        System.out.println("valuefromfiltertagbar=  "+ valuefromfiltertagbar);
        
        if(valuefromfilter.equals(valuefromfiltertagbar) == false){
        	System.out.println("Problem in Location Filter Values");
        	break;
        }
    }
    
    if((valuefromfilter.equals(valuefromfiltertagbar) == true) && i == 6){
    	System.out.println("Location Filter Values Are Perfect");

    }
    
    
   /* driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[2]/md-checkbox/div")).click();
    a = driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[2]/md-checkbox/div[2]/span")).getText();
    System.out.println("hi "+a);
    Thread.sleep(1*1000);
    driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[3]/md-checkbox/div")).click();
    b = driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[3]/md-checkbox/div[2]/span")).getText();
    System.out.println("bye "+b);
    Thread.sleep(1*1000);
    driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[4]/md-checkbox/div")).click();
    c = driver.findElement(By.xpath("//div[@id='joblist_wrap']/md-content/div/section/section/div/div/div[3]/div[4]/md-checkbox/div[2]/span")).getText();
    System.out.println("guy "+c);
    Thread.sleep(3*1000);
    driver.findElement(By.xpath("(//button[@type='button'])[32]")).click();
    Thread.sleep(3*1000);
    driver.findElement(By.xpath("(//button[@type='button'])[32]")).click();
    Thread.sleep(3*1000);
    driver.findElement(By.xpath("(//button[@type='button'])[32]")).click();
    Thread.sleep(2*1000);
    // ERROR: Caught exception [unknown command [clickandWait]]*/
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
