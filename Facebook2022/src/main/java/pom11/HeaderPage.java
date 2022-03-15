package pom11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath ="//a[@aria-label='Facebook']")
	private WebElement facebook ;

	
	
	@FindBy (xpath ="//a[@aria-label='Home']")
	private WebElement home ;
	
	
	@FindBy (xpath ="//a[@href='/watch/?ref=tab']")//a[@aria-label='Watch']
	private WebElement watch;
	
	
	@FindBy (xpath ="(//a[@aria-label='Marketplace']//span)[1]")
	private WebElement marketplace ;
	
	@FindBy (xpath ="(//a[@aria-label='Groups']//span)[1]")
	private WebElement groups ;
	

	
	@FindBy (xpath ="//div[@aria-label='Menu']")
	private WebElement menu;
	
	@FindBy (xpath ="(//div[@aria-label='Messenger'])[1]")
	private WebElement messenger;
	
	@FindBy (xpath ="//a[@href='/notifications/']")
	private WebElement notifications;
	
	
	@FindBy (xpath ="//div[@aria-label='Account']")
	private WebElement account ;
	
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openFacebook()
	{
		facebook.click();
	}
	
	public void openHome()
	{
		home.click();
	}
	
	public void openWatch()
	{
		watch.click();
	}
	
	public void openMarketplace()
	{
		marketplace.click();
	}
	
	
	public void openMessenger()
	{
		messenger.click();
	}
	
	
	public void openNotification()
	{
		notifications.click();
	}
	
	
	public void openAccount()
	{
		account.click();
	}
	
	public void openGroups()
	{
		groups.click();
	}
	

	
	public void openMenu()
	{
		menu.click();
	}
}
