package webdriver.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.SetProperties;
import java.util.concurrent.TimeUnit;

public class Driver {
    public WebDriver driver;
    SetProperties prop = new SetProperties();

    public WebDriver setup(String url){
        System.setProperty(prop.getDriver(), prop.getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
}
