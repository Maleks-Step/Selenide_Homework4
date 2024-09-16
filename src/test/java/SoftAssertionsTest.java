import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = true; // не закрывает браузер
        // Configuration.pageLoadStrategy = "eager"; убрано из-за медленной техники
}

@Test
void jUnitSoftAssertions() {

        Selenide.open("/selenide/selenide"); //Откройте страницу Selenide в Github
        $("#wiki-tab").click();
        $(".markdown-body").$("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body").shouldHave(text(""" 
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));


    }
}
