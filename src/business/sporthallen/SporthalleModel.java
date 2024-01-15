package business.sporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class SporthalleModel {
	
	private ArrayList<Sporthalle>  sporthalle =  new ArrayList<Sporthalle>();
	
	private static SporthalleModel instance = null;

	public ArrayList<Sporthalle> getSporthallen() {
		return sporthalle;
	}
	
	private SporthalleModel() {
		
	}
	
	public static SporthalleModel getInstance() {
		if (instance == null) {
			instance = new SporthalleModel();
		}
		return instance;
	}

	public void addBuergeramt(Sporthalle sporthalle) {
		this.sporthalle.add(sporthalle);
	}
	
	public void leseSporthalleAusCsvDatei() throws IOException {
		BufferedReader ein = new BufferedReader(
				new FileReader("Sporthallen.csv")
				);
		ArrayList<Sporthalle> ergebnis = new ArrayList<Sporthalle>();
		String zeileStr = ein.readLine();
		
		while(zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], Integer.parseInt(zeile[1]), zeile[2]));
			zeileStr = ein.readLine();
		}
		
		ein.close();
		this.sporthalle = ergebnis;
				
	}

}
