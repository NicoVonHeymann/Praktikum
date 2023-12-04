package gui.guiSteatischeEinrichtung;

import Observer.Observer;
import business.BuergeraemterModel;
import gui.guiBueraemter.BuergeraemterView;
import javafx.stage.Stage;

public class SteadtischeEinichtungenControl implements Observer {
	
	private StaedtischeEinrichtungenView steadtischeEinrichtungView;
	private BuergeraemterModel buergeraemterModel;
	
	public SteadtischeEinichtungenControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.steadtischeEinrichtungView = new StaedtischeEinrichtungenView(primaryStage, this, this.buergeraemterModel);
		this.buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		this.steadtischeEinrichtungView.zeigeBuergeraemterAn();
		// TODO Auto-generated method stub
		
	}

}
