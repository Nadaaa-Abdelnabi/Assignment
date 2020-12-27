package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends PageBase{

	public OrdersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.button-exclusive.btn.btn-default")
	WebElement orderHistoryBtn;
	
	@FindBy(xpath="//tr/td[2]")
	public WebElement Date;
	
	@FindBy(id="block-history")
	public List<WebElement> orderDetails;
	
	public void OrderList() {
		clickButton(orderHistoryBtn);
		
		
	}
	
	
	
	
	
	
	
}
