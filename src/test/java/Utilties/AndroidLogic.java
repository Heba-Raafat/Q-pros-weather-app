package Utilties;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;

public class AndroidLogic extends AbstractLogic {
    protected By DoneBTN = By.id("com.info.weather.forecast:id/tv_button_done");
    protected By GotItBTN = By.id("com.info.weather.forecast:id/ll_got_it");
    protected By AllowLocationBTN = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    protected By SideBarMenu = By.id("com.info.weather.forecast:id/iv_bt_navigation_setting");
    protected By UnitSettingBTN = By.id("com.info.weather.forecast:id/ll_item_unit_setting");
    protected By FUnitTemp = By.xpath("//*[@text='F']");
    protected By TempList = By.id("com.info.weather.forecast:id/iv_temp_dropdown");
    protected By TimeFormatList = By.id("com.info.weather.forecast:id/iv_timeformat_dropdown");
    protected By _12Hour = By.xpath("//*[@text='12 Hour']");
    protected By TempUitInHome = By.id("com.info.weather.forecast:id/tv_current_temper_unit");
    protected By SunRiseTimeFormatInHome = By.id("com.info.weather.forecast:id/tv_sunrise_top");
    protected By SunSetTimeFormatInHome = By.id("com.info.weather.forecast:id/tv_sunset_top");
    protected By NumbOfHoursPrediction = By.xpath("//*[@resource-id='com.info.weather.forecast:id/tv_hour_item']");
    protected By RainIcons = By.xpath("//*[@resource-id='com.info.weather.forecast:id/iv_rain_chance']");
    protected By HumidityIcons = By.xpath("//*[@resource-id='com.info.weather.forecast:id/tv_humidity']");

    public AndroidDriver driver;
    @Override
    public void setUp() throws IOException {
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Helpers.android_desiredCapabilities());
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
        waitForElementVisibility(UnitSettingBTN,5);
        driver.findElement(UnitSettingBTN).click();
        waitForElementVisibility(TempList,5);
        driver.findElement(TempList).click();
        waitForElementVisibility(FUnitTemp,5);
        driver.findElement(FUnitTemp).click();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
    }
    @Override
    public void openWeatherForecastApp() {
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
        //click on GOT IT button
        waitForElementVisibility(GotItBTN,5);
        driver.findElement(GotItBTN).click();
        waitForElementVisibility(AllowLocationBTN,5);
        driver.findElement(AllowLocationBTN).click();
    }
    @Override
    public void assertMainWeatherScreenTemperatureUnitIsF(){
        waitForElementVisibility(TempUitInHome,5);
        Assert.assertTrue(driver.findElement(TempUitInHome).getText().contains("F"));
    }
    @Override
    public void changeTimeFormat24FromTo12(){
        waitForElementVisibility(SideBarMenu,5);
        this.driver.findElement(SideBarMenu).click();
        waitForElementVisibility(UnitSettingBTN,5);
        this.driver.findElement(UnitSettingBTN).click();
        waitForElementVisibility(TimeFormatList,5);
        driver.findElement(TimeFormatList).click();
        waitForElementVisibility(_12Hour,5);
        driver.findElement(_12Hour).click();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
    }
    @Override
    public void assertMainWeatherScreenTimeFormatIs12() {
        waitForElementVisibility(SunRiseTimeFormatInHome,5);
        Assert.assertTrue(Helpers.findIntegers(driver.findElement(SunRiseTimeFormatInHome).getText())<=12);
        Assert.assertTrue(Helpers.findIntegers(driver.findElement(SunSetTimeFormatInHome).getText())<=12);
    }
    @Override
    public void assertRainAndHumidityIconsForTheNextHours(int expectedNumberOfHours){
        Assert.assertEquals(driver.findElements(NumbOfHoursPrediction).size(),expectedNumberOfHours);
        Assert.assertEquals(driver.findElements(RainIcons).size(), expectedNumberOfHours);
        Assert.assertEquals(driver.findElements(HumidityIcons).size(), expectedNumberOfHours);
    }
}