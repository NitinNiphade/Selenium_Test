package TestNg_Program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertHardDemo {
	
	WebDriver driver;
	@Test
	public void kite() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajat\\eclipse-workspace\\Selenium_March_22\\Binary\\chromedriver.exe");
		  driver =new ChromeDriver();
		  driver.get("https://kite.zerodha.com/");
		
				  
		  //Hard Assert  //Hard assert terminate the method program if any condition is not satisfied
		  String expectedresult= "Kite - Zerodha's fast and elegant flagship trading platform";
		  String actualresult=driver.getTitle();
		  Assert.assertEquals(actualresult, expectedresult);
		  
		  WebElement kitelogo= driver.findElement(By.xpath("//img[contains(@src,'kite-logo')]"));
		  Assert.assertTrue(kitelogo.isDisplayed());
	}
	@Test
	public void facebook() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Rajat\\eclipse-workspace\\Selenium_March_22\\Binary\\msedgedriver.exe");
		  driver =new EdgeDriver();
		  driver.get("https://www.facebook.com");	
		  
		//Hard Assert
		  String expectedres= "Facebook – log in or sign up";
		  String actualres=driver.getTitle();
		  Assert.assertEquals(actualres, expectedres);
	}
}
