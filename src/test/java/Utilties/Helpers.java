package Utilties;


import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helpers{
    public static DesiredCapabilities desiredCapabilities() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        InputStream inputFile = new FileInputStream(projectPath+"/src/test/android.properties");
        prop.load(inputFile);
        capabilities.setCapability("platformName", prop.getProperty("platformName"));
        capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("app",projectPath + prop.getProperty("app"));
        capabilities.setCapability("automationName",prop.getProperty("automationName"));
        return capabilities;
    }
}
