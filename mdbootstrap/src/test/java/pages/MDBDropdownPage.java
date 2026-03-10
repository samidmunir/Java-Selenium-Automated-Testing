package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import utils.ProcessConfig;

public class MDBDropdownPage extends BasePage {

    @FindBy(id = "accept_cookies_modal")
    private WebElement acceptCookiesModal;

    @FindBy(id = "accept_cookies_btn")
    private WebElement acceptCookiesButton;

    public void openPage() {
        driver.get(ProcessConfig.getProperty("base_url"));
    }

    public boolean isAcceptCookiesModalVisible() {
        return isElementDisplayed(acceptCookiesModal);
    }

    public void clickAcceptCookiesButton() {
        try {
            clickElement(acceptCookiesButton);
        } catch (Exception e) {
            jsExecClick(acceptCookiesButton);
        }
    }

    public boolean isAcceptCookiesModalGone() {
        return waitForInvisibility(acceptCookiesModal);
    }
}