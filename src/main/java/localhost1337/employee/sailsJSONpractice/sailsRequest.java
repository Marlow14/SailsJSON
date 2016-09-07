package localhost1337.employee.sailsJSONpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/*
 * 
 * Sample class that makes simple request to sailsAPI
 * @author Chris Marlow
 * @since 2016-09-07
 * 
 */

public class sailsRequest {
	
	//URL of the API to connect 
	protected static String endpoint = "http://localhost:1337/employee?";
	
	//The character set to use when encoding the URL parameters
	protected static String charset = "UTF-8";
	
	//No API key need for this query
	
	
	public static void sailsPost(){
		
		try{
			//The first name of employee
			String firstName = "Dred";
			
			//The last name of employee
			String lastName = "Scott";
			
			//The email of employee
			String email = "blacklivesmatter@gmail.com";
			
			//The home number of employee
			String homeNumber = "301-000-0000";
			
			//The cell number of employee
			String cellNumber = "240-000-0000";
			
			//The password of employee
			String password = "B1ackpwr";
			
			//The active status of employee
			String active = "1";
			
			//Creates the formated query string to be sent
			String queryString = String.format("firstName=%s&lastName=%s&email=%s&homeNumber=%s&cellNumber=%s&password=%s&active=%s",
					URLEncoder.encode(firstName, charset), 
					URLEncoder.encode(lastName, charset), 
					URLEncoder.encode(email, charset), 
					URLEncoder.encode(homeNumber, charset), 
					URLEncoder.encode(cellNumber, charset), 
					URLEncoder.encode(password, charset), 
					URLEncoder.encode(active, charset)
					);
			
			//Creates the entire URL, opens connections, sends post method
			URL sailsEmployee = new URL(endpoint + queryString);
			HttpURLConnection connection = (HttpURLConnection) sailsEmployee.openConnection();
			connection.setRequestMethod("POST");
			
			//Error checking if there is not a successful process throws exception
			if (connection.getResponseCode() != 201){
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}
			
			//Reads the reponse into a BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//Loops line by line until it returns null
			while(br.readLine() != null){
				System.out.println(br.readLine());
			}
			
			//Closes the connection
			connection.disconnect();
			
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}//sailsPost method
	

}//class
