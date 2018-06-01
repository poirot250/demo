package webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.driver.Driver;
import webdriver.cases.SberbankPage;

public class SberbankPageTest {

    public WebDriver driver;
    public SberbankPage mainPage;

    @BeforeClass
    public void setup(){
        Driver getDriver = new Driver();
        this.driver = getDriver.setup("http://www.sberbank.ru/ru/person");
        mainPage = new SberbankPage(driver);
    }

    @Test(priority=0)
    public void checkTitle(){
        Assert.assertEquals("«Сбербанк» - Частным клиентам", mainPage.checkTitle());
    }

    @Test(priority=1)
    public void checkVisibleRegion(){
        Boolean trueRegion = true;
        Assert.assertEquals(mainPage.checkRegion(), trueRegion);
    }

    @Test(priority=2)
    public void clickRegion(){
        mainPage.clickRegion();
        Boolean trueInputField = true;
        Assert.assertEquals(trueInputField, mainPage.checkVisibleOfInputField());
    }

    @Test(priority=3)
    public void setCountryName(){
        mainPage.enterCountryName("Нижегородская область");
    }

    //@Test(dependsOnMethods={"clickRegion", "setCountryName"})
    @Test(priority=4)
    public void checkCountry(){
        Assert.assertEquals("Нижегородская область", mainPage.checkCountry());
    }

    @Test(priority=5)
    public void scrollDownPage(){
        mainPage.scrollToDown();
        Boolean trueFooterSocial = true;
        Assert.assertEquals(trueFooterSocial, mainPage.scrollToDown());
    }

    @Test(priority=6)
    public void collectingSocialNetworks(){
        Boolean trueCollectionSocialNetworks = true;
        Assert.assertEquals(trueCollectionSocialNetworks, mainPage.collectionSocialNetworks());
    }

    //@Test(dependsOnMethods={"collectingSocialNetworks"})
    @Test(priority=7)
    public void matchingSocialNetwork(){
        mainPage.matchSocialsNetworks();
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }
}
