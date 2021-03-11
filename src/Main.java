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
			String peterMoney = br.readLine();
			int money = Integer.parseInt(peterMoney);
			bw.write(findNumber(money)); 

			br.close();
			bw.close();
		}
	}

	public static void sort() {
		Collections.sort(allPrices);
	}
	
	public static int binarySearch(int number, int less) {
		int pos = -1;
		int i = 0;
		int j = allPrices.size() - 1;
		
		while(i <= j && pos < 0) {
			int half = (i + j)/2;
			
			if((allPrices.get(half) + less) == number) {
				pos = allPrices.get(half);

			}else if((allPrices.get(half) + less) > number) {
				j = half - 1;
				
			}else {
				i = half + 1;
			}
		}
		return pos;
	}
	
	public static String findNumber(int money) {
		int result = 0, price1 = 0, price2 = 0, difference1 = 0, difference2 = 2;
		String message = "";
		
		for (int i = 0; i < allPrices.size(); i++) {
			
			result = binarySearch(money, allPrices.get(i));

			if(result != -1) {
				
				if(price1 == 0 && price2 == 0) {
					
					if(result > allPrices.get(i)) {
						
						price1 = allPrices.get(i);
						price2 = result;
						difference1 = result -  allPrices.get(i);
						message = ("Peter should buy books whose prices are "+price1+" and "+price2+".");
						
					}else {
						price1 = result;
						price2 = allPrices.get(i);
						difference1 = allPrices.get(i) - result;
						message = ("Peter should buy books whose prices are "+price1+" and "+price2+".");
					}
					
				}else {
					
					if(result > allPrices.get(i)) {

						difference2 = result - allPrices.get(i);
						
						if(difference1 > difference2) {
							message = ("Peter should buy books whose prices are "+allPrices.get(i)+" and "+result+".");
							
						}else {
							message = ("Peter should buy books whose prices are "+price1+" and "+price2+".");							
						}

					}else {
						difference2 = allPrices.get(i) - result;
						
						if(difference1 > difference2) {
							message = ("Peter should buy books whose prices are "+result+" and "+allPrices.get(i)+".");
							
						}else {
							message = ("Peter should buy books whose prices are "+price1+" and "+price2+".");							
						}
					}
				}
			}

		}
		return message;
	}

}
