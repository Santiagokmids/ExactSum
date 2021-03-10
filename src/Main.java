import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	private final static String SEPARATOR = ""; 
	
	public static void main(String[] args) {
	
	}
	
	public static void startApp() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		try {

			String books = br.readLine();
			String prices = "";
			
			if(books != null){
				
				int cause = Integer.parseInt(books);
				
				if(cause >= 2 && cause <= 10000) {
					
					double[] allPrices = new double[cause];  

					for (int i = 0; i < allPrices.length; i++) {
						
						prices = br.readLine();
						
						String parts[] = prices.split(SEPARATOR);
						
						for (int j = 0; j < parts.length; j++) {
							
							if(Double.parseDouble(parts[j]) < 1000001) {
								allPrices[i] = Double.parseDouble(parts[j]);
							}
						}

						bw.write();
					}	
					br.close();
					bw.close();
				}
			}

		} catch (NumberFormatException nfe) {
			System.out.println("\nPlease enter numbers");	
		}
	}

}
