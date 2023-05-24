package Ejemplo1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcesosArrayListIMC {

	String nombre = "";
	double imc, peso, talla;
	ArrayList<String> nombresList;
	ArrayList<String> resultadosList;
	ArrayList<Double> pesosList;
	ArrayList<Double> tallaList;

	public ProcesosArrayListIMC() {
		nombresList = new ArrayList<String>();
		pesosList = new ArrayList<Double>();
		tallaList = new ArrayList<Double>();
		resultadosList = new ArrayList<String>();
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

		for (int i = 0; i < nombresList.size(); i++) {

			if (nombresList.get(i).equalsIgnoreCase(persona)) {
				actualizar = JOptionPane.showInputDialog("Desea actualizar el nombre, el peso o la talla?");

				if (actualizar.equalsIgnoreCase("nombre")) {
					newNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
					nombresList.set(i, newNombre);
				} else if (actualizar.equalsIgnoreCase("peso")) {
					newPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso: "));
					pesosList.set(i, newPeso);
				} else if (actualizar.equalsIgnoreCase("talla")) {
					newTalla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva talla: "));
					tallaList.set(i, newTalla);
				} else {
					JOptionPane.showMessageDialog(null, "No existe esa información.");
				}

			}

		}

	}

	private boolean validarLlenado() {
		if (!nombresList.isEmpty()) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
		return false;
	}

	private void consultarPorNombre() {

		String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		if (nombresList.contains(nombreConsulta)) {
			for (int i = 0; i < nombresList.size(); i++) {
				if (nombresList.get(i).equalsIgnoreCase(nombreConsulta)) {
					JOptionPane.showMessageDialog(null, nombreConsulta + "," + " tiene" + resultadosList.get(i));
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "No existe esta persona en nuestra base de datos.");
		}
	}

	public void imprimirListas() {

		String lista = "";

		for (int i = 0; i < nombresList.size(); i++) {
			lista += nombresList.get(i) + ", resultado: " + resultadosList.get(i) + "\n";
		}

		JOptionPane.showMessageDialog(null, lista);
	}

	private void ingresarDatos() {

		String ingresarMas = "";

		do {

			nombre = JOptionPane.showInputDialog("Ingrese el nombre");
			nombresList.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
			pesosList.add(peso);
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
			tallaList.add(talla);
			ingresarMas = JOptionPane.showInputDialog("Quieres ingresar otra persona? si/no");

			calcularIMC();

		} while (ingresarMas.equalsIgnoreCase("si"));

	}

	private void calcularIMC() {

		String result = "";
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

		resultadosList.add(result);

	}

	private void consultarIMC() {

		String nombre = JOptionPane
				.showInputDialog("Ingrese el nombre de la persona a la cual desea calcularle el IMC");

		for (int i = 0; i < nombresList.size(); i++) {

			if (nombresList.get(i).contains(nombre)) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadosList.get(i));
			}
		}

	}

}
