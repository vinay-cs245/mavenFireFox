package com.example;

import org.openqa.selenium.By;
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

        // Open second website (AutomationExercise)
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://automationexercise.com/");
        Thread.sleep(5000);

        // Add products to cart on AutomationExercise
       // Add Product 4 to Cart
        driver.findElement(By.cssSelector("[data-product-id='4']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Add Product 5 to Cart
        driver.findElement(By.cssSelector("[data-product-id='5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Add Product 6 to Cart
        driver.findElement(By.cssSelector("[data-product-id='6']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Open Cart Page
        driver.get("https://automationexercise.com/view_cart");

        // Refresh Cart Page
        driver.navigate().refresh();

        // Open third website
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practicetestautomation.com/");
        Thread.sleep(5000);

        // Keep browser open
        Thread.sleep(10000);

        driver.quit();
    }
}
