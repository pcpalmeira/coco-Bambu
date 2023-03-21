package palmeira.test;
 
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public abstract class BaseTest {
 
    protected static WebDriver driver;
    private static final String URL_BASE = "googlr.com";
    private static final String CAMINHO_DRIVER = "src/test/java/palmeira/resource/chromedriver -v 111.0.5563.64.exe";
 
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
 
    }
 
    
    
}