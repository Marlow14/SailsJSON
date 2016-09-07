package localhost1337.employee.sailsJSONpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class sailsRequest3 {
	
	//URL of the API to connect 
			protected static String endpoint = "http://localhost:1337/employee/";
			
			public static void sailsGetSpecific(){
				
				try {
					
					//Specific employee that you want to get
					String specificEmployee = "4";
					
					//Creates the entire URL, opens connections, sends post method
					URL sailsEmployee = new URL(endpoint + specificEmployee);
					HttpURLConnection connection = (HttpURLConnection) sailsEmployee.openConnection();
					connection.setRequestMethod("GET");
					
					// if we did not get a 200 (success) throw an error
					if (connection.getResponseCode() != 200) {
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
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//sailsGetSpecific method

}//ClassS
