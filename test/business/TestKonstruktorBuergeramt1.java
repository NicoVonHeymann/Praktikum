package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class TestKonstruktorBuergeramt1 {


	@Test
	void test() {
		String[] dienstleistung = new String[] {"Hauptwohmsitz", "Nebenwohnsitz"};  
		Buergeramt buergeramt = new Buergeramt("B�rgerb�ro Querenburg", 9.00f, 17.00f, "Querenburger H�he 256", dienstleistung);
		
		BooleanSupplier isNameCorrect = () ->  {
			if( buergeramt.getName() == "B�rgerb�ro Querenburg") {
				return true;

			}
			return false;
		};
		assertTrue(isNameCorrect.getAsBoolean());
	}

}
