package app.ito.poo;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import clases.ito.poo.cuentaBancaria;
import clases.ito.poo.cuentasbancarias;
import txt.ito.poo.escritorArchivo;
import txt.ito.poo.lectorArchivo;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepcion.ito.poo.ActCuenta;
import excepcion.ito.poo.DeleteCuenta;
import excepcion.ito.poo.DepositoCuenta;
import excepcion.ito.poo.NumberCuenta;
import excepcion.ito.poo.RetiroCuenta;
import excepcion.ito.poo.SaldoCuenta;

public class Aplicacion {

	static cuentasbancarias c;
	static cuentaBancaria e;
	static escritorArchivo escArchivo;
	static lectorArchivo lecArchivo;
	
	static void menu() throws NumberCuenta, SaldoCuenta, RetiroCuenta, DepositoCuenta, HeadlessException, ActCuenta, DeleteCuenta, FileNotFoundException {
		Comenzar();
		IniciarP();
		final JPanel pnel=new JPanel();
		boolean error=true;
		while(error) {
		try {
		boolean periodo=true;
		int replica=0;
		while(periodo) {
		String funciones="<< INDIQUE LA ACCION QUE DESEA REALIZAR >>\n "
				+ "1)Agregar una nueva cuenta\n "
				+ "2)Mostrar las cuentas existentes\n "
				+ "3)Realizar un depósito a una cuenta\n"
				+ "4)Hacer un retiro\n "
				+ "5)Eliminar cuenta\n "
				+ "6)Consultar saldo\n "
				+ "7)Exit";
		
		replica=Integer.parseInt(JOptionPane.showInputDialog(funciones));
		switch(replica) {
		case 1:agregarCuenta();break;
		case 2:mostrarCuentas();break;
		case 3:hacerDepositoCuenta();break;
		case 4:hacerRetiroCuenta();break;
		case 5:DeleteCuenta();break;
		case 6:consulta();break;
		case 7:grabarRegistro();periodo=false;error=false;break;
		default:JOptionPane.showMessageDialog(null,"Ingrese la accion que desea realizar");
		  }
		}
		
		
		}catch(NumberCuenta e){
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}catch(SaldoCuenta e) {
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}catch(DepositoCuenta e) {
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}catch(RetiroCuenta e) {
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}catch(ActCuenta e) {
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}catch(DeleteCuenta e) {
			JOptionPane.showMessageDialog(pnel,e.getMessage(),"Error!!", JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	
	static cuentaBancaria capturarCuenta() throws NumberCuenta,SaldoCuenta {
		cuentaBancaria b=new cuentaBancaria();
		
		long l;String date,nombre;float SaldoCuenta;
		
		l=Long.parseLong(JOptionPane.showInputDialog("Introduzca el numero de cuenta:"));
		
		nombre=JOptionPane.showInputDialog("Introduzca su nombre:");
		
		SaldoCuenta=Float.parseFloat(JOptionPane.showInputDialog("Saldo de cuenta"));
		
		date=JOptionPane.showInputDialog("Fecha de la apertura:");
		
		b.setNumberCuenta(l);
		b.setNomCliente(nombre);
		b.setSaldoCuenta(SaldoCuenta);
		b.setFechaApertura(LocalDate.parse(date));
		return b;
	}
	
	
	
	static void Comenzar() {
		c=new cuentasbancarias();
	}
	
	static void agregarCuenta() throws NumberCuenta, SaldoCuenta, HeadlessException, ActCuenta {
		cuentaBancaria nuevo;
		nuevo=capturarCuenta();
		c.ActCuenta(nuevo);
		c.addItem(nuevo);
	    JOptionPane.showMessageDialog(null,"Se ha agregado la cuenta exitosamente");
			if(c.isFull())
				c.aumentarArreglos();
		
	}
	
	static void mostrarCuentas() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuenta registrada en el sistema");
		else {
		String cuentas="";
		for(int i=0;i<c.getSize();i++)
			cuentas=cuentas+"\n"+(c.getItem(i));
		JOptionPane.showMessageDialog(null,cuentas);
		}
	}
	
	
	static void hacerDepositoCuenta() throws SaldoCuenta, DepositoCuenta {
		int pos=0;
		float cantidad=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay ninguna cuenta registrada");
		else {
			boolean bandera=true;
			while(bandera) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(c.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la cuenta de la que quiere hacer el deposito"+cuentas));
		    if((c.getSize())>=pos&&pos>0) {
		    cantidad=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad"));
		    c.DepositoCuenta(cantidad);
		    c.getItem(pos-1).setSaldoCuentaActualizado(c.getItem(pos-1).getSaldoCuenta()+cantidad);
		    c.getItem(pos-1).setFechaActualizacion(LocalDate.now());
		    JOptionPane.showMessageDialog(null,"Su deposito se realizo con exito");
		    bandera=false;
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"Cuenta no disponible");
			}
		}
	}
	
	
	static void hacerRetiroCuenta() throws SaldoCuenta, RetiroCuenta {
		int de=0;
		float cantidad=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		else {
			boolean bandera=true;
			while(bandera) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(c.getItem(i));
		    de=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la cuenta de la que quiere hacer el retiro"+cuentas));
		    if((c.getSize())>=de&&de>0) {
		    cantidad=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad"));
		    c.RetiroCuenta(cantidad);
		    if(!(c.getItem(de-1).getSaldoCuenta()<cantidad)) {
		    c.getItem(de-1).setSaldoCuentaActualizado(c.getItem(de-1).getSaldoCuenta()-cantidad);
		    c.getItem(de-1).setFechaActualizacion(LocalDate.now());
		    JOptionPane.showMessageDialog(null,"No hay saldo suficiente");
		          }
		       }
			}
		}
	}
	
	
	
	static void DeleteCuenta() throws DeleteCuenta {
		int de=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		else {
			boolean comprob=true;
			while(comprob) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+(i+1)+")"+(c.getItem(i));
		    de=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la cuenta que desea borrar"+cuentas));
		    if((c.getSize())>=de&&de>0) {
		    	c.DeleteCuenta(c.getItem(de-1));
		    	c.clear(c.getItem(de-1));
		    	JOptionPane.showMessageDialog(null,"Cuenta borrada exitosamente!");
		    	comprob=false;
		    }	
		    else
		    	JOptionPane.showMessageDialog(null,"No hay cuentas");
		    }
		}
	}
	
	
	static void consulta() {
		int replica=0;
		boolean periodo=true;
		while(periodo) {
		
			String funciones="Seleccione la accion que desea realizar:\n "
					
					+ "1)Verificar el saldo actual de todas las cuentas\n "
					+ "2)Promedio del saldo de las cuentas\n"
					+ "3)Mostrar cuentas con mas de 10 mil\n"
					+ "4)Cuentas con saldo lleno.\n "
					+ "5)Cuentas con un saldo mínimo\n"
					+ "6)Exit";
			
		replica=Integer.parseInt(JOptionPane.showInputDialog(funciones));
		
		switch(replica) {
		
		case 1:totalMonto();periodo=false;break;
		case 2:promedio();periodo=false;break;
		case 3:mayordiez();periodo=false;break;
		case 4:maximoSaldo();periodo=false;break;
		case 5:minimoSaldo();periodo=false;break;
		case 6:periodo=false;break;
		
		default:JOptionPane.showMessageDialog(null,"Seleccione la accion a realizar");
		
		    }
		}
	}
	
	
	static void totalMonto() {
		
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		
		else {
		    float totalMonto=0;
		    for(int i=0;i<c.getSize();i++) 
			    totalMonto=totalMonto+c.getItem(i).getSaldoCuenta();
		    JOptionPane.showMessageDialog(null,"Su monto es: $"+totalMonto);
		}
	}
	
	
	static void promedio() {
		float montoProm=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		else {
		    float totalMonto=0;
		    for(int i=0;i<c.getSize();i++) 
		        totalMonto=totalMonto+c.getItem(i).getSaldoCuenta();
		    montoProm=totalMonto/c.getSize(); 
		    JOptionPane.showMessageDialog(null,"Su monto es: $"+montoProm);
		}
	}
	
	
	static void mayordiez() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		else {
			int vacio=0;
			cuentaBancaria diez[]=new cuentaBancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldoCuenta()>10000) 
					diez[i-vacio]=c.getItem(i);
				else
					vacio++;
			String cuentasB="";
			for(int j=0;j<(c.getSize()-vacio);j++)
				cuentasB=cuentasB+"\n"+diez[j];
			JOptionPane.showMessageDialog(null,"Cuentas con un saldo mayor a $10,000:"+cuentasB);
		}
	}
	
	
	
	static void maximoSaldo() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"No hay cuentas disponibles");
		else {
			int huero=0;
			float maximo=c.getItem(0).getSaldoCuenta();
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldoCuenta()>maximo)
					maximo=c.getItem(i).getSaldoCuenta();
			cuentaBancaria copia[]=new cuentaBancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldoCuenta()==maximo) 
					copia[i-huero]=c.getItem(i);
				else
					huero++;
			String cuentas="";
			for(int j=0;j<(c.getSize()-huero);j++)
				cuentas=cuentas+"\n"+copia[j];
			JOptionPane.showMessageDialog(null,"Cuenta con la mayor cantidad de saldo:\n"+cuentas);
		}
	}
	
	
	static void minimoSaldo() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Sin cuentas en el sistema");
		else {
			int huero=0;
			float minimo=c.getItem(0).getSaldoCuenta();
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldoCuenta()<minimo)
					minimo=c.getItem(i).getSaldoCuenta();
			cuentaBancaria copia[]=new cuentaBancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldoCuenta()==minimo) 
					copia[i-huero]=c.getItem(i);
				else
					huero++;
			String cuentas="";
			for(int j=0;j<(c.getSize()-huero);j++)
				cuentas=cuentas+"\n"+copia[j];
			JOptionPane.showMessageDialog(null,"Cuentas con saldo menor"+cuentas);
		}
	}
	

	static void grabarRegistro() throws FileNotFoundException {
		if (c.isFree()) {
			
		}
		
		else {
			escArchivo=new escritorArchivo("guardacuentas");
			for(int i=0;i<c.getSize();i++) {
				escArchivo.writeLong(c.getItem(i).getcuentaNumero());
				escArchivo.writeString(c.getItem(i).getNomCliente());
				escArchivo.writeFloat(c.getItem(i).getSaldoCuenta());
				if(c.getItem(i).getFechaActualizacion()==null) {
					escArchivo.writeString(c.getItem(i).getFechaApertura().toString());	
				}
				
				else {
					escArchivo.writeString(c.getItem(i).getFechaApertura().toString());
					escArchivo.writeStringLn(c.getItem(i).getFechaActualizacion().toString());	
				}
				
			}
			escArchivo.close();
		}
					
	}
	
	static void IniciarP() throws FileNotFoundException, NumberCuenta, ActCuenta {
		boolean hay=false;
		try {
			lecArchivo= new lectorArchivo("guardacuentas");
			hay=true;
		}catch(FileNotFoundException e) {
			System.err.println("Cuenta existente, creando nueva");
		}
		if(hay)
			LTexto();
		
	}
	
static void LTexto() throws NumberCuenta, ActCuenta {
		
		while(!lecArchivo.isEOF()) {
			e=new cuentaBancaria();
			e.setNumberCuenta(lecArchivo.readLong());
			e.setNomCliente(lecArchivo.readString());
			e.setSaldoCuentaActualizado(lecArchivo.readFloat());
			e.setFechaApertura(LocalDate.parse(lecArchivo.readString()));
			String fechaAct;
			fechaAct=lecArchivo.readString();
			if(fechaAct.equals("null")) 
				e.setFechaActualizacion(null);
			else
				e.setFechaActualizacion(LocalDate.parse(fechaAct));
			c.addItem(e);
			lecArchivo.isFinLinea();
		
			
		}
	}
}