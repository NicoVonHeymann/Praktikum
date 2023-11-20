package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class TextProduct  extends Product {

	BufferedWriter writer;
	
	public TextProduct() throws IOException {
		writer = new BufferedWriter(
				new FileWriter("Buergeraemter.txt", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) {
		Buergeramt buergeramt = (Buergeramt) object;
		try {
			writer.write("Daten des B�rgeramts \n");
			writer.write(String.format("Name des B�rgeramts: \t\t" + buergeramt.getName() +  "\n"));
			writer.write(String.format("�ffnungszeit des B�rgeramts: \t\t" + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis() +  "\n"));
			writer.write(String.format("Stra�e und Hausnummer des B�rgeramts: \t\t" + buergeramt.getStrasseHNr() +  "\n"));
			writer.write(String.format("Dienstleistung des B�rgeramts: \t\t" + buergeramt.getDienstleistungenAlsString(',') +  "\n"));

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
