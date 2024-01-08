package gui.guiBueraemter;

import java.io.IOException;

import Observer.Observer;
import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.stage.Stage;

public class BuergeraemterControl implements Observer {
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;
	
	public BuergeraemterControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.buergeraemterView = new BuergeraemterView(primaryStage, this, this.buergeraemterModel);
		this.buergeraemterModel.addObserver(this);
	}
	
	
	 void nehmeBuergeramtAuf(){
	    	try{
	    		this.buergeraemterModel.addBuergeramt( new Buergeramt(
	    			this.buergeraemterView.getTxtName().getText(), 
	   	            Float.parseFloat(this.buergeraemterView.getTxtGeoeffnetVon().getText()),
	   	            Float.parseFloat(this.buergeraemterView.getTxtGeoeffnetBis().getText()),
	   	         this.buergeraemterView.getTxtStrasseHNr().getText(),
	   	      this.buergeraemterView.getTxtDienstleistungen().getText().split(";")));
	    		//this.buergeraemterView.zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
	    		buergeraemterModel.notifyObserver();
	       	}
	       	catch(Exception exc){
	       		this.buergeraemterView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	   }
	   
	    void zeigeBuergeraemterAn(){
	    	if(this.buergeraemterModel.getBuergeramt() != null){
	    		String ausgabe = "";
	    		for (Buergeramt buergeramt : this.buergeraemterModel.getBuergeramt()) {
					ausgabe += buergeramt.gibBuergeramtZurueck(' ');
				}
	    		this.buergeraemterView.getTxtAnzeige().setText(
	    				ausgabe);
	    	}
	    	else{
	    		this.buergeraemterView.zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
	    	}
	    }
	    
	    void schreibeBuergeraemterInDatei(String typ) throws IOException {
	    	try {
	    		if("csv".equals(typ)) {
	    			this.buergeraemterModel.schreibeBuergeraemterInCsvDatei();
	    		}
	    		else if("txt".equals(typ)){
	    			this.buergeraemterModel.schreibeBuergeraemterInTextDatei();
	    		}
	    		else {
	    			buergeraemterView.zeigeInformationsfensterAn("Noch nicht implentiert");
	    		}
	    	}
	    	catch (Exception exc) {
				buergeraemterView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
			}
	    }


		@Override
		public void update() {
			zeigeBuergeraemterAn();
			
		}

}
