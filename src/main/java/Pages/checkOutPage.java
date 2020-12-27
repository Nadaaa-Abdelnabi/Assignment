package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends PageBase{

	public checkOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement proceedBtn1;
	
	@FindBy(xpath="//form/p/button")
	WebElement proceedBtn2;
	
	@FindBy(id="uniform-cgv")
	WebElement terms;
	
	@FindBy(xpath="//p/button")
	WebElement proceedBtn3;
	
	@FindBy(xpath="//*[@id=\"columns\"]/div[1]/span[2]")
	public WebElement PaymentTab;
	
	public void checkout() {
		
	clickButton(proceedBtn1);
	clickButton(proceedBtn2);
	checkbox(terms);
	clickButton(proceedBtn3);
	}
	
}
