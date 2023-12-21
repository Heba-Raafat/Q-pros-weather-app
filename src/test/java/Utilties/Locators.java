package Utilties;

import org.openqa.selenium.By;

public class Locators {
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
}
