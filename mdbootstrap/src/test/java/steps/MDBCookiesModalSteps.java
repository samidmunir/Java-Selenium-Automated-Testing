package steps;

import io.cucumber.java.en.And;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MDBDropdownPage;

public class MDBCookiesModalSteps {
    private final MDBDropdownPage page = new MDBDropdownPage();

    @Given("the user is on the MDB multi-level dropdown page")
    public void theUserIsOnTheMDBMultiLevelDropdownPage() {
        page.openPage();
    }

    @Then("the cookie modal should be visible")
    public void theAcceptCookiesModalShouldBeVisible() {
        Assert.assertTrue(page.isAcceptCookiesModalVisible(), "Expected the accept cookies modal to be visible.");
    }

    @When("the user clicks the Accept Cookies button")
    public void theUserClicksTheAcceptCookiesButton() {
        page.clickAcceptCookiesButton();
    }

    @Then("the cookie modal should no longer be visible")
    public void theAcceptCookiesModalShouldNoLongerBeVisible() {
        Assert.assertTrue(page.isAcceptCookiesModalGone(), "Expected the accept cookies modal to disappear after clicking Accept Cookies.");
    }

    @When("the user opens the blue dropdown button")
    public void theUserOpensTheBlueDropdownButton() {
        page.openBlueDropdownButton();
    }

    @And("the user hovers over the Submenu option")
    public void theUserHoversOverTheSubmenuOption() {
        page.hoverOverSubmenu();
    }

    @Then("the nested submenu should be visible")
    public void theNestedSubmenuShouldBeVisible() {
        Assert.assertTrue(page.isSubmenuItem3Visible(), "Expected nested submenu to be visible after hovering over Submenu.");
    }

    @And("the user hovers over Submenu Item 3")
    public void theUserHoversOverSubmenuItem3() {
        page.hoverOverSubmenuItem3();
    }

    @Then("the Multi level 2 option should be visible")
    public void theMultiLevel2OptionShouldBeVisible() {
        Assert.assertTrue(page.isMultiLevel2Visible(), "Expected 'Multi level 2' to appear after hovering over Submenu Item 3.");
    }
}