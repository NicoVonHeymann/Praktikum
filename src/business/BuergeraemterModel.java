package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.Creator;
import fabrik.CsvCreator;
import fabrik.Product;
import fabrik.TextCreator;

public class BuergeraemterModel {
	private Buergeramt  buergeramt;

	public Buergeramt getBuergeramt() {
		return buergeramt;
	}

	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
	}
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
		/**
		 * BufferedWriter aus = new BufferedWriter(
		
				new FileWriter("Buergeraemter.csv", true));
		
		aus.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
		aus.close();
		 */
		
		Creator csvCreator = new CsvCreator();
		Product csvProduct = csvCreator.factoryMethod();
		
		csvProduct.fuegeInDateiHinzu(this.buergeramt);
		csvProduct.schliesseDatei();
	}

	public void schreibeBuergeraemterInTextDatei() {
		Creator txtCreator = new TextCreator();
		Product txtProduct = txtCreator.factoryMethod();
		
		txtProduct.fuegeInDateiHinzu(this.buergeramt);
		txtProduct.schliesseDatei();
		
	}

}
