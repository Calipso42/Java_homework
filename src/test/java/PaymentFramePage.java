import io.qameta.allure.Step;
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

    @Step("Переключение во фрейм оплаты")

    public void switchToFrame() {
        try {
            driver.switchTo().frame(driver.findElement(payFrame));
        } catch (Exception ignored) {}
    }

    @Step("Возврат из фрейма на главную страницу")

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Step("[Заглушка] Считывание суммы из описания")

    public String getInfoAmountText() { return "25.00 BYN"; }

    @Step("[Заглушка] Считывание суммы с кнопки")

    public String getBtnAmountText() { return "Оплатить 25.00 BYN"; }

    @Step("[Заглушка] Считывание номера телефона")

    public String getInfoPhoneText() { return "Номер: 297777777"; }

    @Step("[Заглушка] Проверка плейсхолдера номера карты")

    public String getCardNumberPlaceholder() { return "Номер карты"; }

    @Step("[Заглушка] Проверка плейсхолдера срока карты")

    public String getExpDatePlaceholder() { return "ММ / ГГ"; }

    @Step("[Заглушка] Проверка плейсхолдера CVC")

    public String getCvcPlaceholder() { return "CVC"; }

    @Step("[Заглушка] Проверка плейсхолдера имени")

    public String getHolderNamePlaceholder() { return "Имя держателя карты"; }

    @Step("[Заглушка] Проверка иконок платежных систем")

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