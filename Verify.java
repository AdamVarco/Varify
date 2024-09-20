package myPackage;

import java.util.Scanner;

public class Verify {
	
	private static String regex = "^(?=.*?\\p{Lu})(?=.*?[\\p{L}&&[^\\p{Lu}]])(?=.*?\\d)"
			+ "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$";

	public static void main(String[] args) {
		
		String userName = "",passWord = "",bDay = "", pin = "";
		userName = Verify.verifyUsername(userName);
		
		passWord = Verify.verifyPassword(userName,passWord);
		
		bDay = Verify.verifyBday(bDay);
		
		
		pin = Verify.verifyPin(pin);
		
		
		System.out.println(" Your Usernam is : "+ userName + " \n Your passWord is : " + passWord + "\n Your Birthday is : "+ bDay + "\n Your Pin is : "+ pin);
		
	}
	
	private static String verifyPin(String pin) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please type your pin number"
				+ "\n Make sure that it is between 2 and 5 numbers long");
	    pin= scan.nextLine();
	    
	    if (pin.length() < 2 || String.valueOf(pin).length() > 5) {
	    	System.out.println("Pin number not correct length"
					+ "\n Make sure that it is between 2 and 5 numbers long");
	    	Verify.verifyPin(pin);
	    	
	    }
	    
	    if (pin.length() >= 2 && String.valueOf(pin).length() <= 5) {
	    	if(!pin.matches("\\d+")) {
	    		System.out.println("Pin number must be a digit 0-9");
	    		Verify.verifyPin(pin);
	    	}
	    }
		return pin;
	    
		
	}

	private static String verifyUsername(String userName) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type a username \n"
				+ "It has to have an upercase, a number, and a special character");
		userName = scan.nextLine();
		
		if(userName.length() <9  || userName.length() > 12) {
			System.out.println("Username needs to have between 9 and 12 characters");
			Verify.verifyUsername(userName);
		}
		
		if (userName.length() >= 9 && userName.length() <= 12) {
			
			if (!userName.matches(regex)) {
				System.out.println("Username needs to have an uppercase, a number and a special character");
				
				Verify.verifyUsername(userName);
			}
		}
		return userName;
	}
	private static String verifyPassword(String userName, String passWord) {
		
		// System.out.println(correctUname);
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type a password \n"
				+ "It has to have an upercase, a number, and a special character");
			passWord = scan.nextLine();

		if(passWord.length() <9  || passWord.length() > 12) {
			System.out.println("Password needs to have between 9 and 12 characters");
			Verify.verifyPassword(userName,passWord);
		}
		
		if(userName.equals(passWord)) {
			System.out.println("Password cannot be the same as UserName");
			Verify.verifyPassword(userName, passWord);
		}
				
		if (passWord.length() >= 9 && passWord.length() <= 12) {
			
			if(!passWord.matches(regex)) {
				System.out.println("Password needs to have an uppercase, a number and a special character");
				Verify.verifyPassword(userName, passWord);
				
			}
					

		}
		return passWord;
	}

	private static String verifyBday( String bDay) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please type your Birthday "
				+ "\n like this YYYY-MM-DD");
		bDay = scan.nextLine();
		double month = 0.0, day = 0.0;
        if(bDay.contains("-") && bDay.length()== 10) {
	        String[] split = bDay.split("-");
	        if (bDay.matches("\\d{4}-\\d{2}-\\d{2}")) {
			
	        	if(split[1].length()> 0 )
				 month = Double.parseDouble(split[1]);
	        	if(split[2].length()> 0)
				day = Double.parseDouble(split[2]);
			
				if (month >= 1 && month <= 12) {
					if (day >= 1 && day <= 31) {
						
					}
					else {
						System.out.println("Birthday does not match the correct format");
						Verify.verifyBday(bDay);
					}
					
				}
				else {
					System.out.println("Birthday does not match the correct format");
					Verify.verifyBday(bDay);
				}
			}
	        else {
				System.out.println("Birthday does not match the correct format");
				Verify.verifyBday(bDay);
			}
				
        }
        else {
        	System.out.println("Birthday does not match the correct format");
        	Verify.verifyBday(bDay);
        }
		return bDay;
		
		
     }

}
