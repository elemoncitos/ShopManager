package shopManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import model.Product;
import model.IdComparator;

class IdComparatorTest {
	@Mock(serializable = true)
	private static Product producto1Mock= Mockito.mock(Product.class);
	@Mock(serializable = true)
	private static Product producto2Mock= Mockito.mock(Product.class);
	IdComparator comparador = new IdComparator();
	
	@Test
	@Tag("unidad")
	@DisplayName("Prueba del metodo que compara dos Id")
	void testCompare() {
		
		//MyProduct producto1 = new MyProduct("Producto1");
		//MyProduct producto2 = new MyProduct("Producto2");
		Mockito.when(producto1Mock.getId()).thenReturn("aaaa");
		Mockito.when(producto2Mock.getId()).thenReturn("aaaa");
		//Probamos el caso de precios de igual id
		assertEquals(0, comparador.compare(producto1Mock, producto2Mock), "El comparador no detecta que los precios son iguales");
		//Probamos el caso de que el segundo precio sea mayor
		Mockito.when(producto2Mock.getId()).thenReturn("zzzz");
		assertTrue(comparador.compare(producto1Mock, producto2Mock)<0,"El comparador no detecta que el segundo precio es mayor");
		//Probamos el caso de que el primer precio sea mayor
		assertTrue(comparador.compare(producto2Mock, producto1Mock)>0,"El comparador no detecta que el primer precio es mayor");
	}

}
