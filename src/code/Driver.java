package code;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		Writer w = new Writer();
		Reader r = new Reader();
		r.getData(r.parseInfo());
//		r.printData(); //if you want to see data displayed in terminal/console also
		w.writeTextFile(r);
	}
}
