import java.io.*;
import java.util.*;

import com.opencsv.CSVWriter;

public class ATR {
	public static void main(String[] args) throws IOException {
		
		String fileToParse = "CSVFile.csv";
        BufferedReader fileReader = null;
		final String DELIMITER = ",";
		float dailyrange, TR, high, low, previousclose;
		CSVWriter writer = new CSVWriter(new FileWriter("output2.csv"));
		
        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader("input.csv"));
            String[] header = {"Daily Range", "True Range"};
			writer.writeNext(header);
			while ((line = fileReader.readLine()) != null)
            {
				String[] tokens = line.split(DELIMITER);
				
				dailyrange = (Float.parseFloat(tokens[3])-Float.parseFloat(tokens[4]));
				//System.out.println(dailyrange);
				
                TR = Math.max(Float.parseFloat(tokens[3]),Float.parseFloat(tokens[2])) - Math.min(Float.parseFloat(tokens[4]),Float.parseFloat(tokens[5]));
				///System.out.println(TR);
				
				
				String[] data1 = {String.valueOf(dailyrange), String.valueOf(TR)};
				writer.writeNext(data1);
				
            }
        }catch (Exception e) {
            e.printStackTrace();
         }finally {
        	 writer.close();
         }
} 
}