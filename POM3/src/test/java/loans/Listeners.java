package loans;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import frameWorkClasses.Utilities;

public class Listeners implements ITestListener
{

	Utilities uts = new Utilities();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("OnStart " +result.getName());
		try {
			uts.takeSnapShot("On test Start " +uts.timereturn()+".png");
			} 
		catch (Exception e)
		{
				e.printStackTrace();
				
		}
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("On Success " +result.getName());
		//
		try {
			uts.takeSnapShot("On test success " +uts.timereturn()+".png");
			} 
		catch (Exception e)
		{
				e.printStackTrace();
				
		}
		
		
		
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" On Failure " +result.getName());
		
		try {
			uts.takeSnapShot("On test Failure " +uts.timereturn()+".png");
			} 
		catch (Exception e)
		{
				e.printStackTrace();
				
		}
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Skipped Test " +result.getName());
		
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		System.out.println(" On Start ");
		
		try {
			uts.takeSnapShot("On test Start " +uts.timereturn()+".png");
			} 
		catch (Exception e)
		{
				e.printStackTrace();
				
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
	System.out.println(" On Finish ");
		
		try {
			uts.takeSnapShot("On test Finish " +uts.timereturn()+".png");
			} 
		catch (Exception e)
		{
				e.printStackTrace();
				
		}
	}

	
}
