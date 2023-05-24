import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Procesos {

	String nombre = "";
	double imc, peso, talla;
	String[] nombres;
	String[] resultadosList;
	double[] pesoArray;
	double[] tallaArray;

	public Procesos() {
		iniciar();
	}

	public void iniciar() {

		String menu = "MENU\n";
		menu = "1.Ingresar Datos.\n";
		menu += "2.Consultar IMC\n";
		menu += "3.Mostrar lista\n";
		menu += "4.Buscar por nombre\n";
		menu += "5.Actualice la persona\n";
		menu += "6.Salir";

		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			crearMenu(opc);
		} while (opc != 6);
	}

	private void crearMenu(int opc) {

		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2:
			if (validarLlenado()) {
				consultarIMC();
			}
			break;
		case 3:
			if (validarLlenado()) {
				imprimirListas();
			}
			break;
		case 4:
			if (validarLlenado()) {
				consultarPorNombre();
			}
			break;
		case 5:
			if (validarLlenado()) {
				actualizarPersona();
			}
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Finalizado con exito!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "No existe el codigo");
			break;
		}

	}

	private void actualizarPersona() {

		String persona = JOptionPane.showInputDialog("Ingrese el nombre de la persona que quiere actualizar");
		String actualizar = "";
		String newNombre = "";
		double newPeso = 0;
		double newTalla = 0;

		for (int i = 0; i < nombres.length; i++) {

			if (nombres[i].equalsIgnoreCase(persona)) {
				actualizar = JOptionPane.showInputDialog("Desea actualizar el nombre, el peso o la talla?");

				if (actualizar.equalsIgnoreCase("nombre")) {
					newNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
					nombres[i] = newNombre;
				} else if (actualizar.equalsIgnoreCase("peso")) {
					newPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso: "));
					pesoArray[i] = newPeso;
				} else if (actualizar.equalsIgnoreCase("talla")) {
					newTalla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva talla: "));
					tallaArray[i] = newTalla;
				} else {
					JOptionPane.showMessageDialog(null, "No existe esa información.");
				}

			}

		}
		JOptionPane.showMessageDialog(null, "Actualizado con exito");

	}

	private boolean validarLlenado() {
		if (nombres != null) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
		return false;
	}

	private void consultarPorNombre() {

		String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		for (int i = 0; i < nombres.length; i++) {

			if (nombres[i].equalsIgnoreCase(nombreConsulta)) {
				JOptionPane.showMessageDialog(null, nombreConsulta + "," + " tiene" + resultadosList[i]);
			} else {
				JOptionPane.showMessageDialog(null, "No existe esta persona en nuestra base de datos.");
			}
		}
	}

	public void imprimirListas() {

		String lista = "";

		for (int i = 0; i < nombres.length; i++) {
			lista += nombres[i] + ", resultado: " + resultadosList[i] + "\n";
		}

		JOptionPane.showMessageDialog(null, lista);
	}

	private void ingresarDatos() {

		int personas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa cuantas personas vas a registrar"));
		nombres = new String[personas];
		pesoArray = new double[personas];
		tallaArray = new double[personas];

		for (int i = 0; i < nombres.length; i++) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona: " + (i + 1));
			nombres[i] = nombre;
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la persona : " + (i + 1)));
			pesoArray[i] = peso;
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla de la persona : " + (i + 1)));
			tallaArray[i] = talla;

			calcularIMC(personas);

		}

	}

	private void calcularIMC(int cant) {

		String result = "";
		resultadosList = new String[cant];
		imc = peso / (talla * talla);

		if (imc < 18) {
			result = ("Anorexia");
		} else if (imc >= 18 && imc < 20) {
			result = ("Delgadez");
		} else if (imc >= 20 && imc < 27) {
			result = ("Normalidad");
		} else if (imc >= 27 && imc < 30) {
			result = ("Obesidad 1");
		} else if (imc >= 30 && imc < 35) {
			result = ("Obesidad 2");
		} else if (imc >= 35 && imc < 40) {
			result = ("Obesidad 3");
		} else if (imc >= 40) {
			result = ("Obesidad Morbida");
		}

		for (int i = 0; i < resultadosList.length; i++) {
			resultadosList[i] = result;
		}

	}

	private void consultarIMC() {

		String nombre = JOptionPane
				.showInputDialog("Ingrese el nombre de la persona a la cual desea calcularle el IMC");

		for (int i = 0; i < nombres.length; i++) {

			if (nombres[i].equals(nombre)) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadosList[i]);
			}
		}

	}

}
