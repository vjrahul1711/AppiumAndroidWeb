import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.example.BaseTestAppium;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ScrollDemoTest extends BaseTestAppium {


    @Test
    public void ScrollTestByUIAutomator() throws MalformedURLException, URISyntaxException {
        appiumServiceStart();
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

    }



    @Test
    public void ScrollTestByJS() throws MalformedURLException, URISyntaxException {

        appiumServiceStart();

        boolean canScrollMore;
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 5.0));
        } while (canScrollMore);
    }
}
