package Utilties;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;

public class IoSLogic extends AbstractLogic {
    protected By SideBarMenu = By.name("Location List");
    protected By SettingBTN = By.xpath("//XCUIElementTypeCollectionView[@name=\"Location List\"]/XCUIElementTypeOther[1]");
    protected By FUnitTemp = By.name("Fahrenheit");
    protected By MyLocation = By.name("My Location");
    public IOSDriver driver;
    @Override
    public void setUp() throws IOException {
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), Helpers.IoS_desiredCapabilities());
    }

    public void waitForElementVisibility(By element, int sec){
        WebDriverWait wait = new WebDriverWait(driver,sec );
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }
    @Override
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Override
    public void changeTemperatureUnit() {
        waitForElementVisibility(SideBarMenu,5);
        driver.findElement(SideBarMenu).click();
        waitForElementVisibility(SettingBTN,5);
        driver.findElement(SettingBTN).click();
        waitForElementVisibility(FUnitTemp,5);
        driver.findElement(FUnitTemp).click();
        driver.findElement(MyLocation).click();
    }
    @Override
    public void openWeatherForecastApp() {

    }
    @Override
    public void assertMainWeatherScreenTemperatureUnitIsF(){

    }

    @Override
    public void changeTimeFormat24FromTo12(){

    }
    @Override
    public void assertMainWeatherScreenTimeFormatIs12() {

    }
    @Override
    public void assertRainAndHumidityIconsForTheNextHours(int expectedNumberOfHours){

    }
}
