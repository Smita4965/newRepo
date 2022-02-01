package Demo_PomRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {
		WebDriver driver;
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(linkText = "Leads")
		private WebElement Leads;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement image;
		
		@FindBy(xpath = "//a[.='Sign Out']")
		private WebElement signout;
		
		public WebElement getLeads() {
			return Leads;
		}

		public WebElement getImage() {
			return image;
		}

		public WebElement getSignout() {
			return signout;
		}

		public void Logout()
		{
			Actions act = new Actions(driver);
			act.moveToElement(image).perform();
			signout.click();
			
			
		}

		
		}
		
		
