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
public class UntitledTest {
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
  public void untitled() {
    driver.get("https://www.opencart.com/index.php?route=common/home");
    driver.findElement(By.cssSelector(".btn-black")).click();
    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).sendKeys("testaravindhan2");
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).sendKeys("test");
    driver.findElement(By.id("input-lastname")).sendKeys("aravindhan");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).sendKeys("testaravindhan04@gmail.com");
    driver.findElement(By.id("input-password")).click();
    {
      WebElement element = driver.findElement(By.id("button-captcha"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("input-password")).sendKeys("Password-01");
    driver.findElement(By.id("button-register")).click();
  }
}
