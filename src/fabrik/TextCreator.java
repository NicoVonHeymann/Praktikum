package fabrik;

import java.io.IOException;

public class TextCreator extends Creator {

	@Override
	public Product factoryMethod() {
		try {
			return new TextProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		// TODO Auto-generated method stub
		return null;
	}
	

}
