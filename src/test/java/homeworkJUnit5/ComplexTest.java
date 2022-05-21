package homeworkJUnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComplexTest {
    @DisplayName("Проверка поля поиска на bookvoed.ru c ValueSource")
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.bookvoed.ru/";
        Configuration.browserSize = "1280x609";
    }
    @CsvSource ({
            "The War And The Coming Peace.", "Morris Jastrow",
            "Gone with the wind", "M.Mitchell"
    })
    @DisplayName("Проверка поля поиска на bookvoed.ru")
    @ParameterizedTest
    void firstBookSearchTest(String testData, String expectedResult) {
        //Presteps
        Selenide.open("https://www.bookvoed.ru/");
        // Steps
        $("[name=q]").setValue(testData);
        $(".gu").click();
        // Expected result:
        $$("[data-gtm_book_click_detail]").find(
                Condition.text(expectedResult))
                .shouldBe(visible);
    }
}
