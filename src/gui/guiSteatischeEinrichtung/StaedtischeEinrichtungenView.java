package gui.guiSteatischeEinrichtung;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import business.sporthallen.Sporthalle;
import business.sporthallen.SporthalleModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	// Hier ergaenzen
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraeamter     
 		= new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeSporthalle  = new TextArea();
    	private TextArea txtAnzeigeBuergeraeamter  = new TextArea();
    	private Button btnAnzeigeBuergeraeamter = new Button("Anzeige");
    	private Button csvImportSporthallen = new Button("csv-import und Anzeigen");

    	//-------Ende Attribute der grafischen Oberflaeche-------
    	
    	private BuergeraemterModel buergeraemterModel;
    	private SporthalleModel sporthalleModel;
    	private SteadtischeEinichtungenControl steadtischeEinichtungenControl;
    	
    
    	public StaedtischeEinrichtungenView(Stage primaryStage, SteadtischeEinichtungenControl steadtischeEinichtungenControl, BuergeraemterModel buergeraemterModel, SporthalleModel sporthalleModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		this.sporthalleModel = sporthalleModel;
    		this.buergeraemterModel = buergeraemterModel;
    		this.steadtischeEinichtungenControl = steadtischeEinichtungenControl;
    		
    		// Hier ergaenzen


		this.initKomponenten();
		this.initKomponentenSporthalle();
		this.initListener();
		this.initListenerSporthalle();
    	}
    	
    	private void initKomponentenSporthalle() {
    		txtAnzeigeSporthalle.setEditable(false);
           	txtAnzeigeSporthalle.setLayoutX(10);
           	txtAnzeigeSporthalle.setLayoutY(90);
           	txtAnzeigeSporthalle.setPrefWidth(220);
           	txtAnzeigeSporthalle.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeSporthalle);

           	csvImportSporthallen.setLayoutX(10);
        	csvImportSporthallen.setLayoutY(290);
            pane.getChildren().add(csvImportSporthallen); 
    	}

    	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
 		lblAnzeigeBuergeraeamter.setLayoutX(310);
 		lblAnzeigeBuergeraeamter.setLayoutY(40);
 		lblAnzeigeBuergeraeamter.setFont(font);
 		lblAnzeigeBuergeraeamter.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBuergeraeamter);    
        	


       	// Textbereich
       	txtAnzeigeBuergeraeamter.setEditable(false);
       	txtAnzeigeBuergeraeamter.setLayoutX(310);
       	txtAnzeigeBuergeraeamter.setLayoutY(90);
       	txtAnzeigeBuergeraeamter.setPrefWidth(220);
       	txtAnzeigeBuergeraeamter.setPrefHeight(185);
       	
       	
       	
       	
       	pane.getChildren().add(txtAnzeigeBuergeraeamter);
        	// Button
       	btnAnzeigeBuergeraeamter.setLayoutX(310);
       	btnAnzeigeBuergeraeamter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBuergeraeamter); 
        	
   
   }
   
   private void initListener() {
	   btnAnzeigeBuergeraeamter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
	   
	  
    }
   
   private void initListenerSporthalle() {
	   csvImportSporthallen.setOnAction(
	 			new EventHandler<ActionEvent>() {
		    		@Override
		        	public void handle(ActionEvent e) {
		    			try {
							csvImportUndAnzeige();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	} 
	   	    });
   }
   
    public void zeigeBuergeraemterAn(){
    		if(buergeraemterModel.getBuergeramt() != null){
    			String ausgabe = "";
	    		for (Buergeramt buergeramt : this.buergeraemterModel.getBuergeramt()) {
					ausgabe += buergeramt.gibBuergeramtZurueck(' ');
				}
    			txtAnzeigeBuergeraeamter.setText(
    					ausgabe);
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}
    }	
    
    public void csvImportUndAnzeige() throws IOException{
    	this.sporthalleModel.leseSporthalleAusCsvDatei();
		if(sporthalleModel.getSporthallen() != null){
			String ausgabe = "";
    		for (Sporthalle sporthalle : sporthalleModel.getSporthallen()) {
				ausgabe += sporthalle.gibSporthalleZurueck(' ');
			}
			this.txtAnzeigeSporthalle.setText(
					ausgabe);
		}
		else{
			zeigeInformationsfensterAn(
				"Bisher wurde kein sporthalle aufgenommen!");
		}
}
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    
    
}
