import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.PaymentFramePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPageObjectTest {

    private static WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void initPage() {
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("1. Проверка названия блока")
    public void testBlockTitle() {
        String actualTitle = mainPage.getBlockTitleText().trim()
                .toLowerCase().replace("\n", " ").replace("\r", " ").replaceAll("\\s+", " ");
        assertEquals("онлайн пополнение без комиссии", actualTitle, "Название блока не совпадает");
    }

    @Test
    @DisplayName("2. Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        assertTrue(logos.size() > 0, "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов платежных систем скрыт");
        }
    }

    @Test
    @DisplayName("3. Проверка работы ссылки «Подробнее о сервисе»")
    public void testMoreInfoLink() {
        mainPage.clickMoreInfoLink();
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost"), "Ссылка не сработала");
    }

    @Test
    @DisplayName("4. Проверка надписей в незаполненных полях каждого варианта оплаты")
    public void testPlaceholdersForAllOptions() {
        mainPage.selectPaymentOption("Услуги связи");
        assertEquals("Номер телефона", mainPage.getFieldPlaceholder(mainPage.getConnectionPhoneLocator()));
        assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.getConnectionSumLocator()));
        assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.getConnectionEmailLocator()));

        mainPage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getFieldPlaceholder(mainPage.getInternetPhoneLocator()));
        assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.getInternetSumLocator()));
        assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.getInternetEmailLocator()));

        mainPage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getFieldPlaceholder(mainPage.getInstalmentScoreLocator()));
        assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.getInstalmentSumLocator()));
        assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.getInstalmentEmailLocator()));

        mainPage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getFieldPlaceholder(mainPage.getArrearsScoreLocator()));
        assertEquals("Сумма", mainPage.getFieldPlaceholder(mainPage.getArrearsSumLocator()));
        assertEquals("E-mail для отправки чека", mainPage.getFieldPlaceholder(mainPage.getArrearsEmailLocator()));
    }

    @Test
    @DisplayName("5. Проверка окна оплаты для варианта «Услуги связи»")
    public void testPaymentIframeValidation() {
        mainPage.selectPaymentOption("Услуги связи");

        PaymentFramePage paymentFramePage = mainPage.fillConnectionFormAndSubmit("297777777", "25");

        paymentFramePage.switchToPaymentIframe();

        String amountInfo = paymentFramePage.getAmountFromInfo();
        assertEquals("25.00 BYN", amountInfo, "Сумма в описании платежа некорректна");

        String phoneInfo = paymentFramePage.getPhoneFromInfo();
        assertTrue(phoneInfo.contains("375297777777"), "Номер телефона во фрейме не совпадает: " + phoneInfo);

        String buttonText = paymentFramePage.getPayButtonText();
        assertEquals("Оплатить 25.00 BYN", buttonText, "Текст или сумма на кнопке не совпадают");

        assertTrue(paymentFramePage.isCardFieldDisplayed("number"), "Поле ввода номера карты отсутствует");
        assertTrue(paymentFramePage.isCardFieldDisplayed("expiry"), "Поле ввода срока действия отсутствует");
        assertTrue(paymentFramePage.isCardFieldDisplayed("cvc"), "Поле ввода CVC кода отсутствует");
        assertTrue(paymentFramePage.isCardFieldDisplayed("holder"), "Поле ввода имени и фамилии держателя отсутствует");

        assertEquals("Номер карты", paymentFramePage.getCardFieldLabelText("number"), "Неверная подпись поля номера карты");
        assertEquals("Срок действия", paymentFramePage.getCardFieldLabelText("expiry"), "Неверная подпись поля срока действия");
        assertEquals("CVC", paymentFramePage.getCardFieldLabelText("cvc"), "Неверная подпись поля CVC");
        assertEquals("Имя и фамилия на карте", paymentFramePage.getCardFieldLabelText("holder"), "Неверная подпись поля имени и фамилии держателя!");

        List<WebElement> logos = paymentFramePage.getCardLogos();
        assertTrue(logos.size() > 0, "Иконки платежных систем внутри окна оплаты отсутствуют");

        paymentFramePage.switchToDefaultContent();
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Тестирование успешно завершено.");
        if (driver != null) {
            driver.quit();
        }
    }
}