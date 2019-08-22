package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helper {
	//take screenshot on failure
	public static void captureScreenShot(WebDriver driver, String screenshotName)
	{
		Path dest=Paths.get("./Screenshots", screenshotName+".png");
		try {
			java.nio.file.Files.createDirectories(dest.getParent());
			FileOutputStream out =new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {

			System.out.println("exception while taking screenshot");


		}
	}
	}
