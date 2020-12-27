package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends PageBase{
	WebDriverWait wait;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		wait=new WebDriverWait(driver, 60);
	}
	

	@FindBy(id="customer_firstname")
	WebElement FirstNameTxt;

	@FindBy(id="customer_lastname")
	WebElement LastNameTxt;

	@FindBy(id="passwd")
	WebElement PasswordTxt;

	@FindBy(id="days")
	WebElement days;
	Select Add_day = new Select(days);

	@FindBy(id="months")
	WebElement months;
	Select Add_month= new Select(months);
	
	@FindBy(id="years")
	WebElement years;
	Select Add_years= new Select(years);

	
	@FindBy(id="optin")
	WebElement SpecialOfferCheck;
	
	@FindBy(id="firstname")
	WebElement Address_firstName;
	
	@FindBy(id="lastname")
	WebElement Address_lastname;
	
	@FindBy(id="company")
	WebElement Address_company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	Select Your_State=new Select(state);
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement Your_country;
	Select country = new Select(Your_country);
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement alias_Address;
	
	@FindBy(id="submitAccount")
	WebElement submitAccount;
	
	public void AddAccountData(String fName,String LName , String YourPassword ,String address,String Yourcity , String phone , String zip ,String aliasAddress , String day , String year ,String month ,String company ,String statee, String cntry ) {
		
		setTextElementText(FirstNameTxt, fName);
		setTextElementText(LastNameTxt, LName);
		setTextElementText(PasswordTxt, YourPassword);
		setTextElementText(address1, address);
		setTextElementText(city, Yourcity);
		setTextElementText(Address_company, company);
		checkbox(SpecialOfferCheck);
		Add_day.selectByValue(day);
		Add_month.selectByValue(month);
		Add_years.selectByValue(year);
		country.selectByVisibleText(cntry);
	//	wait.until(ExpectedConditions.visibilityOf(state));
		Your_State.selectByValue(statee);
		setTextElementText(postcode, zip);
		setTextElementText(mobile, phone);
		setTextElementText(alias_Address, aliasAddress);
		clickButton(submitAccount);
		


		

		

		
	}
	
	
} 
