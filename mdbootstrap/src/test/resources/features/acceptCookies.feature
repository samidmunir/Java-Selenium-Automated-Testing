Feature: MDB multi-level dropdown

    Scenario: User accepts cookies and then selects Multi level 2
        Given the user is on the MDB multi-level dropdown page
        Then the cookie modal should be visible
        When the user clicks the Accept Cookies button
        Then the cookie modal should no longer be visible
        When the user opens the blue dropdown button
        And the user hovers over the Submenu option
        Then the nested submenu should be visible