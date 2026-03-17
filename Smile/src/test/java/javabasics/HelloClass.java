package javabasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloClass {

    public static void main(String[] args) throws InterruptedException {

        //dvi[@class="nav-fill"]/child::div

        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=in");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Vignesh");
        driver.findElement(By.id("password")).sendKeys("Welcome@123");
        driver.findElement(By.id("Login")).click();
        String errorMessage = driver.findElement(By.id("error")).getText();
        System.out.println(errorMessage);

    }
}
