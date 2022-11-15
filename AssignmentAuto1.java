//comparing two prices

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AssignmentAuto1 {
    public static void main(String[] args) throws InterruptedException {
        //create a string for product
        String product = "Apple iPhone 14 128GB Blue";
        System.setProperty("webdriver.chrome.driver", "/Users/lhamusherpa/Documents/AUTOMATION/chromedriver");
        WebDriver driver = new ChromeDriver(); //create a webdriver object
        driver.get("https://amazon.in");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //waiting for page to load
// write on search box
        WebElement insert = driver.findElement(By.id("twotabsearchtextbox"));
        insert.sendKeys(product);
        insert.submit();

        //click on the correct link

        String price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]")).getText();
        price = price.replace(",","");
        double priceAmazon = Double.parseDouble(price);
        System.out.println("Price on Amazon is: "+priceAmazon);

   //second website
        driver.get("https://flipkart.com");
        Actions a = new Actions(driver);
        WebElement exit = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        a.doubleClick(exit).perform();

//search the same
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(product);
        search.submit();
        
        String price2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div")).getText();
        System.out.println("Price on Flipkart is: "+price2);
        price2 = price2.replace(",","");
        double priceFlipkart = Double.parseDouble(price2);

       try{ if(priceAmazon==priceFlipkart){
            System.out.println("Prices are equal.");
        } else {
           double difference;
           if (priceAmazon > priceFlipkart) {
               difference = priceAmazon - priceFlipkart;
               System.out.println("Price is higher on amazon by: "+difference);
           } else {
               difference = priceFlipkart - priceAmazon;
               System.out.println("Price is higher on flipkart by: "+difference);
           }
       }
       } catch (Exception ex){
           System.out.println("Error detected. Please try again.");
       }

    }
        

    }


