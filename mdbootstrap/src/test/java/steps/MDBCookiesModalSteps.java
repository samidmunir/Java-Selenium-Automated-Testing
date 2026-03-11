package steps;

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
}