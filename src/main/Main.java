package main;

import gui.guiBueraemter.BuergeraemterControl;
import gui.guiSteatischeEinrichtung.SteadtischeEinichtungenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemterControl(primaryStage);
		Stage fensterSteaedtischeEinrichtungen = new Stage();
		new SteadtischeEinichtungenControl(fensterSteaedtischeEinrichtungen);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
