package Utilties;


import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers{
    public static String platform() throws IOException {
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        InputStream inputFile = new FileInputStream(projectPath+"/src/test/platform.properties");
        prop.load(inputFile);
        String platform = prop.getProperty("PLATFORM");
        return platform;
    }

    public static DesiredCapabilities android_desiredCapabilities() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        InputStream inputFile = new FileInputStream(projectPath+"/src/test/android.properties");
        prop.load(inputFile);
        capabilities.setCapability("platformName", "Android");
        //prop.getProperty("platformName")
        capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("app",projectPath + prop.getProperty("app"));
        capabilities.setCapability("automationName",prop.getProperty("automationName"));
        return capabilities;
    }

    public static DesiredCapabilities IoS_desiredCapabilities() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        InputStream inputFile = new FileInputStream(projectPath+"/src/test/IoS.properties");
        prop.load(inputFile);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("app",projectPath + prop.getProperty("app"));
        capabilities.setCapability("automationName",prop.getProperty("automationName"));
        capabilities.setCapability("udid",prop.getProperty("udid"));
        capabilities.setCapability("bundleId",prop.getProperty("bundleId"));
        return capabilities;
    }
    public static int findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }
        System.out.println((integerList.get(0)));
        return Integer.parseInt(integerList.get(0));
    }
}
