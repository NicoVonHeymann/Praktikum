package gui.guiSteatischeEinrichtung;

import java.io.IOException;

import Observer.Observer;
import business.BuergeraemterModel;
import business.sporthallen.Sporthalle;
import business.sporthallen.SporthalleModel;
import gui.guiBueraemter.BuergeraemterView;
import javafx.stage.Stage;

public class SteadtischeEinichtungenControl implements Observer {
	
	private StaedtischeEinrichtungenView steadtischeEinrichtungView;
	private BuergeraemterModel buergeraemterModel;
	private SporthalleModel sporthalleModel;
	
	public SteadtischeEinichtungenControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.sporthalleModel = SporthalleModel.getInstance();
		this.steadtischeEinrichtungView = new StaedtischeEinrichtungenView(primaryStage, this, this.buergeraemterModel, this.sporthalleModel);
		this.buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		this.steadtischeEinrichtungView.zeigeBuergeraemterAn();
		// TODO Auto-generated method stub
		
	}
	
   

}
