package step;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Lo1 {
	
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driver=DF.gD();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyACcount();
		loginpage= homepage.SelectLoginOption();
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();	
		}
	
//	@When("user enters valid email address {string} into email field")
//	public void user_enters_valid_email_address_into_email_field(String emailText) {
//	  
//		 //loginpage= new LoginPage(driver);
//		loginpage.enterEmaliAddress(emailText);
//		//driver.findElement(By.id("input-email")).sendKeys(emailText);
//	}
//
//	@When("User enters valid password {string} into password field")
//	public void user_enters_valid_password_into_password_field(String passwordText) {
//		loginpage.enterPasswordAddress(passwordText);
//		
//		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
//	}


	@When("^user enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	  
		 //loginpage= new LoginPage(driver);
		loginpage.enterEmaliAddress(emailText);
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
	}

	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginpage.enterPasswordAddress(passwordText);
		
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	}

	
	
	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		accountpage =loginpage.clickloginbutton();
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		//AccountPage accountpage = new AccountPage(driver);
		
		Assert.assertTrue(accountpage.displayStatusOfeditAccountInformation());
	}

	@When("user enters invalid email address  into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		//loginpage = new LoginPage(driver);
		loginpage.enterEmaliAddress(CommonUtils.getEmailWithTimeStamp());
	
		//driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailWithTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasswordText) {
		
		loginpage.enterPasswordAddress(invalidpasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(invalidpasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
			
		Assert.assertTrue(loginpage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user dont enters email address into email field")
	public void user_dont_enters_email_address_into_email_field() {
		
		//loginpage = new LoginPage(driver);
		loginpage.enterEmaliAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
		
		//int a = 12/0;
	}

	@When("user dont enters password into password field")
	public void user_dont_enters_password_into_password_field() {
		
		loginpage.enterPasswordAddress("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}


}









//@Before
//public void setUp()
//{
//	
//driver = new ChromeDriver();
//driver.manage().deleteAllCookies();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.get("https://tutorialsninja.com/demo/");
//
//}
//
//@After
//public void tearDown()
//{
//	driver.quit();
//}
