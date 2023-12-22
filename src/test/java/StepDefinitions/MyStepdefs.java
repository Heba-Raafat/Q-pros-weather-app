package StepDefinitions;

import Utilties.AbstractLogic;
import Utilties.Helpers;
import Utilties.AndroidLogic;
import Utilties.IoSLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MyStepdefs {
    private AbstractLogic WeatherMobileAppLogic;
    String platform= Helpers.platform();
    public MyStepdefs() throws IOException {
    if (platform.equalsIgnoreCase("Android"))
        WeatherMobileAppLogic = new AndroidLogic();
    else if (platform.equalsIgnoreCase("iOS"))
        WeatherMobileAppLogic=new IoSLogic();
    }
    @When("Change Temperature unit from C to F")
    public void changeTemperatureUnitFromCToF() {
        WeatherMobileAppLogic.changeTemperatureUnit();
    }
    @Then("Assert on main Weather screen that Temperature unit is F")
    public void assertOnMainWeatherScreenThatTemperatureUnitIsF() {
        WeatherMobileAppLogic.assertMainWeatherScreenTemperatureUnitIsF();
    }
    @Then("Change Time format from 24 to 12")
    public void changeTimeFormat24FromTo12() {
        WeatherMobileAppLogic.changeTimeFormat24FromTo12();
    }
    @Then("Assert on main Weather screen that Time format is 12")
    public void assertOnMainWeatherScreenThatTimeFormatIs12() {
        WeatherMobileAppLogic.assertMainWeatherScreenTimeFormatIs12();
    }
    @Then("Assert that chance of rain and humidity values are displayed for each hour for the next {int} hours")
    public void assertThatChanceOfRainAndHumidityValuesAreDisplayedForEachHourForTheNextHours(int expectedNumberOfHours) {
        WeatherMobileAppLogic.assertRainAndHumidityIconsForTheNextHours(expectedNumberOfHours);
    }
   @Given("Open Weather Forecast App")
    public void openWeatherForecastApp() throws IOException {
        WeatherMobileAppLogic.setUp();
        WeatherMobileAppLogic.openWeatherForecastApp();
    }
    @Then("Close the App")
    public void closeTheApp() {
        WeatherMobileAppLogic.tearDown();
    }
}
