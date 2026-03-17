package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusablecode.ReadExcel;

import java.io.IOException;

public class AmazonHomePage {

    WebDriver driver;

    public void enterProductName(String productName){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
    }

    public void enterProductName(String sheetName, int rowIndex, int columnIndex) throws IOException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ReadExcel.getData(sheetName,rowIndex,columnIndex));
    }

    public void clickSearchIcon(){
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void selectValueFromCategoryDropdown(){

    }

    public void clickYourList(){

    }
}
