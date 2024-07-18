package testing_codes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_testing {
    /*
    Done-----------------------
        1) Simple login testing
        2) Data Driven testing
        3) Performance testing
     */

    private WebDriver driver;
    private String baseUrl = "file:///C:/xampp/htdocs/todoapp_testing/"; // Replace with your local server URL

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl + "index.html"); // Adjust URL as needed
    }

    @Test
    public void testLogin() {
        long start = System.currentTimeMillis();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        // Enter username and password
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("admin");

        // Click on login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Verification steps after login (e.g., check URL or dashboard content)
        String expectedUrl = baseUrl + "authentication.php"; // Adjust if dashboard URL differs
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, driver.getCurrentUrl());

        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Page Load Time: " + totalTime + " milliseconds");
    }

    @Test
    public void testLogin2() {
        long start = System.currentTimeMillis();
        driver.get(baseUrl + "index.html");
        // Explicitly wait for the username field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        // Enter username and password
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        // Click on login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Verification steps after login (e.g., check URL or dashboard content)
        String expectedUrl = baseUrl + "dashboard.html"; // Adjust if dashboard URL differs
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed. Index page not reached.");
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Page Load Time: " + totalTime + " milliseconds");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
