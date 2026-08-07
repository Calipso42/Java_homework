package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By paymentLogos = By.xpath("//div[@class='pay__partners']/ul/li/img");
    private final By moreInfoLink = By.xpath("//div[@class='pay__wrapper']/a[text()='Подробнее о сервисе']");
    private final By cookieButton = By.xpath("//button[@id='cookie-agree']");

    private final By selectHeader = By.xpath("//button[@class='select__header']");

    private final By connectionPhone = By.xpath("//input[@id='connection-phone']");
    private final By connectionSum = By.xpath("//input[@id='connection-sum']");
    private final By connectionEmail = By.xpath("//input[@id='connection-email']");

    private final By internetPhone = By.xpath("//input[@id='internet-phone']");
    private final By internetSum = By.xpath("//input[@id='internet-sum']");
    private final By internetEmail = By.xpath("//input[@id='internet-email']");

    private final By instalmentScore = By.xpath("//input[@id='score-instalment']");
    private final By instalmentSum = By.xpath("//input[@id='instalment-sum']");
    private final By instalmentEmail = By.xpath("//input[@id='instalment-email']");

    private final By arrearsScore = By.xpath("//input[@id='score-arrears']");
    private final By arrearsSum = By.xpath("//input[@id='arrears-sum']");
    private final By arrearsEmail = By.xpath("//input[@id='arrears-email']");

    private final By continueButton = By.xpath("//form[@id='pay-connection']/button[@type='submit']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://mts.by");
        closeCookieIfPresent();
    }

    private void closeCookieIfPresent() {
        try {
            WebElement cookie = driver.findElement(cookieButton);
            if (cookie.isDisplayed()) {
                cookie.click();
            }
        } catch (Exception ignored) {}
    }

    public String getBlockTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
    }

    public void selectPaymentOption(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        By optionLocator = By.xpath("//ul[@class='select__list']/li[p[text()='" + optionText + "']]");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }


    public String getFieldPlaceholder(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("placeholder");
    }


    public By getConnectionPhoneLocator() { return connectionPhone; }
    public By getConnectionSumLocator() { return connectionSum; }
    public By getConnectionEmailLocator() { return connectionEmail; }

    public By getInternetPhoneLocator() { return internetPhone; }
    public By getInternetSumLocator() { return internetSum; }
    public By getInternetEmailLocator() { return internetEmail; }

    public By getInstalmentScoreLocator() { return instalmentScore; }
    public By getInstalmentSumLocator() { return instalmentSum; }
    public By getInstalmentEmailLocator() { return instalmentEmail; }

    public By getArrearsScoreLocator() { return arrearsScore; }
    public By getArrearsSumLocator() { return arrearsSum; }
    public By getArrearsEmailLocator() { return arrearsEmail; }



    public PaymentFramePage fillConnectionFormAndSubmit(String phone, String sum) {

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhone));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement sumInput = driver.findElement(connectionSum);
        sumInput.clear();
        sumInput.sendKeys(sum);

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        btn.click();

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        return new PaymentFramePage(driver);
    }
}
