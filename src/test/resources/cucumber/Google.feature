Feature: Gradle-Cucumber integration


 Scenario: results are shown
   Given the page is open "http://www.google.com"
   When I search for "Cucumber"
   Then a browser title should contains "Cucumber"

