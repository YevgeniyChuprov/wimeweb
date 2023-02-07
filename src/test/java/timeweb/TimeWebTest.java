package timeweb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TimeWebTest extends TestBase {

    @Test
    @DisplayName("Проверка перехода с главной на страницу стоимости виртуальногохостинга")
    public void openingVirtualHostingPage() {
        step("Нажимаем на кнопку 'Попробовать бесплатно', блока 'Виртуальный хостинг'", () -> {
            $(By.xpath("//button[contains(text(),'Попробовать бесплатно')]")).click();
        });
        step("Проверяем открытие нужной нам страницы", () -> {
            $("h1").shouldHave(text("Надежный виртуальный хостинг для всех"));
        });
    }

    @Test
    @DisplayName("Открытие окна оплата услуг")
    public void clickPaymentForServices() {
        step("Нажимаем на ссылку оплата услуг", () -> {
            $(By.xpath("//a[@data-selenium='header-btn-payment']")).click();
        });
        step("Проверяем наличие платежной системы ЮMoney", () -> {
            $("div").shouldHave(text("ЮMoney"));
        });
        step("Проверяем наличие платежной системы Qiwi Кошелек", () -> {
            $("div").shouldHave(text("Qiwi Кошелек"));
        });
    }

    @Test
    @DisplayName("Проверка поиска")
    public void checkingSearch() {
        step("Кликаем по иконке поиска", () -> {
            $(".search-toggle").click();
        });
        step("В открывшийся инпут вводим слово 'конструктор'", () -> {
            $("input").setValue("конструктор").pressEnter();
        });
        step("Проверяем результаты поиска", () -> {
            $(".results").shouldHave(text("конструктор"));
        });
    }

    @Test
    @DisplayName("Все тарифы 1С-Битрикс")
    public void all1CBitrixTariffs() {
        step("Переходим по ссылке", () -> {
            $(By.xpath("//a[@data-selenium='header-menu-btn-bitrix']")).click();
        });
        step("Проверяем открытие страницы", () -> {
            $("h1").shouldHave(text("Хостинг для 1С-Битрикс"));
        });
        step("Нажимаем на кнопку 'Все тарифы списком'", () -> {
            $(".all-tariff-list__text").click();
        });
        step("Проверяем открытие окна с тарифами", () -> {
            $(".hosting-form-info__title").shouldHave(text("Сравнение тарифов списком"));
        });
    }

    @Test
    @DisplayName("Проверка свободного домена")
    public void checkFreeDomain() {
        step("Нажимаем кнопку домены в хедере", () -> {
            $("[data-selenium='header-menu-btn-domains']").click();
        });
        step("Вводим в инпут название домена занятость которого хотим проверить", () -> {
            $("#domain-search-input").setValue("test.ru");
        });
        step("Нажимаем кнопку проверить домены", () -> {
            $(By.xpath("//div[@class='right d']")).shouldHave(text("ПРОВЕРИТЬ ДОМЕНЫ")).click();
        });
        step("Проверяем наличие домена в результатах", () -> {
            $(By.xpath("//strong[text()='test.ru']")).shouldHave(text("test.ru"));
        });
        step("Проверяем результат проверки домена", () -> {
            $(".domains-list .availability strong").shouldHave(text("домен занят"));
        });
    }
}
