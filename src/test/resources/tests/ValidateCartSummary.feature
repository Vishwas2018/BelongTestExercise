@ValidateCartSummary
Feature: Verify the contents of the cart for selected product
  Background: User is successfully registered in automation practice website
    Scenario: 1. Verify User is able to add an item from 'SummerDresses' Menu
      Given User is logged in with his/her credentials into the automationpractice site
      And on 'My Account' Page
      When User clicks on "Dresses"
      And Navigates to "Summer Dresses" Menu
      And Click on 'Add to Cart" button to add an item to his/her shopping cart
      Then A confirmation messages as "Product successfully added to your shopping cart"

    Scenario: 2. Validate the cart for selected product details
      Given User is on "CartSummary" Page with title "Order - My Store"
      When User validates the product name as "Printed Summer Dress"
      And cart quantity as "2"
      And color as "Yellow" of the product
      Then User is able to find the correct product details as selected.