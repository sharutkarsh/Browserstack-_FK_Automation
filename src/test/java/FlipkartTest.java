
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
	

public class FlipkartTest {
	WebDriver driver;
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	//launch flipkart
	driver.get("https://flipkart.com");
	driver.findElement.by.xpath("/html/body/div[2]/div/div/button").click();
	//Search for the product "Samsung Galaxy S10" on that page.
	driver.findElement.by.xpath("//input[@type=\"text\"]").sendKeys("Samsung Galaxy S10");
	driver.findElement.by.xpath("//button[@class=\"L0Z3Pu\"]").click();
	
	Thread.sleep(3000);
	//On the search results click on "Mobiles" in categories.
	driver.findElement.by.xpath("//a[@title=\"Mobiles\"]").click();
	//Filter -- Select Flipkart assured
	driver.findElement.by.xpath("//div[@class=\"_24_Dny _3tCU7L\"]").click();
	//Filter -- Select Brand Samsung
	driver.findElement.by.xpath("(//label[@class=\"_2iDkf8 t0pPfW\"]/input[@class=\"_30VH1S\"])[7]").click();
	//Sort the entries with Price -> High to Low
	driver.findElement.by.xpath("//div[text()='Price -- High to Low']").click();
	//
	List<WebElement> product =driver.findElements(By.xpath("/div[@class=\"_4rR01T\"]"));
	List<String> all_products=new ArrayList<>();

	List<WebElement> prices =driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
	List<String> all_pprice=new ArrayList<>();
	
	List<WebElement> P_url = driver.findElements(By.xpath("//a[@class=\"_1fQZEK\"]"));
	Iterator it = (Iterator) P_url.iterator();
	String url;
	
	for(int j=0; j<product.size(); j++){
        //loading text of each element in to array all_elements_text
		all_products.add(product.get(j).getText());

        //to print directly
        System.out.println(product.get(j).getText());
    }
	
	for(int i=0; i<prices.size(); i++){
        //loading text of each element in to array all_elements_text
		all_pprice.add(prices.get(i).getText());

        //to print directly
        System.out.println(prices.get(i).getText());
    }
	
	
	while(it.hasNext()){
		url = it.next().getAttribute("href");

		System.out.println(url);
	}
	
	

}}
