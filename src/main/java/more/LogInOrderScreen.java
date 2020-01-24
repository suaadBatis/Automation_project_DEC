package more;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.Test;
import utils.Utils;
import java.io.IOException;
import java.net.MalformedURLException;
import static Services.PrintFile.PrintFiles2;
import static Services.ScreenShot.screenshots;
import static Services.ScreenShot.takeScreenShot;
import static Services.ServerRunner.*;


public class LogInOrderScreen extends base  {
    public  static AppiumDriverLocalService service;
    AndroidDriver<AndroidElement> driver = capabilities();
    private static final String Suaad_ScreenShot=("./ScreenShots/");

    public LogInOrderScreen () throws MalformedURLException {
    }


    @Test
    public void MorePageWithLoggedInUser () throws IOException{
        ServerRunners ();
        Utils.sleep ( 1 );
        screenshots ( Suaad_ScreenShot + "finally", driver );
        takeScreenShot ( driver );
        String des = " Share your details here ex. Pass@word ";
        String path = "./PrintFilesFolder/suaad.txt";
        PrintFiles2 ( path, des );
        driver.findElementById ( "com.hungerstation.android.web.debug:id/smallLabel" ).click ();
        driver.findElementById ( "com.hungerstation.android.web.debug:id/orders_item" ).click ();
        driver.findElementById ( "com.hungerstation.android.web.debug:id/btnaction" ).click ();
        driver.findElementById ( "com.hungerstation.android.web.debug:id/phone_number" ).sendKeys ( "0500341221" );
        Utils.sleep ( 2 );
        driver.findElementById ( "com.hungerstation.android.web.debug:id/btn_login" ).click ();
        driver.findElementById ( "com.hungerstation.android.web.debug:id/edt_verification_number" ).sendKeys ( "000000" );
        Utils.sleep ( 2 );
        driver.findElementById ( "com.hungerstation.android.web.debug:id/more_item" ).click ();
    }
    @Test
    public void ReturnBack () throws MalformedURLException {
          AndroidDriver<AndroidElement> driver = capabilities();
          Utils.sleep (1);
          driver.findElementById ("com.hungerstation.android.web.debug:id/more_item").click ();Utils.sleep (3);
          driver.findElementByClassName ("androidx.drawerlayout.widget.DrawerLayout").click ();Utils.sleep (3);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
