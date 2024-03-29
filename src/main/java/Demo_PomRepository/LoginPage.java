package Demo_PomRepository;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(name = "user_name")
		private WebElement username;
		
		@FindBy(name = "user_password")
		private WebElement password;
		
		@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']") })
		private WebElement loginBtn;
		
		public WebElement getUsername()
		{
			return username;
		}
		
		public WebElement getPassword() 
		{
			return password;
		}
		
		public WebElement getLoginBtn()
		{
			return loginBtn;
		}
		/**
		 * This method is used for Login to App
		 * @param un
		 * @param pwd
		 */
		public void loginToApp(String un ,String pwd) // Rule 5 iddentify  the reusable business library and implement them in same POM class
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
		}

	}
