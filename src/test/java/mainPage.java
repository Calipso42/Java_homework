import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {
    private final WebDriver driver;

    private final By dropdown = By.xpath("//div[contains(@class, 'pay__select')]");

    private final By phoneInput = By.xpath("//input[@id='connection-phone']");
    private final By sumInput = By.xpath("//input[@id='connection-sum']");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[contains(text(), 'Продолжить')]");

    public mainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPaymentOption(String optionName) {
        By dropdownButton = By.xpath("//*[@id='pay-section']//button[contains(@class, 'select__header')] " +
                "| //*[@id='pay-section']//div[contains(@class, 'select__header')] " +
                "| //*[@id='pay-section']//button");
        driver.findElement(dropdownButton).click();

        String itemIndex = "1"; // Услуги связи
        if (optionName.equals("Домашний интернет")) {
            itemIndex = "2";
        } else if (optionName.equals("Рассрочка")) {
            itemIndex = "3";
        } else if (optionName.equals("Задолженность")) {
            itemIndex = "4";
        }

        By optionXpath = By.xpath("//*[@id='pay-section']//ul/li[" + itemIndex + "]/p " +
                "| //*[@id='pay-section']//ul/li[" + itemIndex + "]/button");
        driver.findElement(optionXpath).click();
    }

    public String getPhonePlaceholderText() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    public String getSumPlaceholderText() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public void fillPaymentForm(String phone, String sum) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(sumInput).clear();
        driver.findElement(sumInput).sendKeys(sum);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

}