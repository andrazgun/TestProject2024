package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser extends Browser{
    EdgeBrowser(){
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
    }
}
