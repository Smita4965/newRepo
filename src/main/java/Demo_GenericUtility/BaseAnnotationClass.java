package Demo_GenericUtility;
	
	import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;

import Demo_PomRepository.HomePage;
import Demo_PomRepository.LoginPage;


	public class BaseAnnotationClass {
		
		/*object creation*/
		public ExcelUtility eLib = new ExcelUtility();
		public FileUtility fLib = new FileUtility();
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public WebDriver driver=null;
		public static WebDriver sDriver = null;
		
		
		@BeforeSuite(groups = {"smokeTest","regressionTest"})
		public void configBS()
		{
			System.out.println("===Connect to Database===");
		}
		
		@BeforeClass(groups = {"smokeTest","regressionTest"})
		public void configBC() throws IOException 
		{
			System.out.println("===Launch Browser===");
			String BROWSER = fLib.readDatafromPropertyfile("browser");
			String URL = fLib.readDatafromPropertyfile("url");
			if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			wLib.maximizeWindow(driver);
			wLib.waitForpageLoad(driver);
			driver.get(URL);
			sDriver=driver;
			
			
		}

		@BeforeMethod(groups = {"smokeTest","regressionTest"})
		public void configBM() throws Throwable
		{
			System.out.println("===Login to App===");
			String USERNAME = fLib.readDatafromPropertyfile("username");
			String PASSWORD = fLib.readDatafromPropertyfile("password");
			LoginPage login = new LoginPage(driver);
			login.loginToApp(USERNAME, PASSWORD);
			
		}
		
		@AfterMethod
		public void configAM()
		{
			System.out.println("===Logout from App===");
			HomePage home = new HomePage(driver);
			home.Logout();
		}
		
		@AfterClass
		public void configAC()
		{
			System.out.println("===Close the Browser===");
			wLib.CloseBrowser(driver);
		}
		
		@AfterSuite
		public void configAS()
		{
			System.out.println("===Disconnect from Database===");
		}
		

	}
