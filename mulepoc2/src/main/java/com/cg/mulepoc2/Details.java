package com.cg.mulepoc2;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Value;



public class Details implements Callable {
  private String userName;
  private String emailId;
  private String Password;
  
public String getUserName() {
	return userName;
}
public void setUserName(String UserName) {
	this.userName = UserName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String Password) {
	this.Password = Password;
}
  public Details() {
	// TODO Auto-generated constructor stub
}
  
  //reading credentials
  //test
  @Value("${testUserName}")
  private String testUserName;
  @Value("${testEmailId}")
  private String testEmailId;
  @Value("${testPassword}")
  private String testPassword;
  
  //Dev
  @Value("${devUserName}")
  private String devUserName;
  @Value("${devEmailId}")
  private String devEmailId;
  @Value("${devPassword}")
  private String devPassword;
  
  //Prod
  @Value("${prodUserName}")
  private String prodUserName;
  @Value("${prodEmailId}")
  private String prodEmailId;
  @Value("${prodPassword}")
  private String prodPassword;
  
  public String isDevValid(String inputEmailId, String inputUserName, String inputPassword) throws InvalidLoginException {
		String result = new String();
		System.out.println(devEmailId+devPassword+devUserName+inputEmailId+inputPassword+inputUserName);
		if (inputEmailId.equals(devEmailId) && inputUserName.equals(devUserName) && inputPassword.equals(devPassword)) {
			result = "Successfully Logged in As DEVELOPER";
		}else
			throw new InvalidLoginException("Invalid Login credentials");
		return result;
	}

  public String isTestValid(String inputEmailId, String inputUserName, String inputPassword) throws InvalidLoginException{
	  String result= new String();
	  if(inputEmailId.equals(testEmailId) && inputUserName.equals(testUserName) && inputPassword.equals(testPassword)){
		  result="Successfully Logged in As TESTER";
  }else
	  throw new InvalidLoginException("Invalid Login Crdentials");
	  return result;
   }
  
  public String isProdValid(String inputEmailId, String inputUserName, String inputPassword) throws InvalidLoginException{
	  String result= new String();
	  if(inputEmailId.equals(prodEmailId)&& inputUserName.equals(prodUserName)&&inputPassword.equals(prodPassword)){
		result="Successfully logged in As a PROD";
	  }else
		  throw new InvalidLoginException("Invalid Login Crdentials");
	  return result;
  }
  
  @Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		return null;
	}
}
