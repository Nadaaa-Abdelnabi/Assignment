package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	Actions action;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		 action= new Actions(driver);
	}
	@FindBy(css = "a.sf-with-ul")
	WebElement womenCategory;
	
	@FindBy(xpath ="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	WebElement Blouses;
	
	public void NavigateToBlouses() {
		
		action.moveToElement(womenCategory).perform();
		clickButton(Blouses);
		
	}
	
	

}
