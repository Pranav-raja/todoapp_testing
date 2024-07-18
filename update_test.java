package testing_codes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class update_test {

    public static void main(String[] args) {
        // Set the path to your WebDriver executable
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the web page
        driver.get("file:///U:/sem 7/software testing lab/TO-DO-main/index.html");

        // Add your test steps here
        try {
            Thread.sleep(2000); // Wait for 2 seconds for the page to load
            testAddTask(driver, "2024-07-06", "Complete Selenium test");
            testAddTask(driver, "2024-07-10", "Adding simple task");
            testAddTask(driver, "2024-07-10", "Adding another simple task");
            testAddTask(driver, "2024-08-10", "Dummy task");
            testRemoveTask(driver);
            testRemoveTask(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print test results and keep the browser open
        System.out.println("Tests completed. Keeping the browser open for inspection.");
    }

    public static void testAddTask(WebDriver driver, String date, String task) {
        // Find input elements and interact with them
        WebElement inputBox = driver.findElement(By.id("input-box"));
        WebElement dueDateInput = driver.findElement(By.id("due-date"));
        try{
            Thread.sleep(1000);
            WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
            inputBox.sendKeys(task);
            dueDateInput.sendKeys(date);

            // Click add button
            addButton.click();
        }
        catch(Exception e){}


        // Enter task details


        // Add assertions or checks to verify task addition
        // Example: Check if the task is added to the correct day's list
        WebElement mondayTasks = driver.findElement(By.id("friday-tasks"));
        try{
            Thread.sleep(1000);
            String taskText = mondayTasks.getText();
            if (taskText.contains("Complete Selenium test")) {
                System.out.println("Task addition test passed.");
            } else {
                System.out.println("Task addition test failed.");
            }
        }
        catch(Exception e){}

    }

    public static void testRemoveTask(WebDriver driver) {
        // Find and interact with the remove task button (span with &#x2716;)
        WebElement removeButton = driver.findElement(By.xpath("//span[contains(text(),'✖')]"));
        removeButton.click();

        // Add assertions or checks to verify task removal
        // Example: Check if the task is removed from the list
        WebElement mondayTasks = driver.findElement(By.id("monday-tasks"));
        String taskText = mondayTasks.getText();
        if (!taskText.contains("Complete Selenium test")) {
            System.out.println("Task removal test passed.");
        } else {
            System.out.println("Task removal test failed.");
        }
    }
}
