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
			writer.write("Daten des Bürgeramts \n");
			writer.write(String.format("Name des Bürgeramts: \t\t" + buergeramt.getName() +  "\n"));
			writer.write(String.format("Öffnungszeit des Bürgeramts: \t\t" + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis() +  "\n"));
			writer.write(String.format("Straße und Hausnummer des Bürgeramts: \t\t" + buergeramt.getStrasseHNr() +  "\n"));
			writer.write(String.format("Dienstleistung des Bürgeramts: \t\t" + buergeramt.getDienstleistungenAlsString(',') +  "\n"));

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
