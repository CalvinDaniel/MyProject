
Feature: TestMeApp
  
@tag1
  Scenario Outline: The user logs in 
  Given the user has to signin
  And the user provides "<Username>" and "<Password>"
  Then the user clicks the signin button
Examples:
  |Username|Password|
  |AlexUser|Alex@123|
@tag2
  Scenario: The one where user moves to cart without adding any items in it
  Given Alex has registered into testmeapp
  When alex searches for headphone
  And try to proceed without adding any items to the cart
  Then TestMeApp doesn't display the icon 

  
    