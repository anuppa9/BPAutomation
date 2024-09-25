package modules;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPageObj;
import resources.Base;

public class LoginPage extends Base {
	LoginPageObj lpo;
	
	@BeforeClass
	public void Initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		
		//Open Buyer Portal URL
		driver.get(prop.getProperty("bp_dev_url"));	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void TC001_verifyLoginPageCheck() throws InterruptedException {
		lpo = new LoginPageObj(driver);
		
		//Check login page title
		Assert.assertTrue(driver.getTitle().contains("Sign In"));
		System.out.println("Login page successifully opens.");
		
		//Check email field is visible
		Assert.assertTrue(lpo.getEmailField().isDisplayed());
		System.out.println("email field is visible.");
		
		//Check password field is visible.
		Assert.assertTrue(lpo.getPasswordField().isDisplayed());
		System.out.println("password field is visible.");
		
		//Check SignIn button is visible
		Assert.assertTrue(lpo.getSignInBtn().isDisplayed());
		System.out.println("Sign In buttin is visible.");
	}
	
	@Test(priority=2)
	public void TC002_loginToBuyerPortal() throws InterruptedException{
		lpo = new LoginPageObj(driver);
		
		//Add email and password in the fields
		lpo.getEmailField().sendKeys(prop.getProperty("username01"));
		lpo.getPasswordField().sendKeys(prop.getProperty("password01"));
		lpo.getSignInBtn().click();
		
		//Verify login is successful
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("All Active Market Plans | ANDMORE"));
		System.out.println("Successifully logged in to Buyer Portal.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
