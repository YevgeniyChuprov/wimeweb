package timeweb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TimeWebTest extends TestBase {

    @Test
    @DisplayName("Проверка перехода с главной на страницу стоимости виртуальногохостинга")
    public void openingVirtualHostingPage() {
        $("button").shouldHave(text("Попробовать бесплатно")).click();
        $("h1").shouldHave(text("Надежный виртуальный хостинг для всех"));
    }

    @Test
    @DisplayName("Открытие окна оплата услуг")
    public void clickPaymentForServices() {
        $("[data-selenium='header-btn-payment']").click();
        $("div").shouldHave(text("ЮMoney"));
        $("div").shouldHave(text("Qiwi Кошелек"));
    }

    @Test
    @DisplayName("Проверка поиска")
    public void checkingSearch() {
        $(".search-toggle").click();
        $("input").setValue("конструктор").pressEnter();
        $(".results").shouldHave(text("конструктор"));
    }

    @Test
    @DisplayName("Все тарифы 1С-Битрикс")
    public void all1CBitrixTariffs() {
        $(By.xpath("//a[@data-selenium='header-menu-btn-bitrix']")).click();
        $("h1").shouldHave(text("Хостинг для 1С-Битрикс"));
        $(".all-tariff-list__text").click();
        $(".hosting-form-info__title").shouldHave(text("Сравнение тарифов списком"));
    }

    @Test
    @DisplayName("Проверка свободного домена")
    public void checkFreeDomain() {
        $(By.xpath("//a[@data-selenium='header-menu-btn-domains']")).click();
        $("#domain-search-input").setValue("test.ru");
        $(By.xpath("//div[@class='right d']")).shouldHave(text("ПРОВЕРИТЬ ДОМЕНЫ")).click();
        $(".domains-list .name strong").shouldHave(text("test.ru"));
        $(".domains-list .availability strong").shouldHave(text("домен занят"));
    }
}
