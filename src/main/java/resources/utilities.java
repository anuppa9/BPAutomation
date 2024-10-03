package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilities extends Base{
	
	public utilities(WebDriver driver) {
		this.driver = driver;
	}
	
	//To scroll web page at specific web element location
	public WebElement scrollToElement(WebElement element) throws InterruptedException {
		WebElement scrollText = element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollText);
		Thread.sleep(4000);
		return element;
	}
	
	//To scroll the web page to the top
	public void scrollToTop() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(4000);
	}
	
	//To scroll element into the view
	public void scrollIntoView(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//To scroll the webElement into middle of the page
	public void scrollElementIntoMiddle (WebElement element) throws InterruptedException {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(200);
	}
	
	//Wit for page to load
	 public void waitForPageLoad() { 
		 new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
		  @Override 
		  public Boolean apply(WebDriver wd) { return ((JavascriptExecutor)
			 wd).executeScript("return document.readyState").equals("complete"); 
	  	}
	  }); 
	}
	
}
