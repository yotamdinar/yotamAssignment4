Feature: Admin deletes an item from the store, and a user buys the item

    Scenario: User deletes an item from the store
        Given User is in login page for admins
        When User is logged in with "<Email>" and "<Password>"
        And User deletes a "<Product>" from the store 
        Then Product is deleted from the store

    Scenario: User attempts to buy the deleted Product
        Given User is logged in
        When User is logged in with "user" and "123"
        And User attempt to buy the deleted "<Product>"
        Then User not able to complete the buy

        Examples:
        | Email           | Password  | Product |
        | admin    | 1234  | iMac    |
