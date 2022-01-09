import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestClass1 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
    	capsHashtable.put("build", "flipkrt test");
		capsHashtable.put("name", "Thread 1");
		mainTestClass r1 = new mainTestClass();
		try {
			r1.executeTest(capsHashtable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
class TestClass2 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "firefox");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 2");
		mainTestClass r2 = new mainTestClass();
    	try {
			r2.executeTest(capsHashtable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
}
class TestClass3 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "safari");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "OS X");
		capsHashtable.put("os_version", "Big Sur");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 3");
		mainTestClass r3 = new mainTestClass();
    	try {
			r3.executeTest(capsHashtable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
}
public class mainTestClass {
	public static final String USERNAME = "utkarshsharma_TrWReQ";
	public static final String AUTOMATE_KEY = "WNPGsJTqzzbLCPm5zj9q";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) throws Exception {
		Thread object1 = new Thread(new TestClass1());
		object1.start();
		Thread object2 = new Thread(new TestClass2());
		object2.start();
		Thread object3 = new Thread(new TestClass3());
		object3.start();
  	}
	public void executeTest(Hashtable<String, String> capsHashtable) throws InterruptedException {
		String key;
		DesiredCapabilities caps = new DesiredCapabilities();
		// Iterate over the hashtable and set the capabilities
		Set<String> keys = capsHashtable.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
       		key = itr.next();
       		caps.setCapability(key, capsHashtable.get(key));
    	}
    	WebDriver driver;
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
//			JavascriptExecutor jse = (JavascriptExecutor)driver;
//			// Searching for 'BrowserStack' on google.com
//			driver.get("https://www.google.com");
//			WebElement element = driver.findElement(By.name("q"));
//			element.sendKeys("BrowserStack");
//			element.submit();
//			// Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//	    	try {
//				wait.until(ExpectedConditions.titleContains("BrowserStack"));
//				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
//	    	}
//	    	catch(Exception e) {
//	    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
//	    	}
//	    	System.out.println(driver.getTitle());
//	    	driver.quit();
			
			
			//launch flipkart
			driver.manage().window().maximize();
			driver.get("https://flipkart.com");
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
			//Search for the product "Samsung Galaxy S10" on that page.
			driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Samsung Galaxy S10 \n");
			//driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
			
			Thread.sleep(5000);
			//On the search results click on "Mobiles" in categories.
			driver.findElement(By.xpath("//a[@title=\"Mobiles\"]")).click();
			//Filter -- Select Flipkart assured
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class=\"_24_Dny _3tCU7L\"]")).click();
			//Filter -- Select Brand Samsung
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement element= driver.findElement(By.xpath("(//label[@class=\"_2iDkf8 t0pPfW\"]/input[@class=\"_30VH1S\"])[7]"));
			js.executeScript("arguments[0].click();", element);
			//Sort the entries with Price -> High to Low
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
			Thread.sleep(10000);
			
			System.out.println(driver.findElement(By.xpath("//div[@class=\"_4rR01T\"]")).getText());
		
			List<WebElement> product =driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
			List<String> all_products=new ArrayList<>();

			List<WebElement> prices =driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
			List<String> all_pprice=new ArrayList<>();
			
			List<WebElement> P_url = driver.findElements(By.xpath("//a[@class=\"_1fQZEK\"]"));
			Iterator it = (Iterator) P_url.iterator();
			String url;
			
			for(int j=0; j<product.size(); j++){
		        //loading text of each element in to array all_elements_text
				all_products.add(product.get(j).getText());
				all_pprice.add(prices.get(j).getText());
		        //to print directly
		        System.out.println(product.get(j).getText());
		        System.out.println(prices.get(j).getText());
		    }
			
//			for(int i=0; i<prices.size(); i++){
//		        //loading text of each element in to array all_elements_text
//				all_pprice.add(prices.get(i).getText());
//
//		        //to print directly
//		        System.out.println(prices.get(i).getText());
//		    }
			
			
			
//			while(it.hasNext()){
//				url = it.next().getAttribute("href");
//
//				System.out.println(url);
//			}
			
driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}