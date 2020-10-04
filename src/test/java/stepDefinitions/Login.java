package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login{
     
	WebDriver driver ;
@Given("Open the Chrome and launch the application")
public void open_the_chrome_and_launch_the_application() {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	driver.get("http://the-internet.herokuapp.com/");
    
}

@Given("Click Add\\\\/Remove Elements in the opened Page")
public void click_add_remove_elements_in_the_opened_page() {
    driver.findElement(By.linkText("Add/Remove Elements")).click();
}

@Given("Click AddElement button")
public void click_add_element_button() {
   WebElement button1= driver.findElement(By.cssSelector("#content > div > button"));
   button1.click();
   if (button1.isDisplayed()) {
   	System.out.println("Button is added");
   }
   else {
   	System.out.println("Button is not added");
   }
   
}

@Given("Click Delete button")
public void click_delete_button() {
	
    driver.findElement(By.cssSelector("#elements > button")).click();
    

}
@Then("Validate the button is deleted and close the page")
public void validate_the_button_is_deleted_and_close_the_page() {
    
	  WebElement button2= driver.findElement(By.cssSelector("#elements > button"));
	   button2.click();
	   if (button2.isDisplayed()) {
	   	System.out.println("Button is not deleted");
	   }
	   else {
	   	System.out.println("Button is deleted");
	   }
	driver.close();
   
    
    
    
}



}

