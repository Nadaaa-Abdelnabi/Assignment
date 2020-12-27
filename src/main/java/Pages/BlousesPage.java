package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends PageBase {

	Actions action;
	
	public BlousesPage(WebDriver driver) {
		super(driver);
		action= new Actions(driver);
	}
	
	
	@FindBy(xpath="//ul/li/div/div[1]/div/a[1]/img")
	WebElement blouseImg;

	@FindBy(xpath="//ul/li/div/div[1]/div/a[2]")
	WebElement QickViewBtn;

	@FindBy(xpath="//ul/li/div/div[2]/div[2]/a[1]")
	WebElement AddToCartBtn;

	@FindBy(xpath="//div[2]/div[4]/a")
	WebElement CheckOutBtn;

	public void addToCart() {
		action.moveToElement(blouseImg).perform();
		clickButton(AddToCartBtn);
		clickButton(CheckOutBtn);

	}



}
