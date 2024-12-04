package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

		public MyAccountPage(WebDriver driver) {
			super(driver);
		}
		
		//@FindBy(xpath="//h2[text()='My Account')]") WebElement msgHeading;
		@FindBy(xpath="//*[@id='content']/h2[1]") WebElement msgHeading;
		
		@FindBy(xpath="//div[@class='list-group-item']//a[text()='Logout']")WebElement linkLogout;
		
		public boolean isMyAccountPageExists()
		{
			try 
			{
				return (msgHeading.isDisplayed());	//if it is dsiplayed return true
			}
			catch (Exception e)
			{
				return false;
			}
		}
		
		
		public void clickLout()
		{
			linkLogout.click();
		}
		
}
