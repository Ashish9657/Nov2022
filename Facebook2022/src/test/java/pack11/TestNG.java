package pack11;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pom11.HeaderPage;
import pom11.LogOut;
import pom11.LoginPage;
import pom11.MessageSend;
import util.Utility;

public class TestNG extends  Browser{

	 private WebDriver driver;
     private LoginPage loginPage;
     private HeaderPage headerPage;
     private MessageSend searchBar;
     private LogOut logOut;
     
     
     @BeforeTest
    @Parameters("browser")
     public void launchBrowser(String browserName) {
        System.out.println("launchBrowser");
// 		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
// 	    driver=new ChromeDriver();
 	    if(browserName.equals("Chrome"))
 	    {
 	    	driver=launchChromeBrowser();
 	    }
 	    
 	   if(browserName.equals("Edge"))
	    {
	    	driver=launchEdgeBrowser();
	    }
	    
 	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
     }
	
	@BeforeClass
	public void launchBrowsr()  {
		loginPage=new LoginPage(driver); 
		headerPage=new HeaderPage(driver);
		searchBar=new MessageSend(driver);
		 logOut=new LogOut(driver);
		
	}   
	     
	
		@BeforeMethod
		public void loginApp() throws InterruptedException, EncryptedDocumentException, IOException {
			System.out.println("loginApp");
			driver.get("https://www.facebook.com/");
			
			String email=Utility.getDataFromExcel("Test",1,1);
			String pass=Utility.getDataFromExcel("Test",1,2);
			Thread.sleep(3000);
			loginPage.sendEmailid(email);
			loginPage.sendPassword(pass);
			loginPage.clickOnLogin();
			
		}
		
		@Test
		public void sendMessage() throws InterruptedException {
			System.out.println("sendMessage");
			
			String url=driver.getCurrentUrl();
			Assert.assertEquals(url,"https://www.facebook.com/");
			
			String title=driver.getTitle();
			Assert.assertEquals(title,"Facebook");
			
			searchBar.clickOnMessenger();
			Thread.sleep(3000);
			searchBar.clickOnNarumote();
			Thread.sleep(3000);
			searchBar.writeMessage();
			Thread.sleep(3000);
			searchBar.clickOnSendMessage();
			Thread.sleep(3000);
			searchBar.clickOnCloseMessagepage();
			Thread.sleep(3000);
			//searchBar.clickOnOk();
			//https://www.phenq.in/
		}

			@Test
			public void headerr() throws InterruptedException {
			System.out.println("headerr");
			//Assert.fail();
			
			headerPage.openFacebook();
			headerPage.openHome();
			Thread.sleep(3000);

			headerPage.openWatch();
			Thread.sleep(3000);

			headerPage.openMarketplace();
			headerPage.openGroups();
			headerPage.openMessenger();
			headerPage.openNotification();
			
			Thread.sleep(3000);
			
				
			
		}
		
		@AfterMethod
		public void afterMethod() throws InterruptedException {
			System.out.println("LogOut");
           
			
			logOut.clickOnAccount();
			Thread.sleep(6000);
			logOut.clickOnLogout();
			Thread.sleep(3000);
		}
		
		@AfterClass
		public void afterClass() {
			loginPage=null;
			headerPage=null;
			searchBar=null;
			logOut=null;
			
			
		}
		
		@AfterTest
		public void aftertest() {
			System.out.println("quit");
			driver.quit();
			
			System.gc();
		}


}
