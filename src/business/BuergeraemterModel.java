package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Observer.Observable;
import Observer.Observer;
import fabrik.Creator;
import fabrik.CsvCreator;
import fabrik.Product;
import fabrik.TextCreator;
import javafx.beans.InvalidationListener;

public class BuergeraemterModel implements Observable {
	private ArrayList<Buergeramt>  buergeramt =  new ArrayList<Buergeramt>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private static BuergeraemterModel instance = null;

	public ArrayList<Buergeramt> getBuergeramt() {
		return buergeramt;
	}
	
	private BuergeraemterModel() {
		
	}
	
	public static BuergeraemterModel getInstance() {
		if (instance == null) {
			instance = new BuergeraemterModel();
		}
		return instance;
	}

	public void addBuergeramt(Buergeramt buergeramt) {
		this.buergeramt.add(buergeramt);
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

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}


}
