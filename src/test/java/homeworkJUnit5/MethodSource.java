package homeworkJUnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MethodSource {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://www.bookvoed.ru/";
        Configuration.browserSize = "1280x609";
    }

    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
                Arguments.of("Мероприятия", "Что бы почитать?")
        );
    }

    @org.junit.jupiter.params.provider.MethodSource("methodSourceTest")
    @ParameterizedTest(name = "Тест с датапровайдером MethodSource : {0}, ожидаем селектор: {1}")
    void methodSourceTest(String testData, String expectedResult) {
        //Presteps
        Selenide.open(Configuration.baseUrl);
        // Steps
        $("a[class=\"Zjb akb\"]").click();


        // Expected result:
        $$(".akb").find(
                        Condition.text(expectedResult))
                        .shouldBe(visible);
    }
}
