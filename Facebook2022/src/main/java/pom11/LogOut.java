package pom11;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogOut {
   // private WebDriver driver;
   // private WebDriverWait wait=new WebDriverWait(driver,10);
   
	
	@FindBy (xpath="(//div[@aria-label='Account'])[1]")
	private WebElement account;
	//div[@class='j83agx80 l9j0dhe7']./
	
	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement logout;
	//div[@class='j83agx80 cbu4d94t ew0dbk1b irj2b8pg'])[7]
	
	public LogOut(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAccount()
	{
		account.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
}

