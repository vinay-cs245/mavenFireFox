package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WindowType;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Open first website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);

        // Open second website
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://automationexercise.com/");
        Thread.sleep(5000);

        // Open third website
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practicetestautomation.com/");
        Thread.sleep(5000);

        // Keep browser open for 10 seconds
        Thread.sleep(10000);

        driver.quit();
    }
}
