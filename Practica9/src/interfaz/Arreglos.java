package interfaz;

import excepcion.ito.poo.*;

public interface Arreglos<T> {
	
	public boolean addItem(T item) throws ActCuenta;
	public boolean existeItem(T item);
	public T getItem(int pos);
	public int getSize();
	public boolean clear(T item);
	public boolean isFree();
	public boolean isFull();
}