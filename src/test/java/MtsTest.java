import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class MtsTest {


    @Test
    public void checkMtsFormAndPayment() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://mts.by");

        mainPage page = new mainPage(driver);
        PaymentFramePage paymentFrame = new PaymentFramePage(driver);

        try {
            driver.findElement(By.xpath("//button[contains(text(), 'Принять')]")).click();
        } catch (Exception ignored) {}

        //Задание 1

        page.selectPaymentOption("Услуги связи");
        if (!page.getPhonePlaceholderText().contains("Номер") || !page.getSumPlaceholderText().contains("Сумма")) {
            throw new AssertionError("Ошибка: Услуги связи");
        }

        page.selectPaymentOption("Домашний интернет");
        if (!page.getPhonePlaceholderText().contains("Номер") || !page.getSumPlaceholderText().contains("Сумма")) {
            throw new AssertionError("Ошибка: Домашний интернет");
        }

        page.selectPaymentOption("Рассрочка");
        if (!page.getPhonePlaceholderText().contains("Номер") || !page.getSumPlaceholderText().contains("Сумма")) {
            throw new AssertionError("Ошибка: Рассрочка");
        }

        page.selectPaymentOption("Задолженность");
        if (!page.getPhonePlaceholderText().contains("Номер") || !page.getSumPlaceholderText().contains("Сумма")) {
            throw new AssertionError("Ошибка: Задолженность");
        }

        //Задание 2

        page.selectPaymentOption("Услуги связи");
        page.fillPaymentForm("297777777", "25");
        page.clickContinue();

        paymentFrame.switchToFrame();

        String descriptionAmount = paymentFrame.getInfoAmountText();
        String buttonAmount = paymentFrame.getBtnAmountText();
        if (!descriptionAmount.contains("25") || !buttonAmount.contains("25")) {
            throw new AssertionError("Неверная сумма");
        }

        String phoneTextInFrame = paymentFrame.getInfoPhoneText();
        if (!phoneTextInFrame.contains("297777777")) {
            throw new AssertionError("Неверный номер телефона");
        }

        if (!paymentFrame.getCardNumberPlaceholder().equals("Номер карты") ||
                !paymentFrame.getExpDatePlaceholder().equals("ММ / ГГ") ||
                !paymentFrame.getCvcPlaceholder().equals("CVC") ||
                !paymentFrame.getHolderNamePlaceholder().equals("Имя держателя карты")) {
            throw new AssertionError("Неверный плейсхолдер карты");
        }

        if (paymentFrame.getLogosList().isEmpty()) {
            throw new AssertionError("Иконки платёжных систем отсутствуют");
        }

        Thread.sleep(3000);
        paymentFrame.switchToDefaultContent();
        driver.quit();
    }

}
