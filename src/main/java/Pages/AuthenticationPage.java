package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends PageBase{

	public AuthenticationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "email_create")
	WebElement EmailTxt;
	
	@FindBy(id = "SubmitCreate")
	WebElement submit;
	
	public void EmailSubmit(String Email) {
		setTextElementText(EmailTxt, Email);
		clickButton(submit);
	}
	
	

}
