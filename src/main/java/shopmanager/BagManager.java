/**
 * 
 */
package shopmanager;

/**
 * @author isa
 *
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import exceptions.NoEnoughStock;
import exceptions.NotInStock;
import model.Product;
import model.Order;

/**
 * @author Isabel Romï¿½n
 * Gestor de la cesta de la compra
 *
 */
public interface BagManager {
	

	/**
	 * 
	 * Aï¿½ade a la cesta tantas unidades del producto pasado como parï¿½metro como indique getNumber() del mismo, actualiza Stock eliminado las unidades aï¿½adidas
	 * 
	 * @param newProduct producto a aï¿½adir, en el nï¿½mero de unidades se indica cuï¿½ntas unidades se aï¿½aden
	 * debe verificar si hay en stock, si no no se aï¿½aden y deberï¿½a lanzar la excepciï¿½n NoEnoughStock
	 * actualiza stock disminuyendo el nï¿½mero de unidades aï¿½adidas y aumenta el nï¿½mero de unidades en la cesta
	 * @return El producto tal y como estï¿½ en la cesta
	 * @throws NoEnoughStock si el nï¿½mero de unidades en el stock no es suficiente
	 * @throws NotInStock si el producto no existe en el stock
	 */
	Product addProduct(Product newProduct) throws NoEnoughStock,NotInStock;
	/**
	 * 
	 * Elimina de la cesta tantas unidades del producto pasado como parï¿½metro como indique getNumber() del mismo, el nï¿½mero mï¿½nimo de unidades final es cero
	 * 
	 * @param oldProduct producto a eliminar, se eliminan las unidades que se marquen, actualiza stock aumentando estas unidades liberadas
	 * @return newProduct, el producto, indicando el nï¿½mero de unidades que quedan en la cesta
	 * @throws NotInStock si el producto no estaba en el stock
	 */
	Product lessProduct(Product oldProduct) throws NotInStock;
	/**
	 * Elimina completamente el producto, actualiza stock sumando las unidades liberadas
	 * 
	 * @param oldProduct el producto con el nï¿½mero de elementos que se quieren liberar
	 * @return devuelve true si se eliminï¿½, false si el producto no estaba en la cesta
	 * @throws NotInStock si no existï¿½a en el stock este producto
	 * 
	 */
	boolean removeProduct(Product oldProduct) throws NotInStock;
	/**
	 * 
	 * Elimina completamente el producto, actualiza stock sumando las unidades liberadas
	 * 
	 * @param productId el producto que se quiere eliminar
	 * @throws NotInStock si el producto no estaba en el stock
	 */
	void removeProduct(String productId) throws NotInStock;
	
	/**
	 * 
	 * Obtiene la cesta como una colecciï¿½n (Sea cual sea la forma interna de almacenar los productos)
	 * @return devuelve la cesta como una lista de productos
	 */
	Collection<Product> getBag();
	/**
	 * 
	 * Devuelve el producto cuyo id se pasa como parï¿½metro encapsulado en un objeto Optional
	 * @see java.util.Optional
	 * @param productId el id del producto a buscar
	 * @return el producto, con el nï¿½mero de unidades del mismo, si es cero es que no estaba en la cesta
	 */
	Optional<Product> findProduct(String productId);
	/**
	 * 
	 * Devuelve el producto de la bolsa que se corresponde con el id del pasado, encapsulado en un objeto Optional
	 * @see java.util.Optional
	 * @param product producto a buscar
	 * @return el producto, con el nï¿½mero de unidades del mismo, si es cero es que no estaba en la cesta
	 */
	Optional<Product> findProduct(Product product);
	/**
	 * Realiza el pedido, persistiendo los datos del mismo en el repositorio
	 * @return devuelve el pedido
	 */
	Order order();
	
	/**
	 * Inicializa la cesta a cero, borra todo lo que habï¿½a restaurando el stock
	 */
	void reset();
	/**
	 * 
	 * @return un iterador que recorre la cesta por orden de precio de mayor a menor
	 */
	Iterator<Product> getPrizeIterator();
	/**
	 * 
	 * @return un iterador que recorre la cesta por orden del id
	 */
	Iterator<Product> getIdIterator();
	/**
	 * 
	 * @return un iterador que recorre la cesta por número de unidades, de más a menos
	 */
	Iterator<Product> getUnitsIterator();

}
