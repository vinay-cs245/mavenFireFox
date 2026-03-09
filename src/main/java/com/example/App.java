package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class App {
    public static void main(String[] args) {
        FirefoxOptions options = new FirefoxOptions();
        
        // If you need to set the binary location manually (if Firefox is not in the default path)
        // options.setBinary("/usr/bin/firefox");
        
        options.addArguments("-private");  // Open Firefox in private browsing mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize WebDriver (FirefoxDriver)
        WebDriver driver = new FirefoxDriver(options);

        // WebDriverWait is now used with Duration directly in the constructor
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();  // Maximize the browser window

            // Open the first URL
            driver.get("https://www.firefox.com");

            // Open a new tab and switch to it
            driver.switchTo().newWindow(WindowType.TAB);

            // Open the second URL in the new tab
            driver.get("https://www.amazon.in");

            // Wait for the search box to be clickable and then enter text
            wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox"))).sendKeys("shirt");

            // Wait for the search button to be clickable and then click it
            wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();

        } finally {
            driver.quit();  // Quit the driver, closing the browser
        }
    }
}
