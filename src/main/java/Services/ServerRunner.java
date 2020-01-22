package Services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;

import java.io.File;

import static more.LogInOrderScreen.service;

public class ServerRunner {


    public static void ServerRunners() throws NullPointerException {

        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Logs/MoreLgedinUser2020.log")));
        service.start();

    }

    @AfterClass
    public static void StopServer () throws NullPointerException
    {
        service.stop(); // check the logs folder
    }


}
