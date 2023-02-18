package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //creat private constructor to remove access to this object

    private Driver(){}


    /*
    We make the Webdriver private, because we want to close access from outside the class We are making static, because we will use it in a static method

     */
    private static WebDriver driver;// default value = null

    /*
    Create resubale utility method which will return the same driver instance onece we call it.
    If an instance does not exits , it will creat first, and then it will always retuen same instance
     */
    public static WebDriver getDriver(){

        if(driver == null){

                /*
                We will read our broswerType from configurration.properties file.
                This way , we canotrol which broswer is open from outside our code

                 */
            String browserType = ConfigurationReader.getProperty("browser");

                /*
                Depending on the browserType returned from the configuration.properties
                switch statement will determine the "case" , and open the matching browser
                 */
            switch(browserType){
                case"chrome":
                  //  WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                //    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


            }
        }
        return driver;
    }


/*
creat a new Driver.closeDriver(); it will use quit() method to quit browser
 */

    public static void closeDriver(){
        if(driver !=null){
            /*
            this line terminate the currently existing driver completley. It will not exist going forward
             */
            driver.quit();
            /*
            We assign the value back to "null" so that my "singleton" can creat a newer one if needed.
             */
            driver = null;
        }
    }

}


