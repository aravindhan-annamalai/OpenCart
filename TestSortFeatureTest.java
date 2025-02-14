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
public class TestSortFeatureTest {
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
  public void testSortFeature() {
    driver.get("https://www.opencart.com/");
    driver.findElement(By.cssSelector(".btn-link")).click();
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).sendKeys("aravindhantest04@gmail.com");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("Password-01");
    driver.findElement(By.cssSelector(".btn-lg:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".nav > li:nth-child(3) > a")).click();
    driver.findElement(By.id("input-sort")).click();
    {
      WebElement dropdown = driver.findElement(By.id("input-sort"));
      dropdown.findElement(By.xpath("//option[. = 'Recently Added']")).click();
    }
    assertThat(driver.findElement(By.id("input-sort")).getText(), is("Recently Updated\\\\nRecently Added\\\\nRating\\\\nName\\\\nPrice"));
  }
}
