package fabrik;

import java.io.IOException;

public class CsvCreator  extends Creator {

	@Override
	public Product factoryMethod() {
		try {
			return new CsvProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		// TODO Auto-generated method stub
		return null;
	}

}
