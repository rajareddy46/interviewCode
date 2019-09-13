package Interview.Selenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCode {
	
	public  void screenshotmethood(WebDriver driver, String screenshotName)

	{
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File SS = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(SS, new File("./OutPut/" +timestamp()+" ---- "+screenshotName + ".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Exception while taking screenshot--- " + e.getMessage());
		}

	}

	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	} 

}
