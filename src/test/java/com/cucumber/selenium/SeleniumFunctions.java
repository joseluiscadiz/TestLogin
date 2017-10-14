package com.cucumber.selenium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFunctions {

public static WebDriver driver = null;
public static WebDriverWait waitVar = null;

public static String baseURL = "https://TestPRUEBA.com/";

public void createDriver() throws MalformedURLException,
InterruptedException {

driver = new FirefoxDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

driver.get(baseURL);

waitVar = new WebDriverWait(driver, 15);
}

public void teardown() {
driver.quit();
}

public void ishomepageDisplayed() {
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.linkText("Sign in")));

driver.findElement(By.linkText("Sign in")).isDisplayed();
driver.findElement(By.className("marketing-section-signup"))
.isDisplayed();
}

public void insert_user_and_password(String user,String password) {
	driver.findElement(By.id("log")).sendKeys(user); 
    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("login")).click();

}

public void clickSigninLink() {
driver.findElement(By.linkText("Sign in")).click();
}
			
public void clickLogoutinLink() {
driver.findElement(By.linkText("LogOut")).click();
}

public void isloginsectionDisplayed() {
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.className("auth-form-body")));
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.name("commit")));
}

public void isloginsectionDisplayedError() {
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.className("auth-form-body")));
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.name("Error")));
}

public void islogoutsectionDisplayed() {
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.className("auth-form-body")));
waitVar.until(ExpectedConditions.presenceOfElementLocated(By
.name("commit logout")));
}


}