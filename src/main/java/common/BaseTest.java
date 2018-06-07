package common;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {


	public static WebDriver driver = null;
	public static WebDriverWait waitVar = null;

	public static String baseURL = "http://automationpractice.com/index.php";


	public void createDriver() throws MalformedURLException,
	InterruptedException {
		String exePath=System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(baseURL);

		waitVar = new WebDriverWait(driver, 15);
	}

	public void clickVisibleElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	public void sendKeys(String value){

	}
	public void teardown() {
		driver.quit();
	}

	public void ishomepageDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText("Sign in")));

		driver.findElement(By.linkText("Sign in")).isDisplayed();
		driver.findElement(By.className("marketing-section-signup"))
		.isDisplayed();
	}

	public void clickSigninLink() {
		driver.findElement(By.linkText("Sign in")).click();
	}

	public void isloginsectionDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By
				.className("auth-form-body")));
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By
				.name("commit")));
	}

}
