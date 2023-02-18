package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    WebDriver driver;
    /*
    this class will be storing the the utility methods that can used across the project.
     */
    public static void sleep(int second){
//this method will accept int and executed thread.sleep method for given second
        second*= 1000;
        try {

            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    public static void switchWindowAndVerify(String expectedInURL,String expectedInTitle){
// return and store all the window handels in set.
        Set<String> allWindowHandeles =  Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandeles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL " + Driver.getDriver().getCurrentUrl());
            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static  void verifyTitle (String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }
    /*
    This method accepts Webelement target, and waits for that WebElement to not be displayed
     */
    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //us the wait object with proper sytanx to creat explicit wait condition
        wait.until(ExpectedConditions.invisibilityOf(target));
    }
    /*
    This method accepts title contain, givin String
     */
    public static void waitForTitleContaons(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //us the wait object with proper sytanx to creat explicit wait condition
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and return a list<String> that contains all options values as String.
     * @param dropdownELements
     * @return
     */

    public static List<String> dropdownOptions_as_STRING(WebElement dropdownELements){


        Select month = new Select(dropdownELements);
        //Stroing all the options into a list of webElements
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating and EMPTY list of string to store SCTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();
        //looping through the List<WebElement>, getting all options text, and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {

            actualMonth_as_STRING.add(each.getText());

        }


return actualMonth_as_STRING;
    }



}
