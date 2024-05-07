import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.example.BaseTestAppium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SwipeDemoTest extends BaseTestAppium {


    @Test
    public void SwipeTest() throws MalformedURLException, URISyntaxException {
        appiumServiceStart();

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");



        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)firstImage).getId(),
                "direction", "left",
                "percent", 0.1));

        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
    }
}
