package StepDefinitions;

import Utilties.setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStepdefs extends setup {
    @When("Change Temperature unit from C to F")
    public void changeTemperatureUnitFromCToF() throws InterruptedException {
        waitForElementVisibility(SideBarMenu,5);
        driver.findElement(SideBarMenu).click();
        Thread.sleep(500);
        waitForElementVisibility(UnitSettingBTN,5);
        driver.findElement(UnitSettingBTN).click();
        Thread.sleep(400);
        waitForElementVisibility(TempList,5);
        driver.findElement(TempList).click();
        waitForElementVisibility(FUnitTemp,5);
        driver.findElement(FUnitTemp).click();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
        Thread.sleep(700);
    }
    @Then("Assert on main Weather screen that Temperature unit is F")
    public void assertOnMainWeatherScreenThatTemperatureUnitIsF() throws InterruptedException {
        waitForElementVisibility(TempUitInHome,5);
        Assert.assertTrue(driver.findElement(TempUitInHome).getText().contains("F"));
    }
    @Then("Change Time format from 24 to 12")
    public void changeTimeFormat24FromTo12() throws InterruptedException {
        Thread.sleep(200);
        waitForElementVisibility(SideBarMenu,5);
        this.driver.findElement(SideBarMenu).click();
        Thread.sleep(500);
        waitForElementVisibility(UnitSettingBTN,5);
        this.driver.findElement(UnitSettingBTN).click();
        Thread.sleep(500);
        waitForElementVisibility(TimeFormatList,5);
        driver.findElement(TimeFormatList).click();
        waitForElementVisibility(_12Hour,5);
        driver.findElement(_12Hour).click();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
        Thread.sleep(700);
    }
    @Then("Assert on main Weather screen that Time format is 12")
    public void assertOnMainWeatherScreenThatTimeFormatIs12() {
        waitForElementVisibility(SunRiseTimeFormatInHome,5);
        Assert.assertTrue(findIntegers(driver.findElement(SunRiseTimeFormatInHome).getText())<=12);
        Assert.assertTrue(findIntegers(driver.findElement(SunSetTimeFormatInHome).getText())<=12);
    }
    @Then("Assert that chance of rain and humidity values are displayed for each hour for the next {int} hours")
    public void assertThatChanceOfRainAndHumidityValuesAreDisplayedForEachHourForTheNextHours(int expectedNumberOfHours) {
        Assert.assertEquals(driver.findElements(NumbOfHoursPrediction).size(),expectedNumberOfHours);
        Assert.assertEquals(driver.findElements(RainIcons).size(), expectedNumberOfHours);
        Assert.assertEquals(driver.findElements(HumidityIcons).size(), expectedNumberOfHours);
    }
    @Given("Open Weather Forecast App")
    public void openWeatherForecastApp() throws IOException, InterruptedException {
        setUp();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
        //click on GOT IT button
        Thread.sleep(500);
        waitForElementVisibility(GotItBTN,5);
        driver.findElement(GotItBTN).click();
        Thread.sleep(500);
        waitForElementVisibility(AllowLocationBTN,5);
        driver.findElement(AllowLocationBTN).click();
        Thread.sleep(5000);
    }
    @Then("Close the App")
    public void closeTheApp() {
        tearDown();
    }
}
