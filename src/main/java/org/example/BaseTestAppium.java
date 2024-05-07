package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTestAppium {

    public AndroidDriver driver;
    public AppiumDriverLocalService appiumService;

    public void appiumServiceStart() throws URISyntaxException, MalformedURLException {


        //Locators -> Xpath, id, accessibility id, className, AndroidUIAutomator


        appiumService= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//passion//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //appiumService.start();

        //Android driver
        //appium code -> appium Server ->mobile
        UiAutomator2Options options = new UiAutomator2Options();

        //options.setDeviceName("vijayPhone");
        options.setDeviceName("Android Device");
        //options.setApp("D://Appium//src//test//java//resources//ApiDemos-debug.apk");
        //options.setApp("D://Appium//src//test//java//resources//qa1_26.04.2024_2.0.41.apk");
        options.setApp("D://Appium//src//test//java//resources//General-Store.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }


    public void tearDown(){
        driver.quit();
        appiumService.stop();

    }
}
