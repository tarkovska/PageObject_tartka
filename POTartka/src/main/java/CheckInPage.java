/**
 * Created by Nataliya_Tarkovska on 4/18/2018.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckInPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='woocommerce-order']/p")
    private WebElement notification;

    public CheckInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNotification(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return notification.getText();
    }

}
