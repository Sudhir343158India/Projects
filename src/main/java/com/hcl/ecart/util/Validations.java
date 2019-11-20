package com.hcl.ecart.util;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public static boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }

	public static boolean mobileValid(String s) 
  { 
      // The given argument to compile() method  
      // is regular expression. With the help of  
      // regular expression we can validate mobile 
      // number.  
      // 1) Begins with 0 or 91 
      // 2) Then contains 7 or 8 or 9. 
      // 3) Then contains 9 digits 
      Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 

      // Pattern class contains matcher() method 
      // to find matching between given number  
      // and regular expression 
      Matcher m = p.matcher(s); 
      return (m.find() && m.group().equals(s)); 
  } 
	
	public class Encrypt 
	{  
	    public void main(String[] args) {  
	        // Getting encoder  
	        Base64.Encoder encoder = Base64.getUrlEncoder();  
	        // Encoding URL  
	        String eStr = encoder.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes());  
	        System.out.println("Encoded URL: "+eStr);  
	        // Getting decoder  
	        Base64.Decoder decoder = Base64.getUrlDecoder();  
	        // Decoding URl  
	        String dStr = new String(decoder.decode(eStr));  
	        System.out.println("Decoded URL: "+dStr);  
	    }  
	}  
	
}
