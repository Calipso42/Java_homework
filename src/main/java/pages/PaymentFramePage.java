package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentFramePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By iframeLocator = By.xpath("//iframe[contains(@src, 'bepaid') or contains(@class, 'bepaid')]");

    private final By paymentAmountInfo = By.xpath("//app-payment-container//section/div/div/div/div/span");
    private final By paymentPhoneInfo = By.xpath("//app-payment-container//section/div/div/div/span");
    private final By payButton = By.xpath("//app-card-page/div/div/button/span");

    private final By cardNumberInput = By.xpath("//app-card-input//app-input[contains(@class, 'number')]//input | //input[contains(@autocomplete, 'cc-number') or @type='tel']");
    private final By cardExpiryInput = By.xpath("//app-card-input//app-input[contains(@class, 'expiration')]//input | //input[contains(@autocomplete, 'cc-exp')]");
    private final By cardCvcInput = By.xpath("//app-card-input//app-input[contains(@class, 'cvc')]//input | //input[contains(@autocomplete, 'cc-csc') or @type='password']");
    private final By cardHolderInput = By.xpath("//app-card-input//app-input[contains(@class, 'holder')]//input | //input[contains(@autocomplete, 'cc-name') or @type='text']");

    private final By cardLogos = By.xpath("//app-card-input//form/div/div/app-input/div/div/div/div/div | //div[contains(@class, 'brands')]/*");

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void switchToPaymentIframe() {

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        wait.until(ExpectedConditions.presenceOfElementLocated(cardNumberInput));

    }

    public String getAmountFromInfo() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(paymentAmountInfo)).getText().trim();
    }

    public String getPhoneFromInfo() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(paymentPhoneInfo)).getText().trim();
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(payButton)).getText().trim();
    }

    public boolean isCardFieldDisplayed(String fieldType) {
        By locator = switch (fieldType) {
            case "number" -> cardNumberInput;
            case "expiry" -> cardExpiryInput;
            case "cvc" -> cardCvcInput;
            case "holder" -> cardHolderInput;
            default -> throw new IllegalArgumentException("Неверный тип поля: " + fieldType);
        };
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    public String getCardFieldLabelText(String fieldType) {
        By labelLocator = switch (fieldType) {
            case "number" -> By.xpath("//app-card-input//form/div[1]/div[1]//label");
            case "expiry" -> By.xpath("//app-card-input//form/div[1]/div[2]/div[1]//label");
            case "cvc" -> By.xpath("//app-card-input//form/div[1]/div[2]/div[3]//label");
            case "holder" -> By.xpath("//app-card-input//form/div[1]/div[3]//label");
            default -> throw new IllegalArgumentException("Неверный тип поля: " + fieldType);
        };

        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelLocator)).getText().trim();

    }

    public List<WebElement> getCardLogos() {
        return driver.findElements(cardLogos);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}