package pack11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom11.FriendRquest;
import pom11.LoginPage;

public class ExeFriendReq {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
        LoginPage loginpage=new LoginPage(driver);
		
		//inpage.sendPassword();
		//loginpage.clickOnLogin();

		FriendRquest friendRquest=new FriendRquest(driver);
	
		friendRquest.clickOnSearchBar();
		friendRquest.clickOnSelectName();
		//friendRquest.moveOnNameImage();
		friendRquest.clickOnAddFriend();
		Thread.sleep(3000);
		friendRquest.clickOnCanclFriendRequest();
		
	
	}

}
