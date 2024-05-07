import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.BaseTestAppium;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class DirectActivityRotateCopyPasteKeyEnterTest extends BaseTestAppium {


    @Test
    public void Miscellanous() throws MalformedURLException, URISyntaxException {
        appiumServiceStart();
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");

        //adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
        // adb shell dumpsys window | find "mCurrentFocus"  - Windows
        //App Package & App Activity


        //((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
        //        "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        //copy paste
        //copy to clipboard- paste it clipboard

        driver.setClipboardText("Rahul Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));


    }

}
