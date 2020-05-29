package com.POM.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.stepdefinition.stepDef;


public class MyPOMFile{
	//private WebDriver driver;
	//input Fields
	//SeleniumDriver cc=new SeleniumDriver();	
		@FindBy(name = "firstName") 
		private WebElement firstName;
		@FindBy(name = "lastName") 
		private WebElement lastName;
		@FindBy(name = "phone") 
		private WebElement phone;
		@FindBy(name = "userName") 
		private WebElement email;
		@FindBy(name = "address1") 
		private WebElement address;
		@FindBy(name = "city") 
		private WebElement city;
		@FindBy(name = "state") 
		private WebElement state;
		@FindBy(name = "postalCode") 
		private WebElement postalCode;
		@FindBy(name = "country") 
		private WebElement country;
		@FindBy(name = "email") 
		private WebElement userName;
		@FindBy(name = "password") 
		private WebElement password;
		@FindBy(name = "confirmPassword") 
		private WebElement confirmPassword;
		

		
		
		public WebElement getFirstName() {
			return firstName;
		}
		public void setFirstName(WebElement firstName) {
			this.firstName = firstName;
		}
		public WebElement getLastName() {
			return lastName;
		}
		public void setLastName(WebElement lastName) {
			this.lastName = lastName;
		}
		public WebElement getPhone() {
			return phone;
		}
		public void setPhone(WebElement phone) {
			this.phone = phone;
		}
		public WebElement getEmail() {
			return email;
		}
		public void setEmail(WebElement email) {
			this.email = email;
		}
		public WebElement getAddress() {
			return address;
		}
		public void setAddress(WebElement address) {
			this.address = address;
		}
		public WebElement getCity() {
			return city;
		}
		public void setCity(WebElement city) {
			this.city = city;
		}
		public WebElement getState() {
			return state;
		}
		public void setState(WebElement state) {
			this.state = state;
		}
		public WebElement getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(WebElement postalCode) {
			this.postalCode = postalCode;
		}
		public Select getCountry() {
			return new Select(country);
		}
		public Select setCountry(Select country) {
			this.country = (WebElement) country;
			return country;
		}
		public WebElement getUserName() {
			return userName;
		}
		public void setUserName(WebElement userName) {
			this.userName = userName;
		}
		public WebElement getPassword() {
			return password;
		}
		public void setPassword(WebElement password) {
			this.password = password;
		}
		public WebElement getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(WebElement confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public WebElement getSubmit() {
			return submit;
		}
		//Submit
		@FindBy(name = "submit") private WebElement submit;

		public void setSubmit(WebElement submit) {
			this.submit = submit;
		}
		
		//post signin
		////a[@href='login.php']
		@FindBy(xpath = "//a[@href='login.php']")
		private WebElement postSignin;




		public WebElement getPostSignin() {
			return postSignin;
		}
		public void setPostSignin(WebElement postSignin) {
			this.postSignin = postSignin;
		}
		public MyPOMFile() {
			PageFactory.initElements(stepDef.driver, this);

		}
}
