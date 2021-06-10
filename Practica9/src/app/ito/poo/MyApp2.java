package app.ito.poo;

import java.awt.HeadlessException;
import clases.ito.poo.cuentasbancarias;
import excepcion.ito.poo.ActCuenta;
import excepcion.ito.poo.DeleteCuenta;
import excepcion.ito.poo.DepositoCuenta;
import excepcion.ito.poo.NumberCuenta;
import excepcion.ito.poo.RetiroCuenta;
import excepcion.ito.poo.SaldoCuenta;

public class MyApp2 {
	
	static cuentasbancarias c;
	public static void main(String[] args) throws HeadlessException, NumberCuenta, SaldoCuenta, RetiroCuenta, DepositoCuenta, ActCuenta, DeleteCuenta {
		Aplicacion2.menu();
	}

}