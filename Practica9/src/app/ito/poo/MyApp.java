package app.ito.poo;


import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import clases.ito.poo.cuentasbancarias;
import txt.ito.poo.escritorArchivo;
import txt.ito.poo.lectorArchivo;
import excepcion.ito.poo.ActCuenta;
import excepcion.ito.poo.DeleteCuenta;
import excepcion.ito.poo.DepositoCuenta;
import excepcion.ito.poo.NumberCuenta;
import excepcion.ito.poo.RetiroCuenta;
import excepcion.ito.poo.SaldoCuenta;

public class MyApp {
	
	static cuentasbancarias c=new cuentasbancarias();
	static escritorArchivo esArchivo;
	static lectorArchivo lecArchivo;
	
	static void run() throws HeadlessException, NumberCuenta, SaldoCuenta, RetiroCuenta, DepositoCuenta, ActCuenta, DeleteCuenta, FileNotFoundException {
		
		Aplicacion.menu();
		   
		
    }

		static void crearArchivo() throws FileNotFoundException {
			esArchivo = new escritorArchivo("guarda cuentas");
		}
		public static void main(String[] args) throws HeadlessException, NumberCuenta, SaldoCuenta, RetiroCuenta, DepositoCuenta, ActCuenta, DeleteCuenta, FileNotFoundException {
			run();
		}
}
	