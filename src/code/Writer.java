package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	
	public Writer(){
		
	}
	public void writeTextFile(Reader r){
		
			try {
				File file = new File("/Users/James/Desktop/BitcoinInfo.txt");
				if(!file.exists()){
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("-------- BitCoin Info -----------");
				bw.write('\n');
				bw.write("Open: " + r.getOpen());
				bw.write('\n');
				bw.write("High: " + r.getHigh());
				bw.write('\n');
				bw.write("Low: " + r.getLow());
				bw.write('\n');
				bw.write("Last Trade: " + r.getLast());
				bw.write('\n');
				bw.write("Timestamp: " + r.getTradeTime());
				bw.write('\n');
				bw.write("Data as of " + r.makeTimeStamp());
				bw.write('\n');
				bw.write("------------ End ---------------");
				bw.write('\n');
				bw.write('\n');
				bw.close();

				System.out.println("Finished creating your text file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
