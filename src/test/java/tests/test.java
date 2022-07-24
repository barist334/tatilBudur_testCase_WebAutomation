package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class test {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\baris\\IdeaProjects\\tatilBudur_testCase\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.tatilbudur.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().

        //Step 1: Antalya kelimesi arama kısmına girilir.
        driver.findElement(By.id("key")).click();
        driver.findElement(By.xpath("//input[@id='key']")).sendKeys("Antalya");
        //driver.findElement(By.xpath("//a[@id='ui-id-3']")).click();

        //Step 2: Başlangıç tarihi 1 Ağustos seçilir.
        driver.findElement(By.xpath("//input[(@placeholder='Giriş Tarihi') and @id=\"hotelSearchCheckIn\"]")).click();
        driver.findElement(By.xpath("//th[contains(text(),'Temmuz 2022')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Ağu')]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();

        //Step 3: Bitiş Tarihi 8 Ağustos seçilir.
        driver.findElement(By.xpath("//input[@name='checkOutDate' and @placeholder='Çıkış Tarihi']")).click();
        driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).click();

        //Step 4: Kişi alanında 2 yetişkin seçilir.
        // Otomatik olarak 2 yetişkin seçildiği için kod eklemedim.

        //Step 5: Arama tuşuna basılır.
        driver.findElement(By.xpath("//button[@id='searchFormHotelSubmitBtn']")).click();
        Thread.sleep(3000);

        //Step 6: Sonuçlarda en üstte gelen otel seçilir ve detay sayfasına geçilir.
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Oteli İncele")).click();
        Thread.sleep(3000);


        //Step 7: Detay sayfasında en üstteki oda seçilir ve ödeme sayfasına geçilir.
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='roomSelectBtn1']")).click();

        //Step 8: "Ulaşım İster Misiniz?" alanında İstiyorum seçeneği işaretlenir.
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//label[@for='transportationYes']")).click();

        // Step 9: Kalkış havalimanına Sabiha Gokcen yazılır.
        driver.findElement(By.id("txtFromLocationReservation")).click();
        driver.findElement(By.id("txtFromLocationReservation")).sendKeys("Sabiha");
        Thread.sleep(4000);
        driver.findElement(By.id("ui-id-1")).click();

        //driver.findElement(By.xpath("//*[@id=\"ui-id-103\"]")).click();

        // Step 10: Varış havalimanına Sabiha Gokcen yazılır.
        driver.findElement(By.id("txtFromLocationReservation")).click();
        driver.findElement(By.id("txtFromLocationReservation")).sendKeys("Sabiha");
        Thread.sleep(4000);
        driver.findElement(By.id("ui-id-2")).click();

        //driver.findElement(By.xpath("//*[@id=\"txtToLocationReservation\"]")).sendKeys("Sabiha Gokcen");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"ui-id-104\"]")).click();

        // Step 11: Ara butonuna basılır ve uçaklar listelenir.
        driver.findElement(By.xpath("//*[@id=\"personInfo\"]/section[4]/div[3]/div/button")).click();

        /*

        WebElement assertElement = driver.findElement(By.xpath("//label[@for='transportationYes']"));
        String assertText = assertElement.getText();

        System.out.println(assertText);
        Assert.assertEquals(assertText,"Bu benim text assertim.");

        Assert.assertTrue(assertElement.isDisplayed());
        */

    }
}
