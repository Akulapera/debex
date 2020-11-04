import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirsTest {
    WebDriver dr;

    @BeforeMethod
    public void setUp(){
    dr=new ChromeDriver();
    }

    @Test
    public  void openChromeTest(){
       dr.get("https://www.tel-ran.com/");
    }

     @AfterMethod
    public  void tearDown(){
    dr.quit();
     }
}
