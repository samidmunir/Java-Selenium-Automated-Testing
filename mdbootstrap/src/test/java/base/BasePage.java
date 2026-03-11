package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExec;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        this.jsExec = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickElement(WebElement element) {
        waitForClickability(element).click();
    }

    protected void jsExecClick(WebElement element) {
        jsExec.executeScript("arguments[0].click();", element);
    }

    protected void hoverWithPause(WebElement element, long millis) {
        actions.moveToElement(waitForVisibility(element))
                .pause(Duration.ofMillis(millis))
                .perform();
    }

    protected void scrollIntoView(WebElement element) {
        jsExec.executeAsyncScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitForInvisibility(WebElement element) {
        try {
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            return false;
        }
    }

    protected String getElementText(WebElement element) {
        return waitForVisibility(element).getText().trim();
    }
}