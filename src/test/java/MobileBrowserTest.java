import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.BrowserMobBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MobileBrowserTest extends BrowserMobBaseTest {

    @Test
    public void browserTest() throws MalformedURLException, URISyntaxException, InterruptedException {
        appiumServiceStart();

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(6000);
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));


    }
}
