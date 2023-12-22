package Utilties;

import org.openqa.selenium.By;

import java.io.IOException;

public abstract class AbstractLogic {
    public abstract void changeTemperatureUnit();
    public abstract void tearDown();
    public abstract void setUp() throws IOException;
    public abstract void openWeatherForecastApp();
    public abstract void assertMainWeatherScreenTemperatureUnitIsF();
    public abstract void changeTimeFormat24FromTo12();
    public abstract void assertMainWeatherScreenTimeFormatIs12();
    public abstract void assertRainAndHumidityIconsForTheNextHours(int expectedNumberOfHours);
}
