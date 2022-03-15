package pack11;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom11.FriendRquest;
import pom11.LogOut;
import pom11.LoginPage;
import util.Utility;


public class TestNGFriend extends Browser {
	private WebDriver driver;
	private LoginPage loginPage;
	private FriendRquest friendRquest;
	private LogOut logOut;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	 public void launchBrowser(String browserName) {
		
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("launchBrowser");
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
	public void createObject()  {
		System.out.println("createObject");
		 loginPage=new LoginPage(driver);
		 friendRquest =new FriendRquest(driver);
		 logOut=new LogOut(driver);
		 
	}   

	
		@BeforeMethod
		public void loginApp() throws  IOException, InterruptedException {
			System.out.println("loginApp");
			driver.get("https://www.facebook.com/");

			String user=Utility.getDataFromExcel("Test",6,0);
			
			String pass=Utility.getDataFromExcel("Test",6,1);
		   
		    Thread.sleep(3000);
		    loginPage.sendEmailid(user);
		    loginPage.sendPassword(pass);
		    loginPage.clickOnLogin();;
		    
		    
		}
		 @Test
		 public void verifyFriend() throws InterruptedException
		 {
			 testID="101";
			 System.out.println("verifyFriendRequest");
		    friendRquest.clickOnSearchBar();
		    Thread.sleep(3000);
		    friendRquest.clickOnSelectName();
		    Thread.sleep(3000);
            friendRquest.clickOnAddFriend();
		    Thread.sleep(3000);
		    friendRquest.clickOnCanclFriendRequest();
		    
		 }
		 
		 @AfterMethod
		 public void logoutApp(ITestResult result) throws IOException, InterruptedException 
		 {
			 if(ITestResult.FAILURE==result.getStatus()) {
				 Utility.screenshot(driver, testID);
			 }
			 
			 System.out.println("logoutApp");
	            
	            
	            logOut.clickOnAccount();
	            Thread.sleep(3000);
	            logOut.clickOnLogout();
	            Thread.sleep(3000);
		 }
		 
		 @AfterClass
		 public void nullObject() {
			 System.out.println("nullObject");
			 loginPage=null;
			 friendRquest=null;
			 logOut=null;
			 
		}
		 
		 @AfterTest
		 public void closeBrowser()
		 {
			 System.out.println("quit");
			 driver.quit();
			 
			 System.gc();
		 }
}
//<class name="pack11.TestNG"/>
