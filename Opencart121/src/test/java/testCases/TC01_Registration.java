package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import testBase.BaseClass2;

public class TC01_Registration extends BaseClass2{

	//@Test(groups={"Regression","Master"})
	@Test
	public void TestReg() {
		
		logger.info("****Starting TC01_Registration********");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on the My Account Link");
		hp.clickRegister();
		logger.info("Clicked on the Register Link****");

		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer details for Registration");
		ap.setFirstName(randomString());
		ap.setLastName(randomString());
		ap.setEmail(randomString() + "@gmail.com");
		ap.setTelphone(randomNumber());
		
		String password=randomAlphanumaric();
		ap.setPassword(password);
		ap.setConfirmPassword(password);
		ap.setPrivacyPolicy();
		ap.clickContinue();
		logger.info("Validating the expected message");
		String confmsg = ap.getconfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		
		{
			logger.error("Test Failed");
			logger.debug("Debugs logs");
			Assert.assertTrue(false);
		}
		
		}catch (Exception e) {
			
			Assert.fail();
		}
		
		logger.info("****Finished TC01_Registration********");

	}

}	

