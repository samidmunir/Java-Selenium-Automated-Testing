package com.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("#login_button_container h3");

    public void setUsernameInput(String username) {
        set(usernameInput, username);
    }

    public void setPasswordInput(String password) {
        set(passwordInput, password);
    }

    /*
        Transition method
        - login page -> products page...
    */
    public ProductsPage clickLoginButton() {
        click(loginButton);

        return new ProductsPage();
    }

    /*
        Convinience method
    */
    public ProductsPage logIntoApplication(String username, String password) {
        setUsernameInput(username);
        setPasswordInput(password);

        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}