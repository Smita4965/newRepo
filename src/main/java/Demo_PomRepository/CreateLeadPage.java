package Demo_PomRepository;

	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import Demo_GenericUtility.WebDriverUtility;

	

	public class CreateLeadPage extends WebDriverUtility{		
		public CreateLeadPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@name='lastname']")
		private WebElement lastname;
		
		@FindBy(xpath="//input[@name='company']")
		private WebElement company;
		
		@FindBy(xpath="//select[@name='leadsource']")
		private WebElement leadsrc;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		

		public WebElement getLastname() {
			return lastname;
		}

		public WebElement getCompany() {
			return company;
		}

		public WebElement getLeadsrc() {
			return leadsrc;
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void createLead(String lname,String comp)
		{
			lastname.sendKeys(lname);
			company.sendKeys(comp);
			saveBtn.click();
		}
		public void createLead(String lname,String comp,String leadSrc)
		{
			lastname.sendKeys(lname);
			company.sendKeys(comp);
			select(leadsrc, leadSrc);
			saveBtn.click();
		}
		

	}
