package RealTime;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satti\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.getTitle();
		driver.findElement(By.id("email")).sendKeys("rockingsumanth143@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tomjerry@6979");
		driver.findElement(By.name("login")).click();
		driver.getTitle();
		// 1.Find out the count of links and images
		List<WebElement> list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total number of links and images: "  + list.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		// 2. Iterating the loop to find out the link doesn't have href attribute
		for(int i =0 ;i<list.size();i++)
		{
			System.out.println(list.get(i).getAttribute("href"));
			if(list.get(i).getAttribute("href") != null && (!list.get(i).getAttribute("href").contains("Javascript")))
			{
				activeLinks.add(list.get(i));
			}
		}
		System.out.println("Final Active Links in facebookHome page is :" + activeLinks.size());
		for(int j=0;j<activeLinks.size();j++)
		{
			//HttpURLConnection connections = (HttpURLConnection) ((Object) new URL(activeLinks.get(j).getAttribute("href"), connections)).openConnections();
			//connections.connect();
			//String msg = connections.getResponseMessage();
			//connections.disconnect();
			//System.out.println(activeLinks.get(j).getAttribute("href") + "======>" + msg);
		}
		
	}

}
