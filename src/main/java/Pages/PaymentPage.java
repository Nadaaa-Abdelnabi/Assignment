package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a.bankwire")
	WebElement bankWireBtn;
	
	
	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement confirmBtn;
	
	public void PaymentWay() {
		
		clickButton(bankWireBtn);
		clickButton(confirmBtn);

	}

}
