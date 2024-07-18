package testing_codes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import java.util.concurrent.TimeUnit;

public class update_test2 {

    public static void test(WebDriver driver){
        long startTime = System.currentTimeMillis();

        // Open the web page
        driver.get("file:///C:/xampp/htdocs/todoapp_testing/dashboard.html") ;
        // Perform actions
        try {
            // Add a task
            WebElement inputBox = driver.findElement(By.id("input-box"));
            inputBox.sendKeys("Sample Task");

            WebElement dueDate = driver.findElement(By.id("due-date"));
            dueDate.sendKeys("2024-07-20"); // Example due date (format: YYYY-MM-DD)

            WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add Task')]"));
            addButton.click();

            // Wait for the task to be added (adjust sleep time as needed)
            Thread.sleep(1000);

            // Check if task was added successfully
            WebElement addedTask = driver.findElement(By.xpath("//li[contains(text(),'Sample Task')]"));
            if (addedTask.isDisplayed()) {
                System.out.println("Task added successfully.");
                System.out.println("Task Added to Database");
            } else {
                System.out.println("Failed to add task.");
            }

            // Remove a task
            WebElement removeButton = driver.findElement(By.xpath("//li[contains(text(),'Sample Task')]//button[contains(text(),'remove')]"));
            removeButton.click();

            // Wait for the task to be removed (adjust sleep time as needed)
            Thread.sleep(1000);

            // Check if task was removed successfully
            boolean taskRemoved = driver.findElements(By.xpath("//li[contains(text(),'Sample Task')]")).isEmpty();
            if (taskRemoved) {
                System.out.println("Task removed successfully.");
                System.out.println("Task removed from Database");
            } else {
                System.out.println("Failed to remove task.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // End measuring time
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " milliseconds");
        if(totalTime<1000){
            System.out.println("Performance Status: Good");
        }
        else if(totalTime<3000){
            System.out.println("Performance Status: Normal");
        }
        else{
            System.out.println("Performance Status: Poor");
        }

        // Close the browser
        driver.quit();
    }

    public static void main(String[] args) {
        // Set ChromeDriver path
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Chrome browser testing
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize browser window

        // Initialize WebDriver
        WebDriver cdriver = new ChromeDriver(options);
        System.out.println("--------------Chrome Browser Testing Result------------");
        test(cdriver);

        // Edge Browser testing
        EdgeOptions options2 = new EdgeOptions();

        // Initialize WebDriver
        WebDriver edriver = new EdgeDriver(options2);
        System.out.println("--------------Edge Browser Testing Result------------");
        test(edriver);

        // Firefox Browser testing
        FirefoxOptions options3 = new FirefoxOptions();

        // Initialize WebDriver
        WebDriver fdriver = new FirefoxDriver(options3);
        System.out.println("--------------FireFox browser Testing Result------------");
        test(fdriver);

    }
}
