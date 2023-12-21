package Utilties;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class setup extends Locators{
    public AndroidDriver driver;
    public void setUp() throws IOException {
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Helpers.desiredCapabilities());
    }

    public void waitForElementVisibility(By element, int sec){
        WebDriverWait wait = new WebDriverWait(driver,sec );
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public int findIntegers(String stringToSearch) {
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