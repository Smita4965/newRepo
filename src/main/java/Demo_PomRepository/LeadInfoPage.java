package Demo_PomRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LeadInfoPage {
		public LeadInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement successfullMsg;
		
		public WebElement getSuccessMsg() {
			return successfullMsg;
		}
	}

