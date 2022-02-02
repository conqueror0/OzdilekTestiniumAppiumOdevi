import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {
    FluentWait<WebDriver> wait;
    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("Sayfayi kaydir <x> <y> <endX> <endY> <duration>")
    public void swipe(int startX, int startY, int endX, int endY, int msDuration) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(msDuration)))
                .moveTo(PointOption.point(endX, endY))
                .release();

        touchAction.perform();
        logger.info("sayfa kaydirma basarili");
    }


    @Step("<time> saniye kadar bekle")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
        logger.info(time + " saniye bekleme başarili");
    }

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        logger.info("tiklama basarili");

    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickByWithXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        logger.info("xpath li elemente tiklama basarili");
    }

    @Step("id <id> li ementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info("elemete text girisi basarili");
    }

    @Step("Android klavyeyi kapat")
    public void closeKeyboardonAndroid() {
        appiumDriver.hideKeyboard();
        logger.info("klavyeyi kapatma basarili");

    }

    @Step("Sayfayı sola kaydır")
    public void swipeLeft() {
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();

        logger.info("sayfayi sola kaydirma basarili");

    }


    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlWId(String id, String text) {
        Assert.assertTrue("Element text değerini içermiyor",
                appiumDriver.findElement(By.id(id)).getText().contains(text));
        logger.info("idli element kontrolu dogrulandi");
    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlWithXpath(String xpath, String text) {
        Assert.assertTrue("Element text değerini içermiyor",
                appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        logger.info("xpath li elemnt kontrolu dogrulandı");

    }

    @Step("Android klavyeden arama tuşuna bas")
    public void clickSearchbuttonOnadnroidKeyboard() {
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        logger.info("klavyeden arama tusuna basma basarili");
    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("rastgele urun secimi basarili");
    }

    @Step("Listeye indexe gore tiklama <dizi>")
    public void listedenIndexeGoreTıkla(String xpath) {
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        products.get(1).click();
        logger.info("dizide indexe gore tiklama basarili");
    }


}
