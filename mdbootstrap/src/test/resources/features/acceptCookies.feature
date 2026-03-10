Feature: MDB cookie modal

    Scenario: User accepts the cookie modal on the MDB dropdown page
        Given the user is on the MDB multi-level dropdown page
        Then the cookie modal should be visible
        When the user clicks the Accept Cookies button
        Then the cookie modal should no longer be visible