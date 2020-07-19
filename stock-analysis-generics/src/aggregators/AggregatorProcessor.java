package aggregators;

import client.StockFileApplication;
import fileprocessors.StockFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AggregatorProcessor<E extends Aggregator> {
    E agg;
    String filename;

    public AggregatorProcessor(E agg, String filename) {
        this.agg = agg;
        this.filename = filename;
    }

	public double runAggregator(int col) throws IOException {
        List<Double> values = agg.getValues();

        StockFileReader fr = new StockFileReader(filename);
        String key = fr.getHeaders().get(col);
        List<HashMap<String, Double>> dataResult = StockFileApplication.populateStockFileData(fr.getHeaders(), fr.readFileData());

        // put all values from map inside List<Double> values
        for(HashMap map: dataResult) {
            if(map.containsKey(key)) {
                values.add((Double)map.get(key));
            }
        }

        return agg.calculate();

    }

	
}
