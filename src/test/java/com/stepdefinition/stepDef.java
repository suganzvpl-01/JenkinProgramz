package com.stepdefinition;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.POM.com.MyPOMFile;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDef{
	public static WebDriver driver;
	
	@Given("^I Open my URL$")
	public void i_Open_my_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	//    throw new PendingException();
		openURL("http://demo.guru99.com/test/newtours/register.php");
			}
	
	
	@When("^I Enter the details for all the Fields$")
	public void i_Enter_the_details_for_all_the_Fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		regAdd();
		  	 	
		
	}
	
	@And("^Enter the Submit for Registration$")
	public void enter_the_Submit_for_Registration() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ////throw new PendingException();
		regSubmit();
	}
	
	

	@Then("^The Registration Completed Successfully for Single User$")
	public void the_Registration_happens_Successfully_for_Single_User() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Registration is Successful");
	}
	
	@And("^Take a Screenshot$")
	public void take_a_Screenshot() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		takeScreenshot();
	}
	@And("^I close my Browser$")
	public void i_close_my_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}
	
	public static String getTheData(String ColNameParm) throws Throwable {
		//System.out.println("Hi");
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("Excel/data.xlsx");
		String strQuery = "Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);
		//System.out.println(recordset.getField(ColNameParm).toString());
		String result = null;
		
		while(recordset.next()) { 
				 result=recordset.getField(ColNameParm).toString();
		break;}
		 	 // System.out.println(listOfMaps.get(0));
		System.out.println(result);
		recordset.close();
		connection.close();
		return result;

	}
	
	  public void openURL(String url) {
	  System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	  driver = new ChromeDriver(); driver.manage().timeouts().implicitlyWait(10,
	  TimeUnit.SECONDS); driver.get(url); driver.manage().window().maximize(); 
	  }
	  public void regAdd() throws Throwable {
			MyPOMFile reg=new MyPOMFile();

		  reg.getFirstName().sendKeys(getTheData("FirstName"));
		  reg.getLastName().sendKeys(getTheData("LastName"));
		  reg.getPhone().sendKeys(getTheData("Phone"));
		  reg.getEmail().sendKeys(getTheData("Email"));
		  reg.getAddress().sendKeys(getTheData("Address"));
		  reg.getCity().sendKeys(getTheData("City"));
		  reg.getState().sendKeys(getTheData("State"));
		  reg.getPostalCode().sendKeys(getTheData("PostCode"));
		  reg.getCountry().selectByValue(getTheData("Country"));
		  reg.getUserName().sendKeys(getTheData("UserName"));
		  reg.getPassword().sendKeys(getTheData("Pwd"));
		 reg.getConfirmPassword().sendKeys(getTheData("ConfirmPwd"));
	
	  }
	  public void regSubmit() {
			MyPOMFile reg=new MyPOMFile();
			reg.getSubmit().click();

			// TODO Auto-generated method stub
			
		}
	  public static void takeScreenshot() throws Throwable {
			 TakesScreenshot ts = (TakesScreenshot)driver;
		        File temp = ts.getScreenshotAs(OutputType.FILE);
		        //String changeOver= (parseString)instant;
		        
		        File des = new File("Screenshot/Register_"+timestamp()+".png");
		        FileUtils.copyFile(temp, des);

		}
	  public static String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}

	 
}