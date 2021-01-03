/**
 * 
 */
package model;

import shopmanager.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mockitoSession;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import exceptions.NoEnoughStock;
import exceptions.NotInStock;
import exceptions.UnknownRepo;
import model.Product;
import model.Order;
import model.UnitsComparator;
import persistency.OrderRepository;
import shopManager.ProductTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;



/**
 * @author Elena Mosquera
 * Clase para realizar los test a la clase UnitsComparator
 *
 */
@ExtendWith(MockitoExtension.class)
class UnitsComparatorTest {
	
	//Se crean los mocks a utilizar (los dos productos que vamos a comprobar se ordenan correctamente)
	@Mock(serializable = true)
	private static Product producto1Mock= Mockito.mock(Product.class);
	@Mock(serializable = true)
	private static Product producto2Mock= Mockito.mock(Product.class);

	
	//Inyecci�n de dependencias
	//Los objetos contenidos en micestaTesteada son reemplazados autom�ticamente por los sustitutos (mocks)
	@InjectMocks
	private static UnitsComparator comparador;


  /**
   * Test para probar el método Compare  {@link model.UnitsCompaator#compare()}
   * Tres comprobaciones:  producto1 > producto2, producto1=producto2, producto1<producto2
   */
	
	@Test
	@Tag("unidad")
	@DisplayName("Producto 1 > Producto 2")
    void TestGreaterThan() {
		Mockito.when(producto1Mock.getNumber()).thenReturn(4);
		Mockito.when(producto2Mock.getNumber()).thenReturn(2);
		
		int result = comparador.compare(producto1Mock, producto2Mock);
		assertTrue(result >= 1, "Se espera un número positivo (cantidad de producto 1 es mayor que la del 2)");
	}
	
	@Test
	@Tag("unidad")
	@DisplayName("Producto 1 < Producto 2")
    void TestLessThan() {
		Mockito.when(producto1Mock.getNumber()).thenReturn(1);
		Mockito.when(producto2Mock.getNumber()).thenReturn(2);
		
		int result = comparador.compare(producto1Mock, producto2Mock);
		assertTrue(result <= -1, "Se espera un número negativo (cantidad de producto 2 es mayor que la del 1)");
	}
	
	@Test
	@Tag("unidad")
	@DisplayName("Producto 1 = Producto 2")
    void TestEqualThan() {
		Mockito.when(producto1Mock.getNumber()).thenReturn(2);
		Mockito.when(producto2Mock.getNumber()).thenReturn(2);
		
		int result = comparador.compare(producto1Mock, producto2Mock);
		assertTrue(result == 0, "Se espera un 0 (cantidad de producto 2 es igual que la del 1)");
	}
	
	


}
