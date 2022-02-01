package Leads;

	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

import Demo_GenericUtility.BaseAnnotationClass;
import Demo_PomRepository.CreateLeadPage;
import Demo_PomRepository.HomePage;
import Demo_PomRepository.LeadInfoPage;
import Demo_PomRepository.LeadsPage;

	public class CreateLeadsTest extends BaseAnnotationClass {
		@Test(groups="smokeTest")
		public void createLead() throws Throwable
		{
			HomePage hp = new HomePage(driver);
		   	hp.getLeads().click();
			
			LeadsPage lp = new LeadsPage(driver);
			wLib.waitForElementToBeClickable(driver,lp.getCreateContact() );
			lp.getCreateContact().click();
			
			String lastname = eLib.getDataFromExcel("Lead", 1, 2)+jLib.getRandomNum();
			String company = eLib.getDataFromExcel("Lead", 1, 3)+jLib.getRandomNum();
			
			CreateLeadPage cp = new CreateLeadPage(driver);
			cp.createLead(lastname, company);
			
			LeadInfoPage ln = new LeadInfoPage(driver);
			String actMsg = ln.getSuccessMsg().getText();
			System.out.println(actMsg);
			Assert.assertTrue(actMsg.contains(lastname));
			
		}
	  
		@Test(groups="regressionTest")
		public void createLeadType() throws Throwable
		{
			HomePage hp = new HomePage(driver);
			hp.getLeads().click();
			
			LeadsPage lp = new LeadsPage(driver);
			wLib.waitForElementToBeClickable(driver,lp.getCreateContact() );
			lp.getCreateContact().click();
			
			String lastname = eLib.getDataFromExcel("Lead", 4, 2)+jLib.getRandomNum();
			String company = eLib.getDataFromExcel("Lead", 4, 3)+jLib.getRandomNum();
			String leadsrc = eLib.getDataFromExcel("Lead", 4, 4);
			
			CreateLeadPage cp = new CreateLeadPage(driver);
			cp.createLead(lastname, company,leadsrc);
			
			LeadInfoPage ln = new LeadInfoPage(driver);
			String actMsg = ln.getSuccessMsg().getText();
			System.out.println(actMsg);
			Assert.assertTrue(actMsg.contains(lastname));
			
		}
	}
