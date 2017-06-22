package homepage;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*
 * 1. Search via keyword & Location
 */

public class LocationSearch {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "../webdriver_64x/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://test.interviewair.com";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test (priority=1)
	public void testCandidateLogin() throws Exception {
		driver.get(baseUrl+"/browse-jobs/");
		
		driver.findElement(By.id("jobQuery")).click();
		driver.findElement(By.id("jobQuery")).clear();
	    driver.findElement(By.id("jobQuery")).sendKeys("java developer");
	    
	    driver.findElement(By.id("searchBy_jobLoc")).click();
	    driver.findElement(By.id("searchBy_jobLoc")).clear();
	    driver.findElement(By.id("searchBy_jobLoc")).sendKeys("mumbai");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	    String location = driver.findElement(By.id("searchBy_jobLoc")).getAttribute("value");
		String jobQuery = driver.findElement(By.id("jobQuery")).getAttribute("value");
		String Title = driver.getTitle();
		
		System.out.println("\n Location " + location + "\n Query "+ jobQuery + "\n Title "+ Title );
		 
		if (location.equals("mumbai,") && jobQuery.equals("java developer,") && Title.equals("java developer Jobs | India's No 1 Video Interview Platform - Interview Air")){
			System.out.println("page loaded");
		}else{
			System.out.println("ERROR > page loaded");
		}
		System.out.println("Done ");
	}
	
	//@Test (priority=2)
	@Test(enabled = false)
	public void searchwithlocationfilter() throws Exception {
		driver.get(baseUrl+"/browse-jobs/");
		
		driver.findElement(By.id("jobQuery")).click();
		driver.findElement(By.id("jobQuery")).clear();
	    driver.findElement(By.id("jobQuery")).sendKeys("java developer");
	    
	    driver.findElement(By.id("searchBy_jobLoc")).click();
	    driver.findElement(By.id("searchBy_jobLoc")).clear();
	    driver.findElement(By.id("searchBy_jobLoc")).sendKeys("mumbai");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	    String location = driver.findElement(By.id("searchBy_jobLoc")).getAttribute("value");
		String jobQuery = driver.findElement(By.id("jobQuery")).getAttribute("value");
		String Title = driver.getTitle();
		
		System.out.println("\n Location " + location + "\n Query "+ jobQuery + "\n Title "+ Title );
		 
		if (location.equals("mumbai,") && jobQuery.equals("java developer,") && Title.equals("java developer Jobs | India's No 1 Video Interview Platform - Interview Air")){
			System.out.println("page loaded");
		}else{
			System.out.println("ERROR > page loaded");
		}
		System.out.println("Done ");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();
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


