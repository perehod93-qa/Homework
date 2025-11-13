package lesson_10.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    private final By breadcrumbThirdItem = By.xpath("//*[@id=\"breadcrumbs\"]/div/div/div/div/ul/li[3]/span/span");

    private final By serviceTypeButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By selectedServiceLabel = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]");
    private final By serviceTypeOptions = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]//ul/li/p");

    private final By phoneInput = By.xpath("//*[@id=\"connection-phone\"]");
    private final By amountInput = By.xpath("//*[@id=\"connection-sum\"]");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");

    private final By connectionCardNumber = By.xpath("//*[@id=\"cc-number\"]");
    private final By connectionCardExpiry = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/input");
    private final By connectionCardCvc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input");
    private final By connectionCardHolder = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div");

    private final By iframePhoneValue = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    private final By iframeAmountTop = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span");
    private final By iframePayButtonAmount = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button/span");

    private final By tabInternet = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p");
    private final By internetPhoneInput = By.xpath("//*[@id=\"internet-phone\"]");
    private final By internetSumInput = By.xpath("//*[@id=\"internet-sum\"]");
    private final By internetEmailInput = By.xpath("//*[@id=\"internet-email\"]");

    private final By tabInstalment = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    private final By instalmentScoreInput = By.xpath("//*[@id=\"score-instalment\"]");
    private final By instalmentSumInput = By.xpath("//*[@id=\"instalment-sum\"]");
    private final By instalmentEmailInput = By.xpath("//*[@id=\"instalment-email\"]");

    private final By tabArrears = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");
    private final By arrearsScoreInput = By.xpath("//*[@id=\"score-arrears\"]");
    private final By arrearsSumInput = By.xpath("//*[@id=\"arrears-sum\"]");
    private final By arrearsEmailInput = By.xpath("//*[@id=\"arrears-email\"]");

    private final By paymentIframe = By.xpath("/html/body/div[9]/div/iframe");

    private final By visaLogoInCardField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]");
    private final By mastercardLogoInCardField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]");
    private final By belcartLogoInCardField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]");

    public String getSelectedServiceLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectedServiceLabel)).getText();
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public boolean isLogoDisplayed(By logo) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void clickMoreInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
        wait.until(ExpectedConditions.urlContains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    public String getBreadcrumbThirdItemText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(breadcrumbThirdItem)).getText().trim();
    }

    public void selectServiceType(String serviceName) {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeButton)).click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(serviceTypeOptions));
        for (WebElement opt : options) {
            if (opt.getText().trim().equalsIgnoreCase(serviceName)) {
                opt.click();
                return;
            }
        }
        throw new IllegalArgumentException("Service type not found: " + serviceName);
    }

    public void fillPaymentForm(String phone, String amount) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        phoneField.clear();
        phoneField.sendKeys(phone);
        amountField.clear();
        amountField.sendKeys(amount);

        if (!phone.equals(phoneField.getAttribute("value")) || !amount.equals(amountField.getAttribute("value"))) {
            throw new AssertionError("Поля формы не заполнились корректно: ожидается [" + phone + ", " + amount +
                    "], фактически [" + phoneField.getAttribute("value") + ", " + amountField.getAttribute("value") + "]");
        }
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public String getTabTextInternet() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabInternet)).getText();
    }

    public String getPhonePlaceholderInternet() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetPhoneInput)).getAttribute("placeholder");
    }

    public String getSumPlaceholderInternet() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetSumInput)).getAttribute("placeholder");
    }

    public String getEmailPlaceholderInternet() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetEmailInput)).getAttribute("placeholder");
    }

    public String getTabTextInstalment() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabInstalment)).getText();
    }

    public String getScorePlaceholderInstalment() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(instalmentScoreInput)).getAttribute("placeholder");
    }

    public String getSumPlaceholderInstalment() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(instalmentSumInput)).getAttribute("placeholder");
    }

    public String getEmailPlaceholderInstalment() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(instalmentEmailInput)).getAttribute("placeholder");
    }

    public String getTabTextArrears() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabArrears)).getText();
    }

    public String getScorePlaceholderArrears() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsScoreInput)).getAttribute("placeholder");
    }

    public String getSumPlaceholderArrears() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsSumInput)).getAttribute("placeholder");
    }

    public String getEmailPlaceholderArrears() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsEmailInput)).getAttribute("placeholder");
    }

    public String getIframePhoneValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iframePhoneValue)).getText().trim();
    }

    public String getIframeAmountValueTop() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iframeAmountTop)).getText().replaceAll("[^0-9]", "").trim();
    }

    public String getIframeAmountValueOnButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iframePayButtonAmount)).getText().replaceAll("[^0-9]", "").trim();
    }

    public boolean isVisaLogoInCardFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogoInCardField)).isDisplayed();
    }

    public boolean isMastercardLogoInCardFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardLogoInCardField)).isDisplayed();
    }

    public boolean isBelcartLogoInCardFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(belcartLogoInCardField)).isDisplayed();
    }

    public boolean isCardNumberFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectionCardNumber)).isDisplayed();
    }

    public boolean isCardExpiryFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectionCardExpiry)).isDisplayed();
    }

    public boolean isCardCvcFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectionCardCvc)).isDisplayed();
    }

    public boolean isCardHolderFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectionCardHolder)).isDisplayed();
    }

    public void switchToPaymentIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
    }

    public void switchBackFromIframe() {
        driver.switchTo().defaultContent();
    }
}