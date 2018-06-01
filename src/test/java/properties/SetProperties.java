package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetProperties{
    private String DRIVER;
    private String PATH;

    public SetProperties(){
        Properties credits = new Properties();
        try{
            credits.load(new FileInputStream(new File("src\\test\\resources\\drivercredits.properties")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = credits.getProperty("driver");
        PATH = credits.getProperty("path");
    }

    public String getDriver() {
        return DRIVER;
    }

    public String getPath() {
        return PATH;
    }
}