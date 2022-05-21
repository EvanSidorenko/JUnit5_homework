package homeworkJUnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@DisplayName("Класс с демо тестами для bookvoed.ru")
public class ParametrizedTest {
    @DisplayName("Проверка поля поиска на bookvoed.ru c ValueSource")
    @BeforeAll  static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.bookvoed.ru/";
        Configuration.browserSize = "1280x609";
    }

    @ValueSource(strings = {
            "The War And The Coming Peace.",
            "Gone with the wind"
    })
    @DisplayName("Проверка поля поиска на bookvoed.ru")
    @ParameterizedTest
    void firstBookSearchTest(String testData) {
        //Presteps
        Selenide.open("https://www.bookvoed.ru/");
        // Steps
        $("[name=q]").setValue(testData);
        $(".gu").click();
        // Expected result:
        $$("[data-gtm_book_click_detail]").find(
                Condition.text(testData))
                .shouldBe(visible);
    }
    void secondBookSearchTest(String testData) {
        //Presteps
        Selenide.open("https://www.bookvoed.ru/");

        // Steps
        $("[name=q]").setValue(testData);
        $(".gu").click();

        // Expected result:
        $$("[data-gtm_book_click_detail]").find(
                        Condition.text(testData))
                .shouldBe(visible);
    }
}
