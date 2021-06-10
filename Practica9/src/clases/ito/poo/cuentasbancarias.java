package clases.ito.poo;

import excepcion.ito.poo.ActCuenta;
import excepcion.ito.poo.DeleteCuenta;
import excepcion.ito.poo.DepositoCuenta;
import excepcion.ito.poo.RetiroCuenta;

import interfaz.Arreglos;
import clases.ito.poo.cuentaBancaria;


public class cuentasbancarias implements Arreglos <cuentaBancaria> {

	static cuentaBancaria e;

	private cuentaBancaria cuentas[]=null;
	private int ultimo=0;
	private final int INC=5;
	
	public cuentasbancarias() {
		super();
		this.cuentas=new cuentaBancaria[INC];
		this.ultimo=-1;
	}
	
	public void DepositoCuenta(float DepositoCuenta) throws DepositoCuenta{
		if (DepositoCuenta<500F||DepositoCuenta>25000F)
			throw new DepositoCuenta("El minimo para depositar es $500 y el maximo son $25000");
	}
	public void RetiroCuenta(float RetiroCuenta) throws RetiroCuenta{
		if (!((RetiroCuenta%100)==0) || RetiroCuenta<100 || RetiroCuenta>6000)
			throw new RetiroCuenta("No es posible hacer un retiro de $6000 o menos de $100 y multiplo del mismo");
	}
	
	public void ActCuenta(cuentaBancaria item) throws ActCuenta{
		if(this.existeItem(item)) {
			throw new ActCuenta("Esta cuenta ya existe");
		}
	}
	
	public void DeleteCuenta(cuentaBancaria item) throws DeleteCuenta{
		if(item.getSaldoCuenta()==0) {
			throw new DeleteCuenta("No es posible eliminar una cuenta con saldo disponible");
		}
	}
	
	
	
	public void aumentarArreglos() {
		cuentaBancaria Incrementa[]=new cuentaBancaria[this.cuentas.length+INC];
		for(int i=0;i<cuentas.length;i++)
			Incrementa[i]=this.cuentas[i];
		cuentas=Incrementa;
	}
	
	@Override
	public boolean addItem( cuentaBancaria item) throws ActCuenta {
		boolean add=false;
		
		if(this.isFull()) 
			aumentarArreglos();
		int j=0;
		for(;j<=this.ultimo;j++)
			if(item.compareTo(this.cuentas[j])<0) {
				break;
				}
				
				for(int i=this.ultimo;i>=j;i--)
					cuentas[i+1]=cuentas[i];
				this.cuentas[j]=item;
				this.ultimo++;
				add=true;
			
		return add;
	}

	@Override
	public boolean existeItem (cuentaBancaria item) {
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(this.cuentas[i])==0) {
				existe=true;
				break;
			}
					
		return existe;
	}
	
	

	@Override
	public cuentaBancaria getItem(int pos) {
		cuentaBancaria cb=null;
		if(pos<=this.ultimo&&!this.isFree())
			cb=this.cuentas[pos];
		return cb;
	}

	@Override
	public int getSize() {
		return this.ultimo+1;
	}

	@Override
	public boolean clear( cuentaBancaria item) {
		boolean delete=false;
		if(this.existeItem(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(this.cuentas[i])==0)
					break;
			for(;i<=this.ultimo;i++)
				cuentas[i]=cuentas[i+1];
			this.ultimo--;
			delete=true;
		}
		return delete;
	}

	@Override
	public boolean isFree() {
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		
		return this.ultimo+1==this.cuentas.length;
	}
}
