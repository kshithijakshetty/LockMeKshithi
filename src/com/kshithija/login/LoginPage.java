package com.kshithija.login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.kshithija.model.UserCredentials;
import com.kshithija.model.Users;

public class LoginPage 
{

	private static Scanner keyboard;
	private static Scanner input;
	
	private static PrintWriter output;
	private static PrintWriter lockerOutput;
	
	private static Users users;
	private static UserCredentials userCredentials;

	public static void main(String[] args) 
	{
		
		initializeApplication();
		welcomePage();
		signInOptions();
		

	}
	
	public static void signInOptions() {
		
		System.out.println(" 1. Registration page ");
		System.out.println(" 2. Login Page");
		
		int option=keyboard.nextInt();
		switch(option) {
		case 1: 
			registerUser();
			break;
			
		case 2 :
			loginUser();
			break;
			
		default :
			System.out.println("Please select option 1 or 2 to continue");
			signInOptions();
			break;
				
		}
		keyboard.close();
		input.close();
		
	}
	
	public static void registerUser()
	{
		System.out.println("===============================================");
		System.out.println("*                                      *");
		System.out.println("*      Welcome to Registraton Page       *");
		System.out.println("                                        ");
		System.out.println("===============================================");
		
		
		System.out.println("Enter Username");
		String username=keyboard.next();
		users.setUsername(username);
		
		System.out.println("Enter Password");
		String password=keyboard.next();
		users.setPassword(password);
		
		output.println(users.getUsername());
		output.println(users.getPassword());
		
		System.out.println("User Registration Successful !!");
		output.close();
		loginUser();
		
	}
	
	public static void loginUser()
	{
		System.out.println("===============================================");
		System.out.println("*                                      *");
		System.out.println("*      Welcome to Login Page       *");
		System.out.println("                                        ");
		System.out.println("===============================================");
		
		System.out.println("Enter Username");
		String inputUsername=keyboard.next();
		boolean found = false;
		
		while(input.hasNext() && !found)
		{
			if(input.next().equals(inputUsername)) 
			{
				System.out.println("Enter Password");
				String inputPassword=keyboard.next();
				
				if(input.next().equals(inputPassword)) 
				{
					System.out.println("Login Successful !!");
					found = true;
					userLoginCredentials();
					break;
				}
				
			}
		}
		
		if(!found)
		{
			System.out.println("User Not Found : Please Register to continue");
			registerUser();
		}
		
		
	}
	public static void welcomePage()
	{
			System.out.println("===============================================");
			System.out.println("*                                      *");
			System.out.println("*      Welcome to LockedMe.com       *");
			System.out.println("*      Your personal Digital Locker   *");
			System.out.println("                                        ");
			System.out.println("===============================================");
			
	}
	
	public static void initializeApplication()
	{
		File dbFile=new File("database.txt");
		File lockerFile=new File("locker-file.txt");
		
		try
		{
			input = new Scanner(dbFile);
			
			keyboard = new Scanner(System.in);
			
			output=new PrintWriter(new FileWriter(dbFile,true));
			lockerOutput=new PrintWriter(new FileWriter(lockerFile,true));
			
			users=new Users();
			userCredentials = new UserCredentials();
		}
		catch(IOException e) {
			System.out.println("404 : File Not Found");
		}
	}
	
	public static void userLoginCredentials()
	{
		System.out.println("===============================================");
		System.out.println("*                                      *");
		System.out.println("*      Welcome to Credentials Page       *");
		System.out.println("                                        ");
		System.out.println("===============================================");
		
		
		System.out.println("Enter Website");
		String websiteName=keyboard.next();
		userCredentials.setWebsiteName(websiteName);
		
		System.out.println("Enter CurrentUser");
		String currentUser=keyboard.next();
		userCredentials.setCurrentUser(currentUser);
		
		System.out.println("Enter username");
		String username=keyboard.next();
		userCredentials.setUsername(username);
		
		System.out.println("Enter password");
		String password=keyboard.next();
		userCredentials.setPassword(password);
		

		lockerOutput.println(userCredentials.getWebsiteName());
		lockerOutput.println(userCredentials.getCurrentUser());
		lockerOutput.println(userCredentials.getUsername());
		lockerOutput.println(userCredentials.getPassword());
		
		System.out.println("**Your Credentials are Successfully saved !!**");
		lockerOutput.close();
	} 

}
