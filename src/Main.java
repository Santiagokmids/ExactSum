import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	private final static String SEPARATOR = " "; 
	private static double[] allPrices;
	
	public static void main(String[] args) throws IOException {
		startApp();
	}
	
	public static void startApp() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		String books = br.readLine();
		String prices = "";
		//String money = "";

		if(books != null){

			int cause = Integer.parseInt(books);

			int[] allPrices = new int[cause];
			prices = br.readLine();
			String parts[] = prices.split(SEPARATOR);
							
			for (int j = 0; j < parts.length; j++) {

				allPrices[j] = Integer.parseInt(parts[j]);

			}

			bw.write(Arrays.toString(allPrices));

			//money = br.readLine();

			br.close();
			bw.close();
		}
	}
	
	/*public static int findSums() {
		
		double sum = allPrices[0] + allPrices[1];
		
		for (int i = 0; i < allPrices.length; i++) {
			
			for (int j = 1; j < allPrices.length; j++) {
				
				if(sum < allPrices[i] + allPrices[j]) {
					
				} 
				sum = allPrices[i] + allPrices[j];
			}
		}
		return 0;
	}*/

}
