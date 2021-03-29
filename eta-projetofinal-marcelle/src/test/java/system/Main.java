package system;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import system.helpers.DriverManager;
import system.pages.LocalizaMainPage;

import static java.lang.Thread.sleep;

public class Main {

    private WebDriver driver;
    @Test
    void atividadeX() {
        // GIVEN
        LocalizaMainPage mainPage = new LocalizaMainPage();

        // WHEN
        mainPage.acessarPagina();
        mainPage.pesquisar("Recife");
        mainPage.acessarLoja();

        // FINALLY
        DriverManager.endSession();
    }
}
