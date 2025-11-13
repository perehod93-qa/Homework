package lesson_10.tests;

import lesson_10.steps.MtsHomeSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MtsHomePageTests extends BaseTest {

    private MtsHomeSteps steps;

    @BeforeEach
    public void setUpTest() {
        steps = new MtsHomeSteps(driver);
        steps.acceptCookies();
    }

    @Test
    @DisplayName("Проверка заголовка блока оплаты")
    public void testPaymentBlockTitle() {
        String title = steps.getBlockTitle();
        System.out.println("Заголовок: '" + title + "'");
        assertTrue(title.contains("Онлайн пополнение\nбез комиссии"),
                "Заголовок блока оплаты некорректен");
    }

    @ParameterizedTest(name = "Проверка отображения логотипа: {0}")
    @ValueSource(strings = {"visa", "mastercard", "mir", "belkart", "other"})
    @DisplayName("Проверка отображения логотипов")
    public void testPaymentLogos(String logoName) {
        assertTrue(steps.isLogoDisplayed(logoName),
                "Логотип " + logoName + " не отображается");
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе' и навигационной цепочки")
    public void testMoreInfoLink() {
        steps.clickMoreInfo();
        assertTrue(driver.getCurrentUrl()
                        .contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Не произошёл переход на страницу 'Подробнее'");
        String breadcrumbText = steps.getBreadcrumbThirdItemText();
        assertEquals("Порядок оплаты и безопасность интернет платежей", breadcrumbText,
                "Текст третьего пункта навигационной цепочки некорректен");
    }

    @Test
    @DisplayName("Проверка незаполненных полей (плейсхолдеры) во всех вкладках")
    public void testEmptyFieldsPlaceholdersAllServices() {
        steps.selectServiceType("Домашний интернет");
        assertEquals("Домашний интернет", steps.getSelectedServiceLabel(),
                "Вкладка Интернет не отображает текст");
        assertNotNull(steps.getPhonePlaceholderInternet(),
                "Плейсхолдер телефона Интернет отсутствует");
        assertNotNull(steps.getSumPlaceholderInternet(),
                "Плейсхолдер суммы Интернет отсутствует");
        assertNotNull(steps.getEmailPlaceholderInternet(),
                "Плейсхолдер email Интернет отсутствует");

        steps.selectServiceType("Рассрочка");
        assertEquals("Рассрочка", steps.getSelectedServiceLabel(),
                "Вкладка Рассрочка не отображает текст");
        assertNotNull(steps.getScorePlaceholderInstalment(),
                "Плейсхолдер счёта Рассрочка отсутствует");
        assertNotNull(steps.getSumPlaceholderInstalment(),
                "Плейсхолдер суммы Рассрочка отсутствует");
        assertNotNull(steps.getEmailPlaceholderInstalment(),
                "Плейсхолдер email Рассрочка отсутствует");

        steps.selectServiceType("Задолженность");
        assertEquals("Задолженность", steps.getSelectedServiceLabel(),
                "Вкладка Задолженность не отображает текст");
        assertNotNull(steps.getScorePlaceholderArrears(),
                "Плейсхолдер счёта Задолженность отсутствует");
        assertNotNull(steps.getSumPlaceholderArrears(),
                "Плейсхолдер суммы Задолженность отсутствует");
        assertNotNull(steps.getEmailPlaceholderArrears(),
                "Плейсхолдер email Задолженность отсутствует");
    }

    @Test
    @DisplayName("Заполнение формы «Услуги связи» и проверка карточной страницы")
    public void testFillPaymentFormAndCardPage() {
        String testPhone = "(29)777-77-77";
        String testSum = "10";

        steps.selectServiceType("Услуги связи");
        steps.fillPaymentForm(testPhone, testSum);
        steps.clickContinue();

        steps.switchToPaymentIframe();

        String actualIframePhone = steps.getIframePhoneValue().replaceAll("\\D", "");
        String expectedPhoneDigits = testPhone.replaceAll("\\D", "");

        assertTrue(actualIframePhone.endsWith(expectedPhoneDigits),
                "Телефон в iframe не соответствует введённому. Ожидалось окончание: " + expectedPhoneDigits +
                        ", фактически: " + actualIframePhone);

        String actualAmountTop = steps.getIframeAmountValueTop().replace(",", ".").trim();
        String actualAmountButton = steps.getIframeAmountValueOnButton().replace(",", ".").trim();

        double expectedAmount = Double.parseDouble(testSum);
        double actualAmountTopVal = Double.parseDouble(actualAmountTop);
        double actualAmountButtonVal = Double.parseDouble(actualAmountButton);

        if (actualAmountTopVal > expectedAmount * 10) {
            actualAmountTopVal = actualAmountTopVal / 100;
            actualAmountButtonVal = actualAmountButtonVal / 100;
        }

        assertEquals(expectedAmount, actualAmountTopVal,
                "Сумма сверху в iframe не соответствует введённой");
        assertEquals(expectedAmount, actualAmountButtonVal,
                "Сумма на кнопке 'Оплатить' не соответствует введённой");

        assertTrue(steps.isCardNumberFieldDisplayed(),
                "Поле номера карты не отображается");
        assertTrue(steps.isCardExpiryFieldDisplayed(),
                "Поле даты истечения карты не отображается");
        assertTrue(steps.isCardCvcFieldDisplayed(),
                "Поле CVC карты не отображается");
        assertTrue(steps.isCardHolderFieldDisplayed(),
                "Поле держателя карты не отображается");
        assertTrue(steps.isVisaLogoInCardFieldDisplayed(),
                "Логотип Visa в поле номера карты не отображается");
        assertTrue(steps.isMastercardLogoInCardFieldDisplayed(),
                "Логотип MasterCard в поле номера карты не отображается");
        assertTrue(steps.isBelcartLogoInCardFieldDisplayed(),
                "Логотип Belcart в поле номера карты не отображается");

        steps.switchBackFromIframe();
    }
}