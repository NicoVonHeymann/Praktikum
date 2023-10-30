package gui;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.stage.Stage;

public class BuergeraemterControl {
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;
	
	public BuergeraemterControl(Stage primaryStage) {
		this.buergeraemterModel = new BuergeraemterModel();
		this.buergeraemterView = new BuergeraemterView(primaryStage, this, this.buergeraemterModel);
	}
	
	
	 void nehmeBuergeramtAuf(){
	    	try{
	    		this.buergeraemterModel.setBuergeramt( new Buergeramt(
	    			this.buergeraemterView.getTxtName().getText(), 
	   	            Float.parseFloat(this.buergeraemterView.getTxtGeoeffnetVon().getText()),
	   	            Float.parseFloat(this.buergeraemterView.getTxtGeoeffnetBis().getText()),
	   	         this.buergeraemterView.getTxtStrasseHNr().getText(),
	   	      this.buergeraemterView.getTxtDienstleistungen().getText().split(";")));
	    		this.buergeraemterView.zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		this.buergeraemterView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	   }
	   
	    void zeigeBuergeraemterAn(){
	    	if(this.buergeraemterModel.getBuergeramt() != null){
	    		this.buergeraemterView.getTxtAnzeige().setText(
	    				this.buergeraemterModel.getBuergeramt().gibBuergeramtZurueck(' '));
	    	}
	    	else{
	    		this.buergeraemterView.zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
	    	}
	    }
	    
	    void schreibeBuergeraemterInDatei(String typ) throws IOException {
	    	try {
	    		if("csv".equals(typ)) {
	    			this.buergeraemterModel.schreibeBuergeraemterInCsvDatei();
	    		}else {
	    			buergeraemterView.zeigeInformationsfensterAn("Noch nicht implentiert");
	    		}
	    	}
	    	catch (Exception exc) {
				buergeraemterView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
			}
	    }

}
