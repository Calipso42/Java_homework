import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeEach
    public void openHomePage() {

        driver.get("https://mts.by");

        try {
            WebElement cookieBtn = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
            }
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("1. Проверка названия блока")
    public void testBlockTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']/h2")
        ));

        String actualTitle = titleElement.getText().trim();
        actualTitle = actualTitle.replace("\n", " ").replace("\r", " ");

        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualTitle, "Название блока не совпадает");
    }

    @Test
    @DisplayName("2. Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li/img"));

        assertTrue(logos.size() > 0, "Логотипы платёжных систем не найдены");

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается на странице");
        }
    }

    @Test
    @DisplayName("3. Проверка работы ссылки «Подробнее о сервисе»")
    public void testMoreInfoLink() {
        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='pay__wrapper']/a[text()='Подробнее о сервисе']")
        ));
        moreInfoLink.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost"));
        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("poryadok-oplaty-i-bezopasnost"), "Ссылка перевела на неверную страницу");
    }

    @Test
    @DisplayName("4. Заполнение полей и проверка работы кнопки «Продолжить»")
    public void testSubmitForm() {

        WebElement activeTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@class='select__header']")
        ));


        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='connection-phone']")
        ));
        phoneField.sendKeys("297777777");


        WebElement sumField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumField.sendKeys("25");


        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']/button[@type='submit']"));
        continueButton.click();

        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' недоступна или форма не отправилась");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
