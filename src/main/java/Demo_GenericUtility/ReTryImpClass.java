package Demo_GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryImpClass implements IRetryAnalyzer{

	int count=0;
	int reTryLimit=3;

	public boolean retry(ITestResult result)
	{
		if(count<reTryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	}

