package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader {
	
	private String _open;
	private String _high;
	private String _low;
	private String _last;
	private String _tradeTimeStamp;
	
	public Reader(){
		_open = "";
		_high = "";
		_low = "";
		_last = "";
		_tradeTimeStamp = "";
	}
	/**
	 * Retrieves bitcoin info
	 */
	public String parseInfo() throws IOException{
		URL url = new URL("https://www.bitstamp.net/api/ticker/");
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        line = br.readLine();
        return line;
	}

	/**
	 * Assigns the data to the correct instance variable 
	 * @param input
	 */
	public void getData(String input){
		input = input.replace('"', ' ');
		input = input.replaceAll("\\s+","");
		int a = input.indexOf(':', 0); //high
		int a1 = input.indexOf(',', 0);
		int b = input.indexOf(':', a1);//last
		int b1 = input.indexOf(',', a1+1);
		int c = input.indexOf(':', b1);
		int c1 = input.indexOf(',', b1+1);
		int d = input.indexOf(':', c1);
		int d1 = input.indexOf(',', c1+1);
		int e = input.indexOf(':', d1);
		int e1 = input.indexOf(',', d1+1);
		int f = input.indexOf(':', e1);
		int f1 = input.indexOf(',', e1+1);
		int g = input.indexOf(':', f1);
		int g1 = input.indexOf(',', f1+1);
		int h = input.indexOf(':', g1);
		int h1 = input.indexOf(',', g1+1);
		int i = input.indexOf(':', h1);
		int j = input.indexOf('}', i+1);
		for(int q = a+1; q < a1; q++){
			_high = _high + input.charAt(q);
		}
		for(int y = b+1; y < b1; y++){
			_last = _last + input.charAt(y);
		}
		for(int u = c+1; u < c1; u++){
			_tradeTimeStamp = _tradeTimeStamp + input.charAt(u);
		}
		for(int r = g+1; r < g1; r++){
			_low = _low + input.charAt(r);
		}
		for(int w = i+1; w < j; w++){
			_open = _open + input.charAt(w);
		}		
	}
	/**
	 * Creates a timestamp for when the data was retrieved
	 */
	public String makeTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss, MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	/**
	 * Prints data
	 */
	public void printData(){
		System.out.println("-------- BitCoin Info -----------");
		System.out.println();
		System.out.println("Open: " + _open);
		System.out.println("High: " + _high);
		System.out.println("Low: " + _low);
		System.out.println("Last Trade: " + _last);
		System.out.println("Timestamp: " + _tradeTimeStamp);
		System.out.println();
		System.out.println("Data as of " + makeTimeStamp());
		System.out.println("------------ End ---------------");
	}
	/**
	 * Helper functions for Writer
	 */
	public String getOpen(){
		return _open;
	}
	public String getHigh(){
		return _high;
	}
	public String getLow(){
		return _low;
	}
	public String getLast(){
		return _last;
	}
	public String getTradeTime(){
		return _tradeTimeStamp;
	}
}
