package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class TestKonstruktorBuergeramt1 {


	@Test
	void test() {
		String[] dienstleistung = new String[] {"Hauptwohmsitz", "Nebenwohnsitz"};  
		Buergeramt buergeramt = new Buergeramt("Bürgerbüro Querenburg", 9.00f, 17.00f, "Querenburger Höhe 256", dienstleistung);
		
		BooleanSupplier isNameCorrect = () ->  {
			if( buergeramt.getName() == "Bürgerbüro Querenburg") {
				return true;

			}
			return false;
		};
		assertTrue(isNameCorrect.getAsBoolean());
	}

}
