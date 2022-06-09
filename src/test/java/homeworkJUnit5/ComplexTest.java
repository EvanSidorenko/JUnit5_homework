package homeworkJUnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComplexTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://www.bookvoed.ru/";
        Configuration.browserSize = "1280x609";
    }

    @CsvSource({
            "The War and the Coming Peace, Morris Jastrow Jr.",
            "Gone with the wind, M.Mitchell"
    })
    @ParameterizedTest(name = "Проверка поля поиска на bookvoed.ru : {0}, ожидаем результат: {1}")
    void bookSearchTest(String testData, String expectedResult) {
        //Presteps
        Selenide.open(Configuration.baseUrl);
        // Steps
        $("[name=q]").setValue(testData);
        $(".ju").click();
        // Expected result:
        $$(".eE").find(
                Condition.text(expectedResult))
                .shouldBe(visible);
    }
}
