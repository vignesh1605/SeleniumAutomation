package stepdefination;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import reusablecode.BrowserLaunch;
import reusablecode.ReadExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmazonSteps extends BrowserLaunch {
    String name;
    WebElement searchDropdown;
    WebElement table;
    int tableSize;

//    @Given("user navigates to Amazon Homepage")
//    public void userNavigatesToAmazonHomepage() throws InterruptedException {
//        driver=new ChromeDriver();
//        driver.get("https://www.amazon.in/");
//        driver.manage().window().maximize();
//        Thread.sleep(5000);
//    }

    @When("user enters the product name {string} in search box")
    public void userEntersTheProductNameInSearchBox(String productName) {
        name=productName;
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);

    }

    @And("user clicks the search icon")
    public void userClicksTheSearchIcon() {

        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Then("user Validates the title of search result page")
    public void userValidatesTheTitleOfSearchResultPage() {

        String expectedTitle = "Amazon.in : "+name;
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
//        if (actualTitle.equals(expectedTitle)){
//            Assert.assertTrue(true);
//            System.out.println("The Expected page has been validated");
//        }
//        else {
//            Assert.assertTrue(false);
//            System.out.println("The Expected page has not been validated");
//        }

    }

    @When("user click the baby wishlist")
    public void userClickTheBabyWishlist()  {
        WebElement babyWishList = driver.findElement(By.xpath("//div[@id='nav-link-accountList']/child::button"));
        Actions clickAndHold = new Actions(driver);
        clickAndHold.clickAndHold(babyWishList).build().perform();
        driver.findElement(By.xpath("//div[@id=\"nav-al-wishlist\"]/ul/li[3]/a/span")).click();

    }

    @Given("user navigates to drag and drop page")
    public void userNavigatesToDragAndDropPage() throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

    }

    @When("user drag and drop the element")
    public void userDragAndDropTheElement() {

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(dragElement,dropElement).build().perform();
        driver.switchTo().defaultContent();
    }

    @When("user select the dropdown value")
    public void userSelectTheDropdownValue()  {

        searchDropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select s = new Select(searchDropdown);
        s.selectByIndex(2);
        s.selectByValue("search-alias=fashion");
    }

    @And("user read the selective option dropdown")
    public void userReadTheSelectiveOption() {

        List <WebElement> dropdownElements= searchDropdown.findElements(By.tagName("option"));
        List <String> values = new ArrayList<>();
        for (WebElement option : dropdownElements) {
            values.add(option.getText());
        }
        System.out.println(values);
        boolean flag = false;
        int count = 0;
        for (String text : values) {
            if (text.equalsIgnoreCase("Amazon Pharmacy")){
                flag = true;
                count++;
            }
            if (count == 1){

            }
        }System.out.println(flag);
        System.out.println(count);

//        int size = searchDropdown.findElements(By.tagName("option")).size();
//        Select s = new Select(searchDropdown);
//
//        for (int i=0; i<size; i++){
//           String dropdownValus = searchDropdown.findElements(By.tagName("option")).get(i).getText();
//           System.out.println(i +" index value is : "+dropdownValus);
//        }

    }

    @When("user selecting the table")
    public void userSelectingTheTable() {
            table = driver.findElement(By.xpath("//table[@class='wikitable']"));
            tableSize = table.findElements(By.tagName("tr")).size();
            System.out.println(tableSize);
    }

    @And("user extracting the table data")
    public void userExtractingTheTableData() {

        for(int i=0; i<tableSize;i++){
            String a = driver.findElements(By.xpath("//table[@class='wikitable']//td")).get(i).getText();
            System.out.println(i +" index value is : "+a);
//            String thValue = table.findElements(By.tagName("th")).get(i).getText();
//            System.out.println(thValue);
//            String tdValue = table.findElements(By.tagName("td")).get(i).getText();
//            System.out.println(tdValue);
        }

    }

    @When("user enters the username {string} and password {string}")
    public void userEntersTheUsernameAndPassword(String username, String password) throws IOException {
//        driver.findElement(By.id("username")).sendKeys(ReadExcel.getData("login",0,0));
//        driver.findElement(By.id("password")).sendKeys(ReadExcel.getData("login",1,0));
        driver.findElement(By.cssSelector("[id=username]")).sendKeys(ReadExcel.getData("login",0,0));
        driver.findElement(By.cssSelector("[id=password]")).sendKeys(ReadExcel.getData("login",1,0));

    }

    @And("user click the login button")
    public void userClickTheLoginButton() throws InterruptedException {
        driver.findElement(By.id("Login")).click();
        Thread.sleep(3000);

    }

    @Then("user validating the error message")
    public void userValidatingTheErrorMessage() {
        String expectedErrorMessage = "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actuslErrorMessage = driver.findElement(By.id("error")).getText();
        Assert.assertEquals(expectedErrorMessage,actuslErrorMessage);

    }
}
