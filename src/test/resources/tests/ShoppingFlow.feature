@ShoppingFlow
Feature: User is able select an item and successfully add it to the cart
  Scenario: 1. Verify that user is successfully able to login to his/her account
    Given User is logged in with his/her credentials
    And on 'My Account' Page with title "My account - My Store"
    When User clicks on "Dresses" menu tab
    And Selects "SummerDresses' menu under Dresses section on left
    Then User is able to see items for selection under "SummerDresses" menu

  Scenario: 2. User is able to select a product from "SummerDresses" Menu
    Given User is now on the "SummerDresses" selection menu with title "Summer Dresses - My Store"
    When User clicks on "QuickView" option on product with name "Printed Summer Dress"
    Then User is able to see selected product details in an overlay

  Scenario: 2. User is able to add selected product into cart
    Given User is on the selected product "QuickView"  overlay
    When User clicks on "AddToCart" button to add the product in the cart
    Then User is able to see a confirmation messages as "Product successfully added to your shopping cart"