package lesson_9.tests;

import lesson_9.steps.MtsHomeSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsHomePageTests extends BaseTest {

    private MtsHomeSteps steps;

    @BeforeEach
    public void setUpTest() {
        // driver уже инициализирован в BaseTest.setUp()
        steps = new MtsHomeSteps(driver);
        steps.acceptCookies();
    }

    @Test
    @DisplayName("Проверка заголовка блока оплаты")
    public void testPaymentBlockTitle() {
        String title = steps.getBlockTitle();
        System.out.println("Заголовок: '" + title + "'");
        assertTrue(title.contains("Онлайн пополнение\n" +
                "без комиссии"), "Заголовок блока оплаты некорректен");
    }

    @ParameterizedTest(name = "Проверка отображения логотипа: {0}")
    @ValueSource(strings = {"visa", "mastercard", "mir", "belkart", "other"})
    @DisplayName("Проверка отображения логотипов")
    public void testPaymentLogos(String logoName) {
        assertTrue(steps.isLogoDisplayed(logoName), "Логотип " + logoName + " не отображается");
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        steps.clickMoreInfo();
    }

    @Test
    @DisplayName("Заполнение формы оплаты и проверка кнопки 'Продолжить'")
    public void testFillPaymentForm() {
        steps.fillPaymentForm("297777777", "10");
        steps.clickContinue();
    }
}