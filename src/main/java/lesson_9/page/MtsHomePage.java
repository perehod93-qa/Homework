package lesson_9.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cookieButton = By.xpath("//*[@id=\"cookie-agree\"]");
    private final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    @Getter
    private final By visaLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    @Getter
    private final By mastercardLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    @Getter
    private final By mirLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    @Getter
    private final By belkartLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    @Getter
    private final By otherLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private final By moreInfoLink = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");
    private final By serviceTypeButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By phoneInput = By.xpath("//*[@id='connection-phone']");
    private final By amountInput = By.xpath("//*[@id='connection-sum']");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public boolean isLogoDisplayed(By logo) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    /**
     * Клик по ссылке "Подробнее" + проверка перехода по URL
     */
    public void clickMoreInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();

        wait.until(ExpectedConditions.urlContains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    /**
     * Заполнение формы оплаты + проверка, что поля действительно заполнены
     */
    public void fillPaymentForm(String phone, String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeButton)).click();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));

        phoneField.clear();
        phoneField.sendKeys(phone);
        amountField.clear();
        amountField.sendKeys(amount);

        String actualPhone = phoneField.getAttribute("value");
        String actualAmount = amountField.getAttribute("value");

        if (!actualPhone.equals(phone) || !actualAmount.equals(amount)) {
            throw new AssertionError("Поля формы не заполнились корректно: "
                    + "ожидалось [" + phone + ", " + amount + "], "
                    + "фактически [" + actualPhone + ", " + actualAmount + "]");
        }
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}