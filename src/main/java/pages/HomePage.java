package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements( driver,this);
	}

@FindBy(xpath ="//span[text()='My Account']")
private WebElement myAccountPage;
@FindBy(linkText ="Login")
private WebElement LoginOption;

 public void clickOnMyACcount()
 {
	 myAccountPage.click();
 }
 
 public LoginPage SelectLoginOption() {
	 LoginOption.click();
	 return new LoginPage(driver);
 }
}
