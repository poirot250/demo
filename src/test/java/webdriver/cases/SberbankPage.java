package webdriver.cases;

import etalons.SocialNetworks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import webdriver.pages.SberbankPageTest;
import java.util.HashMap;
import java.util.List;

public class SberbankPage {
    HashMap<String, String> socialMap;
    public static WebDriver driver;
    SberbankPageTest mainPageTest = new SberbankPageTest();

    public SberbankPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "hd-ft-region")
    private WebElement region;

    @FindBy(className = "kitt-input__control")
    private WebElement inputField;

    @FindBy (className = "footer__social")
    private WebElement footerSocial;

    public String checkTitle() {
        String title = driver.getTitle();
        return title;
    }

    public Boolean checkRegion() {
        Boolean visibleOfRegion = region.isDisplayed();
        return visibleOfRegion;
    }

    public void clickRegion() {
        region.click();
    }

    public Boolean checkVisibleOfInputField() {
        Boolean visibleOfInputField = inputField.isDisplayed();
        return visibleOfInputField;
    }

    public void enterCountryName(String country) {
        inputField.click();
        inputField.sendKeys(country);
        inputField.sendKeys("\n");
    }

    public String checkCountry() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.textToBePresentInElement(region,"Нижегородская область"));
        String country = region.getText();
        return country;
    }

    public Boolean scrollToDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", footerSocial);
        Boolean visibleOfFooterSocial = footerSocial.isDisplayed();
        return visibleOfFooterSocial;
    }

    public Boolean collectionSocialNetworks(){
        List<WebElement> socialElements = driver.findElements(By.className("footer__social_link"));
        socialMap = new HashMap<String, String>();
        for(int i=0; i<socialElements.size();i++){
            socialMap.put(socialElements.get(i).findElement(By.tagName("span")).getAttribute("class"), socialElements.get(i).getAttribute("href"));
        }
        return (socialMap.size() != 0);
    }

    public Boolean matchSocialsNetworks() {
        SocialNetworks etalonSocialNetworks = new SocialNetworks();
        return socialMap.equals(etalonSocialNetworks.initCollection());
    }

}
