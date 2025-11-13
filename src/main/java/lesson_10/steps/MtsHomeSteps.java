package lesson_10.steps;

import lesson_10.page.MtsHomePage;
import org.openqa.selenium.WebDriver;

public class MtsHomeSteps {
    private final MtsHomePage homePage;

    public MtsHomeSteps(WebDriver driver) {
        this.homePage = new MtsHomePage(driver);
    }

    public void acceptCookies() {
        homePage.acceptCookies();
    }

    public String getBlockTitle() {
        return homePage.getBlockTitle();
    }

    public boolean isLogoDisplayed(String logoName) {
        return switch (logoName.toLowerCase()) {
            case "visa" -> homePage.isLogoDisplayed(homePage.getVisaLogo());
            case "mastercard" -> homePage.isLogoDisplayed(homePage.getMastercardLogo());
            case "mir" -> homePage.isLogoDisplayed(homePage.getMirLogo());
            case "belkart" -> homePage.isLogoDisplayed(homePage.getBelkartLogo());
            case "other" -> homePage.isLogoDisplayed(homePage.getOtherLogo());
            default -> false;
        };
    }

    public void clickMoreInfo() {
        homePage.clickMoreInfo();
    }

    public String getSelectedServiceLabel() {
        return homePage.getSelectedServiceLabel();
    }

    public void selectServiceType(String serviceName) {
        homePage.selectServiceType(serviceName);
    }

    public void fillPaymentForm(String phone, String amount) {
        homePage.fillPaymentForm(phone, amount);
    }

    public void clickContinue() {
        homePage.clickContinue();
    }

    public String getTabTextInternet() {
        return homePage.getTabTextInternet();
    }

    public String getPhonePlaceholderInternet() {
        return homePage.getPhonePlaceholderInternet();
    }

    public String getSumPlaceholderInternet() {
        return homePage.getSumPlaceholderInternet();
    }

    public String getEmailPlaceholderInternet() {
        return homePage.getEmailPlaceholderInternet();
    }

    public String getTabTextInstalment() {
        return homePage.getTabTextInstalment();
    }

    public String getScorePlaceholderInstalment() {
        return homePage.getScorePlaceholderInstalment();
    }

    public String getSumPlaceholderInstalment() {
        return homePage.getSumPlaceholderInstalment();
    }

    public String getEmailPlaceholderInstalment() {
        return homePage.getEmailPlaceholderInstalment();
    }

    public String getTabTextArrears() {
        return homePage.getTabTextArrears();
    }

    public String getScorePlaceholderArrears() {
        return homePage.getScorePlaceholderArrears();
    }

    public String getSumPlaceholderArrears() {
        return homePage.getSumPlaceholderArrears();
    }

    public String getEmailPlaceholderArrears() {
        return homePage.getEmailPlaceholderArrears();
    }

    public String getIframePhoneValue() {
        return homePage.getIframePhoneValue();
    }

    public String getIframeAmountValueTop() {
        return homePage.getIframeAmountValueTop();
    }

    public String getIframeAmountValueOnButton() {
        return homePage.getIframeAmountValueOnButton();
    }

    public boolean isCardNumberFieldDisplayed() {
        return homePage.isCardNumberFieldDisplayed();
    }

    public boolean isCardExpiryFieldDisplayed() {
        return homePage.isCardExpiryFieldDisplayed();
    }

    public boolean isCardCvcFieldDisplayed() {
        return homePage.isCardCvcFieldDisplayed();
    }

    public boolean isCardHolderFieldDisplayed() {
        return homePage.isCardHolderFieldDisplayed();
    }

    public boolean isVisaLogoInCardFieldDisplayed() {
        return homePage.isVisaLogoInCardFieldDisplayed();
    }

    public boolean isMastercardLogoInCardFieldDisplayed() {
        return homePage.isMastercardLogoInCardFieldDisplayed();
    }

    public boolean isBelcartLogoInCardFieldDisplayed() {
        return homePage.isBelcartLogoInCardFieldDisplayed();
    }

    public void switchToPaymentIframe() {
        homePage.switchToPaymentIframe();
    }

    public void switchBackFromIframe() {
        homePage.switchBackFromIframe();
    }
}