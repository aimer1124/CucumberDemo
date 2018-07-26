Feature: Baidu Search Content


 Scenario: Search result in browser title
   Given the page is open "http://www.baidu.com"
   When I search for "Cucumber"
   Then a browser title should contains "Cucumber"

