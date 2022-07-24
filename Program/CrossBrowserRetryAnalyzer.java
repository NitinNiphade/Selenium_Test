package TestNg_Program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserRetryAnalyzer {
	WebDriver driver;
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  public void login() {
		  WebElement userid = driver.findElement(By.xpath("//input[@id='email']"));
		  WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
		  WebElement loginBtn= driver.findElement(By.xpath("//button[@name='login']"));
		  
		  userid.sendKeys("Nitin@gmail.com");
		  password.sendKeys("12345");
		  loginBtn.click();	  
	  }
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  public void getTitle() {
		  String ExpectedTitle="Facebook – log in or Sign up";
		  String ActualTitle= driver.getTitle();
		  Assert.assertEquals(ActualTitle, ExpectedTitle);	  
	  }
	  @Test
	  public void teardown() {
		  driver.close();
	  }
	  
	  @Parameters("browser")
	  @BeforeClass
	  public void beforeClass(String browser) {
		  if (browser.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajat\\eclipse-workspace\\Selenium_March_22\\Binary\\chromedriver.exe");
			  driver = new ChromeDriver();		  
		  }
		  else if(browser.equalsIgnoreCase("edge")) {
			  System.setProperty("webdriver.edge.driver", "C:\\Users\\Rajat\\eclipse-workspace\\Selenium_March_22\\Binary\\msedgedriver.exe");
			  driver = new EdgeDriver();
		  }
		  driver.get("https://www.facebook.com");
	  }

	}

