package business;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestKonstruktorFehlermeldung {


	@Test
	void test() {
		IllegalArgumentException t =  assertThrows(IllegalArgumentException.class, () ->  {new Buergeramt("B�rgerb�ro Querenburg", 9.00f, 17.00f, "Querenburger H�he 256", null);});	
		assertEquals(t.getMessage(), "Dienstleistung is null");
	}

}
