package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		/**
			You'll need to uncomment the below code. You'll notice it does not compile!
			
			There are 2 objectives in this assignment.
			
			1).  Make sure the code compiles correctly after you uncomment it below.
			2).  Make sure it runs as explained in the assignment video!
			
			-->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS. 
		**/

//		MinAggregator agg = new MinAggregator();
//		MaxAggregator agg = new MaxAggregator();
		MeanAggregator agg = new MeanAggregator();

//		AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");
//		AggregatorProcessor<MaxAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");
		AggregatorProcessor<MeanAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");

		// 1 represents column number
		double value = aggsProcessor.runAggregator(3);
		System.out.println(value);
	

	}

}
