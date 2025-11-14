package lesson_9.steps;

import lesson_9.page.MtsHomePage;
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

    public String getBreadcrumbThirdItemText() {
        return homePage.getBreadcrumbThirdItemText();
    }

    public void fillPaymentForm(String phone, String amount) {
        homePage.fillPaymentForm(phone, amount);
    }

    public void clickContinue() {
        homePage.clickContinue();
    }
}