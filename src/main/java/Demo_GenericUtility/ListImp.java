package Demo_GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp implements ITestListener {
public void onTestFailure(ITestResult result)
{
  String failedTestName=result.getMethod().getMethodName();
  
 EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseAnnotationClass.sDriver);
 File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
 String systemDate = new Date().toString().replace(":","_").replace(" ","_");
 File dest = new File("./screenshot/"+failedTestName+"_"+systemDate+".png");
 try
 {
	 FileUtils.copyFile(srcFile,dest);
 }
 catch(IOException e)
 {
	
 }
}
}
