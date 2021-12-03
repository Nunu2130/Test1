package android;

import java.net.URL;
import org.testng.annotations.Test;

public class FirstAndroid extends BasePageAndroid
{
 @Test
 public void FirstTest() throws MalformedException()
 {
	 AndroidDriver<AndroidElement> driver = capabilities;
	 driver.findElementByXpath("//android.widget.TextView[@content-desc=\"Preference\"]").click();
 }
 
}
