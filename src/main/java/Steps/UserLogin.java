package Steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UserLogin{


    public static void UserLoginOrder()  {
        try{
        File app = new File(System.getProperty("user.dir") + "/App/app-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("deviceName", "emulator-5554");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
        desiredCapabilities.setCapability( MobileCapabilityType.TAKES_SCREENSHOT, "true");
        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
            AppiumDriver  driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.sleep (15);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
        Utils.sleep (1);
        driver.findElementById ("com.hungerstation.android.web.debug:id/smallLabel").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/orders_item").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/btnaction").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/phone_number").sendKeys ("0500341221");
        Utils.sleep (2);
        driver.findElementById ("com.hungerstation.android.web.debug:id/btn_login").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/edt_verification_number").sendKeys ("000000"); Utils.sleep (2);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
    }catch (MalformedURLException| NullPointerException  e){
          System.out.println ( "hello bug" );
        }
    }
}
