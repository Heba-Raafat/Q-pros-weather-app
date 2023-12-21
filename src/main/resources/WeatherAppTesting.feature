Feature: Regression testing in weather app

 Scenario: Changing Temperature unit from C to F and assertions on main Weather screen
   Given Open Weather Forecast App
   When Change Temperature unit from C to F
   Then Assert on main Weather screen that Temperature unit is F
   Then Change Time format from 24 to 12
   Then Assert on main Weather screen that Time format is 12
   Then Assert that chance of rain and humidity values are displayed for each hour for the next 6 hours
   Then Close the App