package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC02_LoginTest extends BaseClass {

	@Test (groups="Sanity")
	public void verify_Login() {
		
	
		try {

			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MyAccount Page
			MyAccountPage mp = new MyAccountPage(driver);
			Thread.sleep(2000);
			boolean taget = mp.isMyAccountPageExists();
			//Assert.assertEquals(taget, true, "Login Failed");
			 Assert.assertTrue(taget); //use this line ot above line
		} catch (Exception e) {
			Assert.fail();
		}
		
	}

}
