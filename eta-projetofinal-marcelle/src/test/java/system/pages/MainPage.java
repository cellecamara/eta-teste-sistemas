package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import static system.pages.URL.MAIN_PAGE;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By locationField = By.id("location-typeahead-home-input");
    private By searchButton = By.cssSelector("button.be.bf.bg.bh.bi.en.ag.bk.bl.b6.bm.bn.bo.eo.ep.br.bs.c1.eq");
    private By selectedLocation = By.cssSelector("header > div.dd.dm > div > a.bx.by.bg.c9.b3.ca.cb.cc.br.bs.ag.as.bk.bh.ek.dl.b6 > div.h3.an.al");
    private By placeCard = By.cssSelector("div.gk.kl.hw.go.gp.hx > div:first-child");
    private By locationList = By.id("location-typeahead-home-menu");
    private By deliveryInfo = By.id("#wrapper > header > div.dd.dm > div > a.bx.by.bg.c9.b3.ca.cb.cc.br.bs.ag.as.bk.bh.ek.dl.b6");

    public MainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void accessPage() {
        driver.get(MAIN_PAGE);
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main-content")));
        } catch (Exception e) {
        }
    }

    public String getSelectedLocation(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryInfo));
        } catch (Exception e) {
        }
        WebElement location = driver.findElement(selectedLocation);
        System.out.println(location.getText());
        System.out.println(driver.getCurrentUrl());
        return location.getText();


//        //WebElement location = driver.findElement(By.cssSelector("header > div.dd.dm > div > a.bx.by.bg.c9.b3.ca.cb.cc.br.bs.ag.as.bk.bh.ek.dl.b6 > div.h3.an.al"));
//        WebElement location = driver.findElement(currentLocation);
//        System.out.println(location.getText());
//        return location.getText();
    }
    
    public void fillInAddress(String local){
        driver.findElement(locationField).sendKeys(local,Keys.ENTER);
    }

    public void selectLocationFromResults(){
        //driver.findElement(locationList)
    }

    public void clickSearch(){
        wait = new WebDriverWait(driver, 15);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            driver.findElement(searchButton).click();
            System.out.println(driver.getCurrentUrl());
        } catch (Exception e) {
        }

    }

}
