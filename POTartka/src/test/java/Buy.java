/**
 * Created by Nataliya_Tarkovska on 3/28/2018.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buy {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //  System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://tartka.com.ua/ru/");
    }

    @Test
    public void buy(){
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.search("сутаж");
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.clickElement();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickGoToCart();
        CartViewPage cartViewPage = new CartViewPage(driver);
        cartViewPage.clickOrder();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFieldName("Vasya");
        orderPage.fillFieldSurname("Ivanov");
        orderPage.fillFieldEmail("ivanov@gmail.com");
        orderPage.fillFieldPhone("0504545458");
        orderPage.clickTerms();
        orderPage.clickPlaceOrder();
        CheckInPage checkInPage = new CheckInPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(checkInPage.getNotification(), "Спасибо. Ваш заказ был принят.");
    }

}
