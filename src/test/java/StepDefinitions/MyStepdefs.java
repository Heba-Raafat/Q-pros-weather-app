package StepDefinitions;

import Utilties.setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class MyStepdefs extends setup {
    @When("Change Temperature unit from C to F")
    public void changeTemperatureUnitFromCToF()  {
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
    @Then("Assert on main Weather screen that Temperature unit is F")
    public void assertOnMainWeatherScreenThatTemperatureUnitIsF() {
        waitForElementVisibility(TempUitInHome,5);
        Assert.assertTrue(driver.findElement(TempUitInHome).getText().contains("F"));
    }
    @Then("Change Time format from 24 to 12")
    public void changeTimeFormat24FromTo12() {
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
    public void openWeatherForecastApp() throws IOException {
        setUp();
        waitForElementVisibility(DoneBTN,5);
        driver.findElement(DoneBTN).click();
        //click on GOT IT button
        waitForElementVisibility(GotItBTN,5);
        driver.findElement(GotItBTN).click();
        waitForElementVisibility(AllowLocationBTN,5);
        driver.findElement(AllowLocationBTN).click();
    }
    @Then("Close the App")
    public void closeTheApp() {
        tearDown();
    }
}
