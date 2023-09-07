import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class ElentaFormTests {
    public static WebDriver driver;

    @Test
    public void createAdPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception ignored) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdNoTitleTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite skelbimo pavadinimą");
    }

    @Test
    public void createAdTitle2CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Ab");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Pavadinime įveskite bent 3 simbolius");
    }

    @Test
    public void createAdTitle3CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abc");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdTitle50CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghvijklmnopqrstuvwxyzabcdefghijklmnopqrstuvw");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdTitle51CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try{
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e){}
        Assert.assertEquals(txt, "Pavadinimo ilgis viršyja 50 simbolių");
    }

    @Test
    public void createAdTitleNumbersTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("0123456789");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdTitleSymbolsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("`~!@#$%^&*()_-+=[]{}|;:',./<>?");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Pavadinime yra neleistini symboliai");
    }

    @Test
    public void createAdNoDescriptionTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("txte")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite skelbimo aprašymą");
    }

    @Test
    public void createAdDescription4CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcd");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("txte")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Skelbimo aprašyme įveskite bent 5 simbolius");
    }

    @Test
    public void createAdDescription5CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcde");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdDescription200CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdDescription201CharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrs");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("txte")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Skelbimo aprašymas viršyja 200 simbolių");
    }

    @Test
    public void createAdDescriptionNumbersTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("0123456789");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdDescriptionSymbolsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("`~!@#$%^&*()_-+=[]{}|;:',./<>?");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdNoPriceTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite kainą");
    }

    @Test
    public void createAdPrice1NumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdPrice10NumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdPrice11NumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("12345678901");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Kaina viršyja 10 simbolių");
    }

    @Test
    public void createAdPriceCharsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("Abcdefghij");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Neleistini simboliai");
    }

    @Test
    public void createAdPriceSymbolsTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("`~!@#$%^&*");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Neleistini simboliai");
    }

    @Test
    public void createAdNoLocationTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdFakeLocationTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Abcdefg");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("le")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Nurodytas neteisingas miestas/rajonas");
    }

    @Test
    public void createAdNumbersLocationTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("0123456789");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("le")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Neleistini simboliai");
    }

    @Test
    public void createAdSymbolsLocationTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("`~!@#$%^&*");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("le")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Neleistini simboliai");
    }

    @Test
    public void createAdNoPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("ce")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite telefono numerį");
    }

    @Test
    public void createAdLettersPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("Abcefghijklm");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAdSymbolsPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("`~!@#$%^&*");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAd10NumbersPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+3701245678");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAd12NumbersPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+370124567890");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("pe")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAdNoEMailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.xpath("//*[@id=\"fileinput-label\"]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "įkelkite nuotraukas");
    }

    @Test
    public void createAdOnlyLettersEMailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenispavardenis");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("ee")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdOnlyNumbersEMailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("0123456789");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("ee")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdOnlySymbolsEMailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("`~!@#$%^&*");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("ee")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdNoDomainEMailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("text")).sendKeys("Abcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("price")).sendKeys("1234567890");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+37012456789");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis0123456789@");
        driver.findElement(By.id("submit-button")).click();
        String txt = null;
        try {
            txt = driver.findElement(By.id("ee")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @BeforeClass
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    public void acceptCookies() {
        driver.get("https://elenta.lt/");
        driver.findElement(By.className("fc-button-label")).click();
    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
