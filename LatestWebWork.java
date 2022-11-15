//every
//alert box will not have inspect so we have to access a different way

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class LatestWebWork {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/lhamusherpa/Documents/AUTOMATION/chromedriver");
        WebDriver driver = new ChromeDriver(); //create a webdriver object
        driver.get("https://webdriveruniversity.com/");

        driver.findElement(By.cssSelector("#contact-us > div > div.section-title > h1")).click();   //to open contact us in new tab
        ArrayList<String> tabs;
        //next we have to switch tabs so introduce an array for tabs and switch to the new one
        tabs = new ArrayList<>(driver.getWindowHandles()); //we put the tab names in a string array
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        driver.manage().window().maximize();
        //we'll use implicit wait so the program doesn't execute before the website finishes loading
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement firstName = driver.findElement((By.name("first_name")));
        firstName.sendKeys("Alert");

        WebElement lastName = driver.findElement((By.name("last_name")));
        lastName.sendKeys("Box");

        WebElement email = driver.findElement((By.name("email")));
        email.sendKeys("alert.box"); //incorrect email format, will show invalid email

        WebElement comment = driver.findElement((By.name("message")));
        comment.sendKeys("Alert me!");

        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/form/div/input[2]"));
        submit.click();

        Thread.sleep(2000);
       // this is to close the tab: driver.close();
        // this is to close all tabs driver.quit();

        driver.navigate().back(); //use navigate to go back or forward

        //correct email value for successful entry
        email.sendKeys("alert.me@gmail.com");
        submit.click();
       // Thread.sleep(2000);
        driver.navigate().back();
        //Thread.sleep(3000);

        // refresh for a new entry
        driver.navigate().refresh();
        driver.close();
        driver.switchTo().window(tabs.get(0));

        tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
      //  Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");

       /* to scroll down until it finds upload a file
        WebElement upload = driver.findElement(By.linkText("FILE UPLOAD"));
        js.executeScript("arguments[0].scrollIntoView();", upload);*/
        Thread.sleep(5000);
        // to upload a file
        driver.findElement(By.xpath("//*[@id=\"file-upload\"]/div/div[1]/h1")).click();
        //need new tab array to access the new tab
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement myFile = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
        myFile.click();

    }
}
