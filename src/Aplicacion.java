import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacion {

	private static ArrayList<Tfg> listaTfg;
	private static GestorFicheros gestorF;

	public static void main(String args[]) {
		gestorF = new GestorFicheros();
		listaTfg = gestorF.leerTFGs();
//
//		Profesor p = new Profesor();
//		p.leerProfesor();
//		Tfg tfg = new Tfg();
//		tfg.leerTfg();
//		InputStreamReader input = new InputStreamReader(System.in);
//		BufferedReader r = new BufferedReader(input);
		inicio();
	}

	// Abrir, cerrar, leer de fichero.
	// MAIN.

	private static void inicio() {
		Scanner r = new Scanner(System.in);
		int opc = -1, indice;
		boolean continuar= false;
		while (opc != 6) {
			System.out.println("== Menu Principal ==");
			System.out.println("1. A�adir TFG");
			System.out.println("2. ");
			System.out.println("3. Mostrar TFG libres");
			System.out.println("4. Asignar a un alumno un TFG");
			System.out.println("5. ");
			System.out.println("6. Salir");

			System.out.println("Elegir una opcion: ");
			opc = r.nextInt();

			if (opc > 1 || opc < 6) {
				switch (opc) {
					case 1:
						anyadirTFG();
						break;
					case 2:
						opcion2();
						break;
					case 3:
						mostrarTFG();
						break;
					case 4:
						mostrarTFG();
						while(!continuar){

							indice = inicioAsignarAlumno();
							if(listaTfg.get(indice).getNombAlumno() == null) {
								listaTfg.get(indice).actualizarTfgMeterAlumno();
								continuar=true;
							} else {
								System.out.println("No has introducido el indice de un TFG disponible. " +
										"\nPor favor introduzca el indice de un TFG que aun no tenga un alumno asignado;");
								System.out.println("");
							}
						}
						continuar= false;
						break;
					case 5:
						opcion5();
						break;
					case 6:
						gestorF.close();
						break;
				}
			} else {
				System.out.println("Opcion no valida");
			}
		}
	}

	private static void opcion4() {

	}

	private static void anyadirTFG() {
		Tfg tfg = new Tfg();
		tfg.leerTfg();
		listaTfg.add(tfg);
		gestorF.actualizarFicheroTFGs(listaTfg);
	}

	private static void opcion2() {

	}

	private static void mostrarTFG() {
		int i = -1;
		Iterator<Tfg> it = listaTfg.iterator();
		while (it.hasNext()) {
			Tfg aux = it.next();
			i++;
			if (aux.getNombAlumno() == null) {
				System.out.println("Posicion en el registro " + (i + 1) + " Nombre del TFG: " + aux.getTitulo());
				System.out.println("Descripcion del TFG: " + aux.getDescripcion());
				System.out.println("Fecha registro del TFG: " + aux.getfRegistro());
				System.out.println("Apellidos del profesor: " + aux.getApProfesor());
				System.out.println("");

			}
		}

	}

	private static int inicioAsignarAlumno() {
		String nm, fc;
		Scanner sc= new Scanner(System.in);
		int pos;
		System.out.println("Posición del TFG deseado en el registro");
		pos = sc.nextInt() - 1;
		return pos;
	}

	private static void opcion5() {

	}

}
