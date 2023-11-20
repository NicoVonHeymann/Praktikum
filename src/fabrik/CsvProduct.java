package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class CsvProduct  extends Product {

	BufferedWriter writer;
	
	public CsvProduct() throws IOException {
		writer = new BufferedWriter(
				new FileWriter("Buergeraemter.csv", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) {
		Buergeramt burg = (Buergeramt) object;
		try {
			writer.write(burg.gibBuergeramtZurueck(';'));
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
