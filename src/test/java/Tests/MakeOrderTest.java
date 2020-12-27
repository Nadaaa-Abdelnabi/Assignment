package Tests;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.AuthenticationPage;
import Pages.BlousesPage;
import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.OrdersPage;
import Pages.PaymentPage;
import Pages.checkOutPage;

public class MakeOrderTest extends TestBase{

	@DataProvider(name="TestData")
	public static Object [][]userdata(){
		return new Object[][] {
			{"Nada", "Ali", "123456", "3,maadi,motheda", "maddiCity", "01098943541","00000", "aliasAddress", "26", "1994", "4", "vodafone", "5", "United States"}
		};
	}
	

	@Test(priority =1)
	public void HomePage() {
		Pages.HomePage HomePageObj = new HomePage(driver);
		HomePageObj.NavigateToSignup();
		assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"), " Naviagted SUCCESSFULLY to signup page");

	}

	@Test(priority = 2 ,dependsOnMethods = "HomePage")
	public void Signup() {
		Random rnd=new Random();
		AuthenticationPage AuthenticationPageObj = new AuthenticationPage(driver);
		AuthenticationPageObj.EmailSubmit("nadaabdo" +rnd.nextInt(9999)+"@gmail.com");
		//assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")," Naviagted SUCCESSFULLY to Create Account page");
	}


	@Test(priority = 3 ,dependsOnMethods = "Signup",dataProvider = "TestData")
	public void CreateAccount(String fName,String LName , String YourPassword ,String address,String Yourcity , String phone , String zip ,String aliasAddress , String day , String year ,String month ,String company ,String statee, String cntry ) {
		CreateAccountPage CreateAccountPageObj = new CreateAccountPage(driver);
		CreateAccountPageObj.AddAccountData( fName, LName ,  YourPassword , address, Yourcity ,  phone ,  zip , aliasAddress ,  day ,  year , month , company , statee,  cntry );
		assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"), " Your account is ctreated SUCCESSFULLY");

	}

	@Test(priority = 4 ,dependsOnMethods = "CreateAccount")
	public void NavigateToSubCategory() {
		MyAccountPage MyAccountPageObj = new MyAccountPage(driver);
		MyAccountPageObj.NavigateToBlouses();
		assertTrue(driver.getTitle().contains("Blouses"),"You navigated SUCCESSFULLY to blouse subcategory");
	}
	
	@Test(priority = 5 ,dependsOnMethods = "NavigateToSubCategory")
	public void NavigateToCart(){
		BlousesPage BlousesPageobj = new BlousesPage(driver);
		BlousesPageobj.addToCart();
		assertTrue(driver.getTitle().contains("Order"),"You navigated SUCCESSFULLY to Checkout");

	}
	
	@Test(priority = 6 ,dependsOnMethods = "NavigateToCart")
	public void ProceedToCheckOut() {
		checkOutPage checkOutPageobj = new checkOutPage(driver);
		checkOutPageobj.checkout();
		assertTrue(checkOutPageobj.PaymentTab.getText().contains("payment"),"You navigated SUCCESSFULLY to payment tab");
  //      System.out.println(checkOutPageobj.PaymentTab.getText());
		
	}
	
	@Test(priority = 7,dependsOnMethods = "ProceedToCheckOut")
	public void payment() {
		PaymentPage PaymentPageobj = new PaymentPage(driver);
		PaymentPageobj.PaymentWay();
		assertTrue(driver.getCurrentUrl().contains("id_order"),"You navigated SUCCESSFULLY to payment tab");
		
	}
	
	@Test(priority = 8,dependsOnMethods = "payment")
	public void Confirm_OrderPlaced() {
		OrdersPage OrderPageObj = new OrdersPage(driver);
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		OrderPageObj.OrderList();
		Assert.assertEquals(OrderPageObj.orderDetails.size(),1);
		
	}
}
