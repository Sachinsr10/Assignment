package pageObjects;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BaseTest;

public class PageObjects extends BaseTest{

	Logger logger = Logger.getLogger(PageObjects.class.getName());

	public void clickOnSignIn(){
		logger.info("Click on sign in");
		WebElement element=driver.findElement(By.xpath("//a[@class='login']"));
		clickVisibleElement(element);
	}
	public void enterUserNameAndPwd(String userName,String password){
		logger.info("entering user name");
		WebElement user=driver.findElement(By.xpath("//input[@id='email']"));
		user.sendKeys(userName);

		WebElement pwd=driver.findElement(By.xpath("//input[@id='passwd']"));
		pwd.sendKeys(password);

	}
	public void clickOnSignInBtn(){
		logger.info("Click on sign in button");
		WebElement element=driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		clickVisibleElement(element);	
	}
	public void clickOnCatg(String catg){
		logger.info("Selecting category");
		WebElement element=driver.findElement(By.xpath("(//a[@title='"+catg+"'])[2]"));
		clickVisibleElement(element);	
	}
	public void selectItem(){
		logger.info("Selecting item");
		WebElement element=driver.findElement(By.xpath("//a[@class='product_img_link']"));
		Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement element1=driver.findElement(By.xpath("//a[@class='button lnk_view btn btn-default']"));
        
		clickVisibleElement(element1);		
	}
	public void addToCart(String qty,String size) throws Exception{
		logger.info("entering quantity");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement quantity=driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
		clickVisibleElement(quantity);
		quantity.clear();
		quantity.sendKeys(qty);
		
		logger.info("entering size");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sizeXpath=driver.findElement(By.xpath("(//div[@class='attribute_list'])[1]"));
		clickVisibleElement(sizeXpath);
		WebElement Xpath=driver.findElement(By.xpath("//select[@class='form-control attribute_select no-print']//option[contains(text(),'"+size+"')]"));
		clickVisibleElement(Xpath);
		
		logger.info("Clicking on Add to cart");
		WebElement element=driver.findElement(By.xpath("//p[@id='add_to_cart']//button"));
		clickVisibleElement(element);
		
		WebElement element1=driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
		logger.info("message "+element1.getText());
		teardown();
		
	}
}
