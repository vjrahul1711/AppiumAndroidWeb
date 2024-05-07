import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.example.BaseTestAppium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LongPressTest extends BaseTestAppium {
    @Test
    public void AppiumTest01() throws URISyntaxException, MalformedURLException {




        appiumServiceStart();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.
                xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("vijay wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //appiumService.stop();

    }

    @Test
    public void LongPressGuesture() throws MalformedURLException, URISyntaxException {
        appiumServiceStart();
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele=	driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }
}