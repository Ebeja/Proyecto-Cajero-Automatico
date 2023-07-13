package cajeroAuto;

import javax.swing.JOptionPane;

public class CajeroAutomatico {
	public int saldo = 5000;
	public String clave = "12345";

	public void mostrarMenu() {
		int opcion = 0;
		do {
			String cadena = JOptionPane.showInputDialog(null, " " + "1 . Consultar saldo \n" + "2 . Depositar \n"
					+ "3 . Retirar Dinero \n" + "4 . Cambiar Clave \n" + "5 . Salir");

			if (cadena != null && ValidacionNumero.isNumero(cadena)) {
				opcion = Integer.parseInt(cadena);
				switch (opcion) {
				case 1:
					ConsultarSaldo();
					break;
				case 2:
					depositar();
					break;
				case 3:
					retirarDinero();
					break;
				case 4:
					cambiarClave();
					break;
				case 5:
					// salir
					JOptionPane.showMessageDialog(null, "Muchas Gracias Por Utlizar el Cajero Automatico");
					opcion = 5;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion Invalida");
					break;
				}
			}
		} while (opcion != 5);

	}

	public void depositar() {
		String cadena;
		int deposito = 0;

		cadena = JOptionPane.showInputDialog(null, "ingrese el monto que desea depositar");
		if (cadena != null && !cadena.equals("") && ValidacionNumero.isNumero(cadena))
			deposito = Integer.parseInt(cadena);

		if (deposito > 0) {
			saldo += deposito;
			JOptionPane.showMessageDialog(null, "El saldo actual es:" + saldo);
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0");
		}

	}

	// metodo para retirar efectivo
	public void retirarDinero() {
		String cadena;
		cadena = JOptionPane.showInputDialog(null, "Ingrese su clave");

		if (cadena == null) {
			// vuelve a inicio

		} else {
			if (!cadena.equals("")) {
				if (cadena.equals(clave)) {
					cadena = JOptionPane.showInputDialog(null, "" + "a) 5000 \n" + "b) 10 000 \n" + "c) 20 000 \n"
							+ "d) 50 000 \n" + "e) 100 000 \n" + "f) Otro monto \n");

					if (cadena != null) {
						if (!cadena.equals("")) {
							switch (cadena) {
							case "a":
								if ((saldo - 5000) >= 0)
									saldo -= 5000;
								JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);
								break;

							case "b":
								if ((saldo - 10000) >= 0) {
									saldo -= 10000;
									JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);
								}

								break;

							case "c":
								if ((saldo - 20000) >= 0) {
									saldo -= 20000;
									JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);
								}

								break;

							case "d":
								if ((saldo - 50000) >= 0) {
									saldo -= 50000;
									JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);
								}
								break;

							case "e":
								if ((saldo - 100000) >= 0) {
									saldo -= 100000;
									JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);
								}
								break;

							case "f":
								cadena = JOptionPane.showInputDialog(null, "ingrese la cantidad a retirar");
								if ((cadena != null && cadena.equals("") && ValidacionNumero.isNumero(cadena))
										&& (saldo - Integer.parseInt(cadena) >= 0) && (Integer.parseInt(cadena) >= 0)) {
									saldo -= Integer.parseInt(cadena);
									JOptionPane.showConfirmDialog(null, "su saldo actual es" + saldo);

								}
								break;

							default:
								JOptionPane.showConfirmDialog(null,
										"La opcion ingresada es incorrecta, intente nuevamente ");
								break;

							}

						}
					}
				} else {
					JOptionPane.showConfirmDialog(null, "La contraseña ingresada es incorrecta");
				}
			}
		}
	}

	// metodo cambiar clave

	public void cambiarClave() {
	    String auxiliar;
	    String claveNueva;
	    auxiliar = JOptionPane.showInputDialog(null, "Ingrese su clave actual:");

	    if (auxiliar != null && !auxiliar.equals("")) {
	        if (auxiliar.equals(clave)) {
	            claveNueva = JOptionPane.showInputDialog("Ingrese su nueva clave");
	            if (claveNueva != null && !claveNueva.equals("")) {
	                if (claveNueva.length() > 3) {
	                    clave = claveNueva;
	                    JOptionPane.showMessageDialog(null, "Su clave ha sido cambiada correctamente.");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Ingrese una clave válida (mayor a 3 caracteres).");
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "La clave ingresada no coincide.");
	        }
	    }
	}


	// metodo consultar saldo
	public void ConsultarSaldo() {
		JOptionPane.showConfirmDialog(null, "Su saldo actual es:" + saldo);
	}

}
