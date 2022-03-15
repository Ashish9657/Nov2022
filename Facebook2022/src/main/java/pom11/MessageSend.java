package pom11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageSend {

	
	@FindBy (xpath="(//div[@aria-label='Messenger'])[1]")
	private WebElement messenger;
	
	@FindBy (xpath="//span[text()='Narendra Mote']")
	private WebElement narumote;

	@FindBy (xpath="//div[@aria-label='Message']")
	private WebElement writeMessage;

	@FindBy (xpath="//div[@aria-label='Press Enter to send']")
	private WebElement sendMessage;

	@FindBy (xpath="//div[@aria-label='Close chat']")
	private WebElement closeMessagepage;

	@FindBy (xpath="(//div[@aria-label='OK'])[1]")
	private WebElement clickonok;

	public MessageSend(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickOnMessenger()
	{
		messenger.click();
	}
	
	public void clickOnNarumote()
	{
		narumote.click();
	}
	
	public void writeMessage()
	{
		writeMessage.sendKeys("Hi");
	}
	
	public void clickOnSendMessage()
	{
		sendMessage.click();
	}
	
	public void clickOnCloseMessagepage()
	{
		closeMessagepage.click();
	}
	
	public void clickOnOk()
	{
		clickonok.click();
	}
	

	


}
