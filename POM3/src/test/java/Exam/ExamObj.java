package Exam;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


import frameWorkClasses.BasePage;

public class ExamObj extends BasePage

{
	//Search Brand Through Main Search 
	
	public void captureMainBrand(String BrandNames)
	{
		EnterText(By.className("search-field"),BrandNames);
		
	}
	
	
	//clear search field
	public void clearSearchField() 
	
	
		{
		 driver.findElement(By.className("search-field")).clear();
		}
	
	//Click Search Icon
	public void clickSearchIcon()
	{
		clickElement(By.xpath("//button[(@class='button search-btn search-icon')]"));
	 
	}
	
	
	//Search Brand 
	
	public void SearcchBrand()
	{
		clickElement(By.xpath("//input[(@name='search')]"));
	 
	}
	

	//Clearing the Notification Message
	public void clickGotIt()
	{
		//Try ..Catch
	
		try 
		{
			if(driver.findElement(By.xpath("//button[contains(@class,'button cookies-banner-module_dismiss-button_24Z98')]")).isDisplayed());
			clickElement(By.xpath("//button[contains(@class,'button cookies-banner-module_dismiss-button_24Z98')]"));
			 
			//System.out.println("Element Found");
		
		}
		catch (NoSuchElementException e)
		{System.out.println("Element Not present");}
		
		//clickElement(By.xpath("//button[contains(@class,'button cookies-banner-module_dismiss-button_24Z98')]"));
	 
	}
	

	//Searching and Selecting Brand 
	
	public void captureBrand(String BrandName)
	{
		EnterText(By.id("_undefined"),BrandName);
	}
	
	
	//Scroll Up
	public void ScrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
		   //	 clickElement(By.xpath("//label[@for='filter_Western Digital_WesternDigital']"));
		
	}
	
	
	//Click Brand 
	public void clickBrand()
	{
		 clickElement(By.xpath("//label[@for='filter_adidas_adidas']"));
		 
		 
	}
	
	//Click Size 
		public void size()
		{
			 clickElement(By.xpath( "//button[contains(text(),'L')]"));		 
			 
		}
	
	public void selectCategory()
	{
		 clickElement(By.xpath("//label[@for='class='shiitake-children']"));
		
	}
	
	
	
	public void clickBrand1()
	{
		 clickElement(By.xpath("//label[@ class='checkbox grid-x align-middle ']"));
		
		 
		 
	}
	
	public String BrandConfirmMsg()
	{
		return getElementText(By.xpath("//p[@class='filter-search-module_no-results_3zVd7']"));
		 
	}
	
	
	 //Confirm item count displayed 
	public String confirmItemCount()
	{
		 
		return getElementText(By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
	}
	
	
	public String confirmZeroCount()
	{  
		
		return getElementText(By.xpath("//div[@class ='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
	}
	
	//Click First Item  
		public void clickFirstItem()
		{
			 
			clickElement(By.xpath("//a[@class='product-anchor product-card-module_product-anchor_TUCBV']"));
			
		}
		
		//Add Item to Cart 
		
		public void clickAddItemToCart()
		{
	 
		    Set<String> allHandles = driver.getWindowHandles();
		    allHandles.remove(allHandles.iterator().next());
		    String lastHandle = allHandles.iterator().next();
		   // System.out.println("Last Window handle" +lastHandle);
		    driver.switchTo().window(lastHandle);
		    clickElement(By.cssSelector(".button:nth-child(2)"));
			
		}
		
		
			public void AddItemToCart()
		{
			 
			 clickElement(By.xpath( "//button[contains(text(),'Add to Cart')]"));		 
			 
		}
		
		//Confirm that The Item has been added to Cart			
		public String CartConfirmMsg()
		{
			return getElementText(By.xpath("//div[@class='cell auto drawer-title drawer-screen-module_drawer-title_3BX9x']"));
			
		}
		
		
		//Close Slider 
		
		public void clickSlider()
		{
			 
			clickElement(By.xpath("//a[@class='drawer-screen-module_icon-right_RiuRe drawer-screen-module_close_3bZkV']"));
			
		}
		
		
		public void clickGoToCart()
		{
			 
			clickElement(By.xpath("//button[@class='button checkout-now dark']"));
			
		}
		
		
		public void selectCartValue()
		{
			 
			clickElement(By.xpath("//select[@id='cart-item_undefined']"));
			
		}
		
		//Changing the Value to 2 
		public Select changeCartValue()
		{
			 
			selectDropDown(By.xpath("//select[@id='cart-item_undefined']"), ("2"));
			Select sDropDown=new Select(getElement(By.xpath("//select[@id='cart-item_undefined']")));
			sDropDown.selectByIndex(1);
			return(sDropDown);
			
						
		}
		
		//Confirming Pricing
		public String ConfirmPricing()
		{
			 
			return getElementText(By.xpath("//span[@class='currency plus currency-module_currency_29IIm']"));
						
		}
		
		
		//clear search field
				public void clear() 
			{
			 driver.findElement(By.id("_undefined")).clear();
			}
				
			
	
		public void clickDailyDeals() 
		{
			
			clickElement(By.xpath("//a[@href='https://www.takealot.com/deals?sort=Relevance']"));
				 
			
		}
	
	
	
	
} 