package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObj {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public LoginPageObj(WebDriver driver) {
		this.driver = driver; 
	}
	
	By emailField = By.id("signInName");
	By passwordField = By.id("password");
	By signInBtn = By.id("next");

	
	public WebElement getEmailField() {
		wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		return driver.findElement(emailField);
	}
	
	public WebElement getPasswordField() {
		wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		return driver.findElement(passwordField);
	}
	
	public WebElement getSignInBtn() {
		wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		return driver.findElement(signInBtn);
	}
}
