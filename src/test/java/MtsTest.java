import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MtsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://mts.by");

        try {
        WebElement acceptCookies = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookies.click();
        } catch (Exception _) {}

        //Задание 1
        WebElement mainTitle = driver.findElement(By.xpath("//*[@id='pay-section']//h2"));
        String titleText = mainTitle.getText().trim().replace("\n", " ");
        if (!titleText.equals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ")) {
            throw new AssertionError("Название не совпадает, в блоке сейчас: " + titleText);
        }

        //Задание 2
        WebElement logos = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        List<WebElement> logosList = logos.findElements(By.xpath(".//img"));
        if (logosList.isEmpty()) {
            throw new AssertionError("Логотипы платёжных систем не найдены");
        }

        //Задание 3
        WebElement link = driver.findElement(By.xpath("//*[@id='pay-section']//a"));
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('target'); arguments[0].click();", link);
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("poryadok-oplaty-i-bezopasnost-internet-platezhey")) {
            throw new AssertionError("Ссылка Подробнее о сервисе не сработала, переход на: " + currentUrl);
        }

        driver.get("https://www.mts.by/");


        //Задание 4

        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumInput.clear();
        sumInput.sendKeys("25");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        String finalUrl = driver.getCurrentUrl();

        Thread.sleep(5000);

        driver.quit();
    }

    }

