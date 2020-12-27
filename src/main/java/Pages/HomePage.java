package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.login")
	WebElement signInBtn;
	
	public void NavigateToSignup() {
		clickButton(signInBtn);
	}
	
}

