package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import utils.Utils;
import java.net.MalformedURLException;

import static Services.ServerRunner.ServerRunners;


public class LoginFromOrderScreen extends base {

    public static void main(String[]args) throws MalformedURLException {
        ServerRunners();
        AndroidDriver<AndroidElement> driver = capabilities ();
        Utils.sleep (5);
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
       driver.quit ();
    }
}
