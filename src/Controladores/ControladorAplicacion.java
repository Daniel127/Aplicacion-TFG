package Controladores;

import java.io.IOException;
import java.util.List;
import Modelo.ColeccionProfesores;
import Modelo.ColeccionTFG;
import Modelo.TFG;
import Utilidades.GestorFicheros;
import Vistas.VistaAplicacion;

public class ControladorAplicacion {

	private ColeccionTFG trabajos;
	private ColeccionProfesores profesores;
	private VistaAplicacion vista;
	private Menu menu;

	public ControladorAplicacion() {
		trabajos = new ColeccionTFG();
		profesores = new ColeccionProfesores();
		vista = new VistaAplicacion(trabajos, profesores);
		menu = new Menu(vista, this);
	}

	public void ejecutar() {
		try {
			trabajos.anyadirTrabajos(GestorFicheros.leerTrabajos());
		} catch (IOException e) {
			vista.error("NO FUE POSIBLE LEER LOS TRABAJOS DEL FICHERO");
		}
		menu.ejecutar();
	}
	
	public void cerrarAplicacion(){
		try {
			GestorFicheros.guardarTrabajos(trabajos.getTrabajos());
		} catch (IOException e) {
			vista.error("NO FUE POSIBLE GUARDAR LOS TRABAJOS EN EL FICHERO");
		}
	}

	public void consultarTrabajosLibres() {
		vista.imprimirTrabajosLibres();
		vista.leerString("Presiona una tecla para continuar....");
	}

	public void anyadirTrabajo() {
		vista.imprimirMensaje("Introduce los datos del TFG");
		String titulo = vista.leerString("Titulo: ");
		String descripcion = vista.leerString("Descripcion: ");
		String fecha = leerFecha("registro");
		// TODO Validar si el profesor existe en la lista de profesores
		// Opinion: Creo que se deberia mostrar una lista con los profesores existentes
		String apellidos = vista.leerString("Apellidos Profesor: ");
		TFG nuevo = new TFG(titulo, descripcion, fecha, apellidos);
		boolean asignarAlumno = vista.leerBoolean("¿El TFG tiene un alumno asignado? (true/false): ");
		if (asignarAlumno) {
			this.asignarAlumno(nuevo);
		}
		trabajos.anyadirTrabajo(nuevo);
		try {
			GestorFicheros.guardarTrabajo(nuevo);
		} catch (IOException e) {
			vista.error("NO FUE POSIBLE AÑADIR EL TRABAJO A EL FICHERO");
		}
		vista.leerString("Pulsa una tecla para continuar....");
	}

	public void consultarDatosProfesor(){
		//TODO
	}
	
	public void modificarTrabajo() {
		//TODO
	}

	public void eliminarTrabajo() {
		//TODO
	}

	public void asignarAlumno() {
		List<TFG> libres = trabajos.getTrabajosLibres();
		vista.imprimirTrabajosLibres();
		if (libres.size() > 0) {
			int indice;
			do{
				indice = vista.leerInt("Introduce el indice del trabajo que deseas modificar: ");
				if(indice < 1 || libres.size() < indice){
					vista.error("Introduce un indice en el rango [1," + libres.size() + "]");
				}
			}while( indice < 1 || libres.size() < indice);
			asignarAlumno(libres.get(indice - 1));
		}
		vista.leerString("Pulsa una tecla para continuar....");
	}

	private void asignarAlumno(TFG trabajo) {
		String alumno = vista.leerString("Nombre del alumno: ");
		String fechaInicio = leerFecha("inicio");
		trabajo.asignarAlumno(alumno, fechaInicio);
	}

	private String leerFecha(String tipo) {
		String fecha;
		do {
			fecha = vista.leerString("Fecha de " + tipo + " con formato dd/mm/aaa: ");
		} while (!esFechaValida(fecha));
		return fecha;
	}

	private boolean esFechaValida(String fecha) {
		String[] datos = fecha.split("/");
		int dia, mes, anyo;
		if (datos.length != 3) {
			vista.error("Introduza una fecha con formato dd/mm/aaaa");
			return false;
		}
		try {
			dia = Integer.parseInt(datos[0]);
			mes = Integer.parseInt(datos[1]);
			anyo = Integer.parseInt(datos[2]);
		} catch (NumberFormatException e) {
			vista.error("Introduzca una fecha con formato ENTERO/ENTERO/ENTERO");
			return false;
		}

		if (!(1 <= dia && dia <= 31)) {
			vista.error("Introduzca un dia en el rango [1,31]");
			return false;
		}
		if (!(1 <= mes && mes <= 12)) {
			vista.error("Introduzca un mes en el rango [1,12]");
			return false;
		}
		if (!(0 <= anyo && anyo <= 9999)) {
			vista.error("Introduzca un año en el rango [0,9999]");
			return false;
		}
		return true;
	}
}
