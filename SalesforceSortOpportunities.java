package december24;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceSortOpportunities {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get("https://login.salesforce.com/");
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the sales option
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and...']")).click();
		//click on the opportunities tab
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();", opp);
		
		/*
		 * WebElement findElement = driver.findElement(By.
		 * xpath("//button[@class='slds-button slds-button_icon slds-button_icon-more' and @title='Display as Table']"
		 * )); driver.executeScript("arguments[0].click();", findElement); Thread.sleep(8000); WebElement table =
		 * driver.findElement(By.xpath("//li[@title='Table']"));
		 * driver.executeScript("arguments[0].click();",table );
		 */
      //click tableoption 
        WebElement tableView = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-more' and @title='Display as Table']"));
        driver.executeScript("arguments[0].click();", tableView);
        driver.findElement(By.xpath("//li[@class='slds-dropdown__item slds-is-selected grid']/a")).click();
		  Thread.sleep(8000);
		/*
		 * driver.findElement(By.
		 * xpath("//table[contains(@class,'slds-table forceRecordLayout')]//following::th[@title='Close Date']//following::span[text()='Sort']/following::span[@title='Close Date']"
		 * )).click();
		 */
		//sort by ascendingorder 
		  WebElement closedate = driver.findElement(By.xpath("//span[text()='Close Date']"));
		  driver.executeScript("arguments[0].click();",closedate );
		  Thread.sleep(5000);
		  driver.executeScript("arguments[0].click();",closedate );
		 
        
		/* driver.executeScript("arguments[0].click();",sort ); */
    /* // Select the Table view
     		WebElement tableView = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-more' and @title='Display as Table']"));
             driver.executeScript("arguments[0].click();", tableView);
             driver.findElement(By.xpath("//li[@class='slds-dropdown__item slds-is-selected grid']/a")).click();
             Thread.sleep(3000);
     		// Sort the Opportunities by Close Date in ascending order
     		//WebElement closedate = driver.findElement(By.xpath("//a[@data-aura-rendered-by='111:578;a']"));
             WebElement closedate = driver.findElement(By.xpath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//div)[22]"));
     		closedate.click();
     		System.out.println(closedate);*/
		  
		  //verify ascending order
		  Thread.sleep(5000);
		  List<WebElement> date = driver.findElements(By.xpath("//span[@class='slds-truncate slds-text-align_right slds-grow  sfaOpportunityDealMotionCloseDate']/span"));
			// I am Using List concept to get all the dates
			List<Integer> area = new ArrayList<Integer>();
			for (WebElement each : date) {
				//area.add(each.getText());
				
               String text = each.getText();
			   System.out.println(text);
			}
		
		/*
		 * if(datelist.contains(datelist)) {
		 * System.out.println("The date is in ascending order"); }else {
		 * System.out.println("it is in descending order"); }
		 */

		 
        
        
	}

}
