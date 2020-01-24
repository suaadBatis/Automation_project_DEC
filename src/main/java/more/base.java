package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base{
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        File app = new File(System.getProperty("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        //emulator
        //desiredCapabilities.setCapability ("deviceName", "emulator-5554");
        //desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability ("platformVersion", "9.0");
        desiredCapabilities.setCapability ("deviceName", "Suaad");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        desiredCapabilities.setCapability( MobileCapabilityType.TAKES_SCREENSHOT, "true");
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.sleep (5);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
        return driver; // super variable
    }
}