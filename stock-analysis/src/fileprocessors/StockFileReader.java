package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}

	/**
	 * Returns a List of type String of the headers of the csv file
	 * @return The headers of the csv file
	 * @throws IOException
	 */
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = Arrays.asList(header);
		System.out.println(values);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		List<String> lines = new ArrayList<String>();
		// Insert your code here..

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String line = bufferedReader.readLine();
			line = bufferedReader.readLine();

			while( line != null) {
				//System.out.println(line);
				lines.add(line);
				line = bufferedReader.readLine();
			}
		}


	    return lines;
	}
	

}
