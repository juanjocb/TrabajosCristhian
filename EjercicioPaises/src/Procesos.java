
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Procesos {

	HashMap<String, ArrayList<String>> mapPaises;
	ArrayList<String> listCiudades;

	public Procesos() {
		mapPaises = new HashMap<String, ArrayList<String>>();
		iniciar();

	}

	private void iniciar() {

		String str = "1. Registrar Paises\n";
		str += "2. Registrar ciudades\n";
		str += "3. Consultar Ciudades por Pais\n";
		str += "4. Consultar Ciudad\n";
		str += "5. Salir\n";

		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(str));
			crearMenu(opc);
		} while (opc != 5);

	}

	private void crearMenu(int opc) {

		switch (opc) {
		case 1:
			ingresarPaises();
			break;
		case 2:
			ingresarCiudades();
			break;
		case 3:
			consultarPorPaisCiudades();
			break;
		case 4:
			consultarCiudad();
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Has salido exitosamente");
			break;
		default:
			break;
		}

	}

	private void consultarPorPaisCiudades() {

		String pais = JOptionPane.showInputDialog("Ingrese el pais para consultar sus ciudades");

		if (mapPaises.containsKey(pais)) {
			JOptionPane.showMessageDialog(null, mapPaises.get(pais));
		}

	}

	private void ingresarPaises() {

		String nuevoPais;
		String ingresar = "";

		do {

			nuevoPais = JOptionPane.showInputDialog("Ingrese un pais");
			// listCiudades = new ArrayList<>();
			ingresar = JOptionPane.showInputDialog("Quiere ingresar otro pais? si/no");
			mapPaises.put(nuevoPais, null);

		} while (ingresar.equalsIgnoreCase("si"));

	}

	private void ingresarCiudades() {

		String pais = JOptionPane.showInputDialog("Ingrese el pais al que le desea ingresar ciudades");
		String ciudad;
		String seguir = "";

		if (mapPaises.containsKey(pais)) {

			listCiudades = new ArrayList<String>();
			do {
				ciudad = JOptionPane.showInputDialog("Ingrese la ciudad");
				listCiudades.add(ciudad);

				seguir = JOptionPane.showInputDialog("Quiere ingresar otra ciudad? si/no");

			} while (seguir.equalsIgnoreCase("si"));

			mapPaises.put(pais, listCiudades);

		} else {
			JOptionPane.showMessageDialog(null, "No existe ese pais");
		}

	}

	private void consultarCiudad() {

		String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad que desea consultar");

		for (String clave : mapPaises.keySet()) {
			for (int i = 0; i < mapPaises.get(clave).size(); i++) {
				if(mapPaises.get(clave).get(i).equals(ciudad)) {
					JOptionPane.showMessageDialog(null, "El pais de la ciudad " + ciudad + "es " + clave);
				}
			}
		}

	}

}
