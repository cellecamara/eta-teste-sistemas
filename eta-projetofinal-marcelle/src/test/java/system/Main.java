package system;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import system.helpers.DriverManager;
import system.pages.MainPage;


public class Main {

    //    private WebDriver driver;
//    private WebDriverWait wait;
    @Test
    void atividadeX() throws InterruptedException {
        //driver = DriverManager.getDriver();
        //wait = DriverManager.getDriverWait();
//        wait = new WebDriverWait(driver, 15);

        // GIVEN
        MainPage mainPage = new MainPage();

        // WHEN
        mainPage.accessPage();
        mainPage.fillInAddress("Olinda");
        mainPage.clickSearch();

        try {

            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.findElement(By.cssSelector("header > div.dd.dm > div > a.bx.by.bg.c9.b3.ca.cb.cc.br.bs.ag.as.bk.bh.ek.dl.b6 > div.h3.an.al"));
            Assert.assertEquals("Olinda",mainPage.getSelectedLocation());
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        //System.out.println(mainPage.getLocalEntrega());
        //System.out.println(mainPage.getCardLoja());
        //Thread.sleep(2000);

        // FINALLY
        DriverManager.endSession();
    }
}
