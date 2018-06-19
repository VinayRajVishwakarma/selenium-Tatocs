package training;

import java.awt.List;
import java.util.ArrayList;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

import org.openqa.selenium.interactions.Actions;



public class Tatocs {

	public static void main(String[] args){
		
		String str2;
		Boolean condition = true;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayvishwakarma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://10.0.1.86/tatoc" );
		
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		//WebElement element= driver.findElement(By.id("main"));
		System.out.println("Test");
		
		
		
		WebDriver element2 = driver.switchTo().frame(driver.findElement(By.id("main")));  
		
		String str = element2.findElement(By.id("answer")).getAttribute("class");
				System.out.println(str);	
		while(condition){
			
			driver.findElement(By.cssSelector("a")).click();
			
			//System.out.println("Hi");		
			//driver.switchTo().frame(driver.findElement(By.id("main")));	
			
			WebElement childElement= driver.findElement(By.id("child"));
				driver.switchTo().frame(childElement);
			 str2 = driver.findElement(By.id("answer")).getAttribute("class");
			 driver.switchTo().parentFrame();

			if(str.equals(str2)){
				condition = false;
			}
		}
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
	
		WebElement drag= driver.findElement(By.id("dragbox"));
		WebElement drop= driver.findElement(By.id("dropbox"));	
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		
		driver.findElement(By.cssSelector("a")).click();
		
		driver.findElement(By.cssSelector("a")).click();
		
		
		/*Set windowId = (Set) driver.getWindowHandles();
		java.util.Iterator<String> iterator = ((java.util.Set<String>) windowId).iterator();
		System.out.println("new tab opened");
		String mainWinId = iterator.next();
		String newWinId = iterator.next();
		
		driver.switchTo().window(newWinId);
		
		driver.findElement(By.id("name")).sendKeys("Vinay");
		driver.findElement(By.id("submit")).submit();*/
		
		  ArrayList tabs = new ArrayList (driver.getWindowHandles());
		    System.out.println(tabs.size());
		    driver.switchTo().window((String) tabs.get(1)); 
		    
		    System.out.println(driver.getTitle());
		    driver.findElement(By.id("name")).sendKeys("Vinay");
			driver.findElement(By.id("submit")).click();
			
			driver.switchTo().window((String) tabs.get(0));
			System.out.println(driver.getTitle());
			
			driver.findElements(By.tagName("a")).get(1).click();
			
			driver.findElement(By.cssSelector("a")).click();
			String token = driver.findElement(By.id("token")).getText();
			System.out.println(token);
			
			String[] newToken= token.split(" ");
			
			
			
			Cookie name = new Cookie("Token", newToken[1]);
			driver.manage().addCookie(name);
			System.out.println(name);
			
			
			
			driver.findElements(By.tagName("a")).get(1).click();
			
		driver.quit();
	} 
	
		
		
		
}
