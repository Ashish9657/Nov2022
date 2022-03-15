package pom11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy (xpath="//input[@aria-label='Email address or phone number']")      
	private WebElement email;
	//input[@id='email']
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log In']")
	private WebElement Login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		this.driver=driver;
		
	}
	
	public void sendEmailid(String user)
	{
		email.sendKeys(user);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		Login.click();
	}

}
