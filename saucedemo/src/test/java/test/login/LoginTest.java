package test.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsernameInput("standard_user");
        loginPage.setPasswordInput("xyz123"); // incorrect password... error expected
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessageSubstring = "Epic sadface";

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessageSubstring));
    }
}