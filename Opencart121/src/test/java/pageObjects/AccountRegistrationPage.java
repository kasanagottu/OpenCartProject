package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfimPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkbxPrivacy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath ="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msgconfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelphone(String telphone) {
		txtTelephone.sendKeys(telphone);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfimPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkbxPrivacy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getconfirmationMsg()
	{
		try {
			return(msgconfirmation.getText());
		}catch (Exception e) {
			return(e.getMessage());
		
		}
	}
}
