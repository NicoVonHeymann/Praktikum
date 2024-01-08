package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import business.Buergeramt;

public class CsvProduct  extends Product {

	BufferedWriter writer;
	
	public CsvProduct() throws IOException {
		writer = new BufferedWriter(
				new FileWriter("Buergeraemter.csv", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) {
		ArrayList<Buergeramt> burg = (ArrayList<Buergeramt>) object;
		try {
			for (Buergeramt buergeramt : burg) {
				writer.write(buergeramt.gibBuergeramtZurueck(';'));
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void schliesseDatei() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
