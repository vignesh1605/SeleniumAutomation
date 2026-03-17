package reusablecode;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserLaunch {

    public static WebDriver driver;
    public static void launchUrl() throws IOException, InterruptedException {

        File file = new File("src/main/resources/configproperties/config.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String browser = prop.getProperty("browser");

        switch (browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("url"));
                Thread.sleep(3000);
                break;
            case "firefox" : driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("url"));
                Thread.sleep(5000);
                break;
            case "edge" : driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("url"));
                Thread.sleep(5000);
                break;
            default: throw new InvalidArgumentException("Enter the valid browser name");

        }

//        if (browser.equalsIgnoreCase("chrome"))
//        {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get(prop.getProperty("url"));
//            Thread.sleep(5000);
//        }
//
//        else if (browser.equalsIgnoreCase("firefox"))
//        {
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//            driver.get(prop.getProperty("url"));
//            Thread.sleep(5000);
//        }
//
//        else if (browser.equalsIgnoreCase("edge")){
//            driver = new EdgeDriver();
//            driver.manage().window().maximize();
//            driver.get(prop.getProperty("url"));
//            Thread.sleep(5000);
//        }
//
//        else {
//
//            throw new InvalidArgumentException("Enter the valid browser name");
//        }


    }
    public static void closeBrowser(){
        driver.quit();
    }
}
