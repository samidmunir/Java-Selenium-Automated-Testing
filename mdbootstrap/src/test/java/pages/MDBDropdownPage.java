package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import utils.ProcessConfig;

public class MDBDropdownPage extends BasePage {

    @FindBy(id = "accept_cookies_modal")
    private WebElement acceptCookiesModal;

    @FindBy(id = "accept_cookies_btn")
    private WebElement acceptCookiesButton;

    // @FindBy(xpath = "(//button[normalize-space()='Dropdown button'])[1]")
    // private WebElement blueDropdownButton;
    private final By blueDropdownButtonBy = By.xpath("(//button[normalize-space()='Dropdown button'])[1]");

    // @FindBy(xpath = "(//a[normalize-space()='Submenu'])[1]")
    @FindBy(xpath = "(//a[contains(normalize-space(),'Submenu') and not(contains(normalize-space(),'item'))])[1]")
    private WebElement submenuOption;

    @FindBy(xpath = "(//a[contains(normalize-space(), 'Submenu item 3')])[1]")
    private WebElement submenuItem3Option;

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

    /*
    public void openBlueDropdownButton() {
        System.out.println("\nScrolling to blue dropdown button....");
        scrollIntoView(blueDropdownButton);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("\nTrying regular click...");
            clickElement(blueDropdownButton);
            System.out.println("\nRegular click succeeded.");
        } catch (Exception e) {
            System.out.println("\nRegular click failed. Trying jsExec click...");
            jsExecClick(blueDropdownButton);
            System.out.println("JsExec click executed.");
        }
    }
    */

    public void openBlueDropdownButton() {
        // System.out.println("\nLocating blue dropdown button...");

        WebElement blueDropdownButton = driver.findElement(blueDropdownButtonBy);

        // System.out.println("\nAbout to scroll...");
        // scrollIntoView(blueDropdownButton);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // System.out.println("\nTrying jsExec click on blue dropdown button...");
        jsExecClick(blueDropdownButton);

        // System.out.println("\nJsExec click executed.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hoverOverSubmenu() {
        System.out.println("\nAbout to hover over Submenu...");
        hoverWithPause(submenuOption, 800);
        System.out.println("\nFinished hovering over Submenu");
    }

    public boolean isSubmenuItem3Visible() {
        return isElementDisplayed(submenuItem3Option);
    }
}