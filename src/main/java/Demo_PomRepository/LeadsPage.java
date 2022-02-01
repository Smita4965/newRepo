package Demo_PomRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LeadsPage {
		

		public LeadsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		@FindAll({@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']"),@FindBy(xpath="//img[@alt='Create Lead...']")})
		private WebElement createContact;


		public WebElement getCreateContact() {
			
			
			return createContact;
		}
		

	}

