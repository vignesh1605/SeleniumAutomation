package pageobjects;

import org.openqa.selenium.By;
import reusablecode.BrowserLaunch;

public class SearchResultPage extends BrowserLaunch {


    public void selectProductFromSearchResult(int resultIndex){

        driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-"+resultIndex+"']")).click();
    }

    public void getSearchPageTitle(){
        driver.getTitle();
    }
}
