import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RegisterInvalidTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void registerInvalid() {
    driver.get("https://www.opencart.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.cssSelector(".btn-black")).click();
    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).sendKeys("testaravindhan1");
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).sendKeys("#/,.,/.\'!£\"%");
    driver.findElement(By.id("input-lastname")).sendKeys("ARV:@~");
    driver.findElement(By.id("input-email")).sendKeys("aravindhan@gmail.com");
    driver.findElement(By.id("input-country")).click();
    {
      WebElement dropdown = driver.findElement(By.id("input-country"));
      dropdown.findElement(By.xpath("//option[. = 'Barbados']")).click();
    }
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("Password-01");
    driver.findElement(By.cssSelector("footer")).click();
    driver.findElement(By.id("button-register")).click();
  }
}
