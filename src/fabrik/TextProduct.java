package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import business.Buergeramt;

public class TextProduct  extends Product {

	BufferedWriter writer;
	
	public TextProduct() throws IOException {
		writer = new BufferedWriter(
				new FileWriter("Buergeraemter.txt", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) {
		ArrayList<Buergeramt> buergeramt = (ArrayList<Buergeramt>) object;
		try {
			for (Buergeramt buergeramt2 : buergeramt) {
				writer.write("Daten des B�rgeramts \n");
				writer.write(String.format("Name des B�rgeramts: \t\t" + buergeramt2.getName() +  "\n"));
				writer.write(String.format("�ffnungszeit des B�rgeramts: \t\t" + buergeramt2.getGeoeffnetVon() + " - " + buergeramt2.getGeoeffnetBis() +  "\n"));
				writer.write(String.format("Stra�e und Hausnummer des B�rgeramts: \t\t" + buergeramt2.getStrasseHNr() +  "\n"));
				writer.write(String.format("Dienstleistung des B�rgeramts: \t\t" + buergeramt2.getDienstleistungenAlsString(',') +  "\n"));
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
