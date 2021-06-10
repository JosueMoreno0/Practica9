package clases.ito.poo;

import java.io.Serializable;
import java.time.LocalDate;

import excepcion.ito.poo.NumberCuenta;
import excepcion.ito.poo.SaldoCuenta;

@SuppressWarnings("Serializable")
public class cuentaBancaria implements Comparable<cuentaBancaria>, Serializable {
	
	static cuentasbancarias c;
	
	private long cuentaNumero = 0L;
	private String nomCliente = "";
	private float SaldoCuenta = 0F;
	private LocalDate fechaApertura = null;
	private LocalDate fechaActualizacion = null;
	
	public cuentaBancaria() {
		
		super();
		
	}
	
	private void NumberCuenta(long cuentaNumero) throws NumberCuenta{
		if (9999>=cuentaNumero)
			throw new NumberCuenta("No es posible crear una cuenta menor a $9999");
	}
	
	private void SaldoCuenta(float saldoCuenta) throws SaldoCuenta{
		if (saldoCuenta<5000F)
			throw new SaldoCuenta("Se debe tener por lo menos 5000$ para crear una cuenta");
	}
	
	
	
	
	public cuentaBancaria(long cuentaNumero, String nomCliente, float saldoCuenta, LocalDate fechaApertura)
			throws NumberCuenta,SaldoCuenta {
		super();
		NumberCuenta(cuentaNumero);
		this.cuentaNumero = cuentaNumero;
		this.nomCliente = nomCliente;
		SaldoCuenta(saldoCuenta);
		SaldoCuenta = saldoCuenta;
		this.fechaApertura = fechaApertura;
	}
	
	public boolean Deposito(float Cantidad)throws SaldoCuenta {
		boolean Deposito = false;
		if(this.fechaApertura==null)
			System.out.println("No existe esta cuenta");
		else {
			Deposito = true;
			this.setSaldoCuenta(this.getSaldoCuenta()+Cantidad);
			this.fechaActualizacion=LocalDate.now();
		}
		
		return Deposito;
	}
	

	public boolean Retiro(float Cantidad)throws SaldoCuenta {
		
		boolean Retiro = false;
		if(Cantidad<=this.getSaldoCuenta()) {
			Retiro = true;
			this.setSaldoCuenta(this.getSaldoCuenta()-Cantidad);
			this.fechaActualizacion=LocalDate.now();
		}
		else
			System.out.println("Usted no cuenta con el saldo suficiente");
		return Retiro;
	}

	
	public long getcuentaNumero() {
		
		return this.cuentaNumero;
	}

	public void setNumberCuenta(long newcuentaNumero)throws NumberCuenta {
		NumberCuenta(newcuentaNumero);
		this.cuentaNumero = newcuentaNumero;
	}

	
	public String getNomCliente() {
		return this.nomCliente;
	}

	
	public void setNomCliente(String newNomCliente) {
		this.nomCliente = newNomCliente;
	}

	public float getSaldoCuenta() {
		return this.SaldoCuenta;
	}

	public void setSaldoCuenta(float newSaldoCuenta)throws SaldoCuenta {
		SaldoCuenta(newSaldoCuenta);
		this.SaldoCuenta = newSaldoCuenta;
	}
	
	public void setSaldoCuentaActualizado(float newSaldoCuenta) {
		this.SaldoCuenta = newSaldoCuenta;
	}

	public LocalDate getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(LocalDate newFechaApertura) {
		this.fechaApertura = newFechaApertura;
	}

	public LocalDate getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate newFechaActualizacion) {
		this.fechaActualizacion = newFechaActualizacion;
	}

	@Override
	public String toString() {
		return "cuentaBancaria [cuentaNumero=" + cuentaNumero + ", nomCliente=" + nomCliente + ", SaldoCuenta=" + SaldoCuenta
				+ ", fechaApertura=" + fechaApertura + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	@Override
	public int compareTo(cuentaBancaria o) {
		int compare=0;
		if (this.cuentaNumero<o.getcuentaNumero())
			compare=-1;
		else if(this.cuentaNumero>o.getcuentaNumero())
			compare=1;
		return compare;
		
	}

}