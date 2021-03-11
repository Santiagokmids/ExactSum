import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
	
	private final static String SEPARATOR = " "; 
	private static ArrayList<Integer> allPrices;
	
	public static void main(String[] args) throws IOException {
		startApp();
	}
	
	public static void startApp() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		String books = br.readLine();
		String prices = "";

		if(books != null){

			int cause = Integer.parseInt(books);

			allPrices = new ArrayList<>();
			prices = br.readLine();
			String parts[] = prices.split(SEPARATOR);
							
			for (int j = 0; j < cause; j++) {

				allPrices.add(Integer.parseInt(parts[j]));

			}
			
			sort();
			String money = br.readLine();
			
			bw.write(allPrices.toString());

			br.close();
			bw.close();
		}
	}

	public static void sort() {
		Collections.sort(allPrices);
	}
	
	//public static int binarySearch(int number) {
		
	//}

}
