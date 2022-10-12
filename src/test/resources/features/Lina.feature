Feature: Get Started>

  Scenario: Get Started>
    When user get "https://www.hiscox.com/partner-agent/btis"
    And click on Get Started link
    And write "Lina" in name
    And chose "Georgia" in State
    And chose "Accounting" Primary Occupation
    And click on Start Quote button
    Then verify recommended Products page is loaded

