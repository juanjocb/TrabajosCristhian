
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Mascota {

	ArrayList<String> listaMascotas;
	HashMap<String, ArrayList<String>> mapMascotas = new HashMap<>();
	String codigo;
	String nombre;
	String especie;
	int edad;

	public Mascota(ArrayList<String> listaMascotas, String codigo, String nombre, String especie, int edad) {
		this.listaMascotas = listaMascotas;
		this.codigo = codigo;
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
	}

	public void mostrarInformacion() {
		JOptionPane.showMessageDialog(null, nombre);
		JOptionPane.showMessageDialog(null, especie);
		JOptionPane.showMessageDialog(null, codigo);
	}

	public void hacerSonido() {
		if (especie.equalsIgnoreCase("perro")) {
			JOptionPane.showMessageDialog(null, "¡Guau guau!");
		} else if (especie.equalsIgnoreCase("gato")) {
			JOptionPane.showMessageDialog(null, "¡Miau miau!");
		} else {
			JOptionPane.showMessageDialog(null, "No reconozco la mascota");
		}
	}

	public void atacar() {
		if (especie.equals("perro")) {
			JOptionPane.showMessageDialog(null, "Muerdes y arranca el pedazo");
		} else if (especie.equals("gato")) {
			JOptionPane.showMessageDialog(null, "Aruña!!");
		} else if (especie.equals("cabra")) {
			JOptionPane.showMessageDialog(null, "Cabezea");
		} else {
			JOptionPane.showMessageDialog(null, "No reconozco la mascota");
		}
	}

	public void comer() {
		if (especie.equals("perro")) {
			JOptionPane.showMessageDialog(null, "Come cuido");
		} else if (especie.equals("gato")) {
			JOptionPane.showMessageDialog(null, "Come atun");
		} else if (especie.equals("cabra")) {
			JOptionPane.showMessageDialog(null, "come pasto");
		} else {
			JOptionPane.showMessageDialog(null, "No reconozco la mascota");
		}
	}

	public void registrarMascotas() {
		String codigoMascota;
		String nomMascota;
		String especieMascota;
		String edadMascota;
		String otraMascota = "";
		do {
			listaMascotas = new ArrayList<String>();
			codigoMascota = JOptionPane.showInputDialog("Ingrese el codigo de la mascota");
			nomMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
			especieMascota = JOptionPane.showInputDialog("Ingrese la especie de la mascota");
			edadMascota = JOptionPane.showInputDialog("Ingrese la edad de la mascota");
			listaMascotas.add(codigoMascota);
			listaMascotas.add(nomMascota);
			listaMascotas.add(especieMascota);
			listaMascotas.add(edadMascota);
			mapMascotas.put(listaMascotas.get(0), listaMascotas);

			otraMascota = JOptionPane.showInputDialog("¿Desea ingresar otra mascota? si/no");

		} while (otraMascota.equalsIgnoreCase("si"));
	}

	public void buscarMascota() {
		String buscar = JOptionPane.showInputDialog("ingrese el codigo de la mascota que desea encontrar");
		if (mapMascotas.containsKey(buscar)) {
			JOptionPane.showMessageDialog(null, mapMascotas.get(buscar));
		}

	}

	public void mostrarTodo() {
		for (String identificacion : mapMascotas.keySet()) {
			JOptionPane.showMessageDialog(null, mapMascotas.get(codigo));
		}
	}

	public void actualizar() {
		String mascotaActualizar = JOptionPane.showInputDialog("ingrese el codigo de la mascota que desea actualizar");
		String actualizarDato;
		String nuevoDato;
		for (String codigo : mapMascotas.keySet()) {
			if (mapMascotas.get(codigo).equals(mascotaActualizar)) {

				actualizarDato = JOptionPane.showInputDialog("Desea actualizar nombre, especie o edad?");
				if (actualizarDato.equals("nombre")) {
					nuevoDato = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
					listaMascotas.set(1, nuevoDato);
				} else if (actualizarDato.equals("especie")) {
					nuevoDato = JOptionPane.showInputDialog("Ingrese la nueva especie");
					listaMascotas.set(2, nuevoDato);
				} else if (actualizarDato.equals("edad")) {
					nuevoDato = JOptionPane.showInputDialog("Ingrese la nueva edad");
					listaMascotas.set(3, nuevoDato);
				} else {
					System.out.println("no existe esa opcion");
				}

			}
		}

	}
}
