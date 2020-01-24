package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import utils.Utils;
import java.io.IOException;
import static Services.ScreenShot.screenshots;
import static Services.ServerRunner.ServerRunners;


public class LoginFromOrderScreen extends base {
    private static final String Suaad_ScreenShot=("./ScreenShots/");
    public static void main(String[]args) throws IOException {
        ServerRunners();
        AndroidDriver<AndroidElement> driver = capabilities ();
        Utils.sleep (5);
        driver.findElementById ("com.hungerstation.android.web.debug:id/smallLabel").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/orders_item").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/btnaction").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/phone_number").sendKeys ("0500341221");
        Utils.sleep (2);
        screenshots ( Suaad_ScreenShot + "LoginFromOrderScreen1", driver );
        driver.findElementById ("com.hungerstation.android.web.debug:id/btn_login").click ();
        driver.findElementById ("com.hungerstation.android.web.debug:id/edt_verification_number").sendKeys ("000000"); Utils.sleep (2);
        driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();
        Utils.sleep ( 2 );
        screenshots ( Suaad_ScreenShot + "LoginFromOrderScreen2", driver );
    }
}
