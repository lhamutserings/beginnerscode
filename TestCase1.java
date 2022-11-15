
//test case1: check login using blank username and password + submit

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/lhamusherpa/Documents/AUTOMATION/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Step1: Open the link
        driver.get("https://webdriveruniversity.com/");
        //maximize screen
        driver.manage().window().maximize();

        //Step2: Access login portal
        driver.findElement(By.cssSelector("#login-portal > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1)")).click();

        //Step3: switch tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Step 4: blank username and password

        driver.findElement(By.id("text")).sendKeys("");

        driver.findElement(By.id("password")).sendKeys("");

        // Step 5: click login
        driver.findElement(By.cssSelector("#login-button")).click();

        String message = driver.switchTo().alert().getText();
        if (message.equals("validation failed"))
        { System.out.println("test was successful");
        } else{
            System.out.println("test failed");
        }
    }
}