@menu
Feature:  Rastaurant menu items

  @details
  Scenario: See menu item details
    Given User is "CASA_DE_NOCA_PAGE" restaurant page with location set to "Olinda"
    When User clicks on menu item "<title>"
    Then The item title is "<title>"
    *    The item description is "<description>"
    *    The item price is "<price>"
    Examples:
      | title | description | price |
      | Refrigerante 1l  | guaraná ou coca-cola | R$10.00 |
      | Prato para 2 pessoas | Macaxeira, manteiga, queijo parmesão ralado, 2 fatias de carne de sol, 1 fatia de queijo coalho assado. | R$83.00 |
      | Prato para 4 pessoas | Macaxeira, manteiga, queijo parmesão ralado, 4 fatias de carne de sol, 2 fatias de queijo coalho assado. | R$123.00 |

  @cart
  Scenario: Add item to cart and validate total cost
    Given User is "CASA_DE_NOCA_PAGE" restaurant page with location set to "Olinda"
    And User schedules the delivery to "07:30 PM - 08:00 PM"
    When User clicks on menu item "Prato para 2 pessoas"
    And User increases quantity to 3
    And User clicks on add to cart button
    Then Item cart popover is displayed
    * The restaurant name is "Casa de Noca"
    * The total cost is "R$249.00"
    * There is 1 item in cart
    When User clicks on menu item "Prato para 4 pessoas"
    And User increases quantity to 2
    And User clicks on add to cart button
    Then Item cart popover is displayed
    * The restaurant name is "Casa de Noca"
    * The total cost is "R$495.00"
    * There are 2 items in cart

  @cartItems
  Scenario: Validate list of items in cart
    Given User is "CASA_DE_NOCA_PAGE" restaurant page with location set to "Olinda"
    And User schedules the delivery to "07:30 PM - 08:00 PM"
    When User clicks on menu item "Prato para 2 pessoas"
    And User increases quantity to 3
    And User clicks on add to cart button
    Then Item cart popover is displayed
    * The restaurant name is "Casa de Noca"
    * The total cost is "R$249.00"
    * There is 1 item in cart
    * The total quantity of items in cart is 3
    When User clicks on menu item "Prato para 4 pessoas"
    And User increases quantity to 2
    And User clicks on add to cart button
    Then Item cart popover is displayed
    * The total cost is "R$495.00"
    * There are 2 items in cart
    * The total quantity of items in cart is 5
    * Validate list of products in cart
      | 3Prato para 2 pessoasR$249.00 |
      | 2Prato para 4 pessoasR$246.00 |
