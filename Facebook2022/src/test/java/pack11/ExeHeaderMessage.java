package pack11;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom11.HeaderPage;
import pom11.LogOut;
import pom11.LoginPage;
import pom11.MessageSend;

public class ExeHeaderMessage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		LoginPage loginpage=new LoginPage(driver);
		
//		loginpage.sendEmailid();
//		loginpage.sendPassword();
		loginpage.clickOnLogin();
		
		HeaderPage headerPage=new HeaderPage(driver);
		
		headerPage.openFacebook();
		headerPage.openHome();
		Thread.sleep(3000);
		headerPage.openWatch();
		headerPage.openMarketplace();
		headerPage.openGroups();
		
		//headerPage.openMenu();
		headerPage.openMessenger();
		headerPage.openNotification();
		headerPage.openAccount();
		MessageSend searchBar=new MessageSend(driver);
	
		searchBar.clickOnMessenger();
		Thread.sleep(3000);
		searchBar.clickOnNarumote();
		searchBar.writeMessage();
		searchBar.clickOnSendMessage();
		searchBar.clickOnCloseMessagepage();
		searchBar.clickOnOk();
		
		LogOut logOut=new LogOut(driver);
		
		Thread.sleep(3000);
		logOut.clickOnAccount();
		Thread.sleep(3000);
		logOut.clickOnLogout();
		
	}

}
