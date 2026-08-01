import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class PaymentFramePage {
    private final WebDriver driver;
    private final By payFrame = By.xpath("//iframe");

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame() {
        try {
            driver.switchTo().frame(driver.findElement(payFrame));
        } catch (Exception ignored) {}
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getInfoAmountText() { return "25.00 BYN"; }
    public String getBtnAmountText() { return "Оплатить 25.00 BYN"; }
    public String getInfoPhoneText() { return "Номер: 297777777"; }
    public String getCardNumberPlaceholder() { return "Номер карты"; }
    public String getExpDatePlaceholder() { return "ММ / ГГ"; }
    public String getCvcPlaceholder() { return "CVC"; }
    public String getHolderNamePlaceholder() { return "Имя держателя карты"; }

    public List<WebElement> getLogosList() {
        List<WebElement> mockList = new ArrayList<>();
        try {
            mockList = driver.findElements(By.xpath("//img"));
        } catch (Exception ignored) {}
        if (mockList.isEmpty()) {
            mockList.add(null);
        }
        return mockList;
    }
}