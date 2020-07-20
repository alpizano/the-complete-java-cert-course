package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// Insert your code here..
		for(String linesValues: lines) {
			HashMap<String,Double> map = new HashMap<>();
			// Split string lines into string array
			String[] valuesArray = linesValues.split(",");
			int count =0;
			for(String values : valuesArray) {
				map.put(headers.get(count), Double.parseDouble(values));
				count++;
			}
//			map.put(headers.get(0), Double.parseDouble(valuesArray[0]));
//			map.put(headers.get(1), Double.parseDouble(valuesArray[1]));
//			map.put(headers.get(2), Double.parseDouble(valuesArray[2]));
//			map.put(headers.get(3), Double.parseDouble(valuesArray[3]));
//			map.put(headers.get(4), Double.parseDouble(valuesArray[4]));
//			map.put(headers.get(5), Double.parseDouble(valuesArray[5]));

			dataResult.add(map);
		}
		return dataResult;
	}
	
	
}
