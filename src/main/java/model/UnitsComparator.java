package model;

import java.util.Comparator;

public class UnitsComparator implements Comparator<Product> 
{
	//https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#compare-T-T-
	@Override
	public int compare(Product o1, Product o2) 
	{
		int num_o1= o1.getNumber();
		int num_o2= o2.getNumber();
		int resultado=num_o2-num_o1; //comparo
		return resultado;
	}
}