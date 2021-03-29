package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import static system.pages.URL.LOCALIZA_MAIN_PAGE;
import static system.pages.URL.MAIN_PAGE;

public class LocalizaMainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By campoLocalRetirada = By.cssSelector(".top-bar-first-step__pick-up [formcontrolname='searchValue']");
    private By campoEnderecoEntrega = By.cssSelector("#location-typeahead-home-input");
    private By botaoPesquisar = By.cssSelector("button.be.bf.bg.bh.bi.en.ag.bk.bl.b6.bm.bn.bo.eo.ep.br.bs.c1.eq");


    public LocalizaMainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void acessarPagina() {
        driver.get(LOCALIZA_MAIN_PAGE);
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main-content")));
        } catch (Exception e) {
        }
    }

    public void acessarLoja(){
        driver.get("https://www.ubereats.com/recife/food-delivery/kfc-shopping-riomar-recife/QFkEBOsPTWuqdCMMsjLe6A");
    }

    public void preencheEndereco(String local){
        driver.findElement(campoEnderecoEntrega).sendKeys(local);
    }

    public void pesquisar(String endereco){
        this.preencheEndereco(endereco);
        driver.findElement(botaoPesquisar).click();
    }

    public void preencheLocalRetirada(String local){
        driver.findElement(campoLocalRetirada).sendKeys(local);
    }

    public boolean isLocalDropdownVisible(){
        WebElement e = driver.findElement(By.cssSelector(".cdk-overlay-container .dropdown__list open"));
        if (e==null){
            return false;
        } else {
            return true;
        }
    }
}
