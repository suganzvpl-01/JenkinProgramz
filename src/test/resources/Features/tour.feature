
Feature: Tour Features
I am using this URL "http://demo.guru99.com/test/newtours/register.php"

  @Test
  Scenario: Register with Single User
    Given I Open my URL
    When I Enter the details for all the Fields
    And Enter the Submit for Registration
    Then The Registration Completed Successfully for Single User
    And Take a Screenshot
    And I close my Browser
 
  #@scenarioOTag
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
