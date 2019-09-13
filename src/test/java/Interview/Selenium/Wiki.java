package Interview.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Wiki 
{

	ScreenShotCode screenshot = new ScreenShotCode();
	
	WebDriver driver;
	@Test
	public  void test() throws Exception {
 		
 		driver=new FirefoxDriver();
 		//1. Open the page https://en.wikipedia.org/wiki/...
 	    driver.get("https://en.wikipedia.org/wiki/Selenium ");
 		driver.manage().window().maximize();
 		
 		//2. Verify that the external links in “External links“ section work
 		driver.findElement(By.xpath("//a[@href='#External_links']")).click();
 		String externallinks=driver.findElement(By.xpath(" //span[@id='External_links']")).getText();
 		Assert.assertEquals("External links", externallinks);
 		Reporter.log("External link is verified",true);
 		
 		//3. Click on the “Oxygen” link on the Periodic table at the bottom of the page
 		driver.findElement(By.xpath("//td[@title='O, Oxygen']//span[contains(text(),'O')]")).click();
 		
 		//4. Verify that it is a “featured article”
 		String featuredlink=driver.findElement(By.xpath("//*[@id='toc']/div/h2")).getText();
 		Assert.assertEquals("Contents", featuredlink);
 		Reporter.log("It is featured link",true);
 		
 		//5. Take a screenshot of the right hand box that contains element properties
 		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        screenshot.screenshotmethood(driver, "oxygen properties"); 
        
        //6. Count the number of pdf links in “References“
        List<WebElement> listPdf = driver.findElements(By.xpath("//ol[@class='references' ]/*//*/a[contains(@href,'.pdf')]"));
        Reporter.log(" The number of pdf links in “References“ ::" + listPdf.size(),true);
        
        //7. In the search bar on top right enter “pluto” and verify that the 2 nd suggestion is “Plutonium”
        Actions act=new Actions(driver);
        act.clickAndHold(driver.findElement(By.xpath("//*[@id='searchInput']")));
        act.sendKeys("pluto").perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.DOWN).perform();
        act.sendKeys(Keys.DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
        Reporter.log("2nd option is "+ driver.getTitle().substring(0,9),true); 
        
        driver.close();
        
	}
}
		
	

