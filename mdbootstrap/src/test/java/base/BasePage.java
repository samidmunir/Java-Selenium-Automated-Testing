package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void jsExecClick(WebElement element) {
        jsExec.executeScript("arguments[0].click()", element);
    }

    protected void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            jsExec.executeScript("arguments[0].click();", element);
        }
    }

    protected void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    protected void hoverWithPause(WebElement element, long millis) {
        actions.moveToElement(element).pause(Duration.ofMillis(millis)).perform();
    }

    protected void scrollIntoView(WebElement element) {
        jsExec.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void safeScrollIntoView(WebElement element) {
        jsExec.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}