package Vistas;

import java.util.List;

import Modelo.ColeccionProfesores;
import Modelo.ColeccionTFG;
import Modelo.TFG;
import Utilidades.GestorIO;

public class VistaAplicacion {
	private ColeccionTFG trabajos;
	@SuppressWarnings("unused")
	private ColeccionProfesores profesores;
	private GestorIO gestorIO;

	public VistaAplicacion(ColeccionTFG trabajos, ColeccionProfesores profesores) {
		this.trabajos = trabajos;
		this.profesores = profesores;
		this.gestorIO = GestorIO.getGestorIO();
	}
	
	public void imprimirMenu() {
		gestorIO.escribirLinea("== Menu Principal ==");
		gestorIO.escribirLinea("1). Mostrar TFG libres");
		gestorIO.escribirLinea("2). Asignar un alumno a un TFG");
		gestorIO.escribirLinea("3). Añadir TFG");
		gestorIO.escribirLinea("4). Modificar TFG");
		gestorIO.escribirLinea("5). Eliminar TFG");
		gestorIO.escribirLinea("6). Consultar datos de profesor");
		gestorIO.escribirLinea("7). Salir\n");
	}

	public void imprimirTrabajosLibres() {
		List<TFG> trabajosLibres = trabajos.getTrabajosLibres();
		int i = 1;
		gestorIO.escribirLinea();
		if(trabajosLibres.size() > 0){
			for (TFG trabajo : trabajosLibres) {
				gestorIO.escribirLinea("Trabajo " + i++);
				gestorIO.escribirLinea("Titulo: " + trabajo.getTitulo());
				gestorIO.escribirLinea("Descripcion: " + trabajo.getDescripcion());
				gestorIO.escribirLinea("Fecha de registro: " + trabajo.getFechaRegistro());
				gestorIO.escribirLinea("Profesor a cargo: " + trabajo.getProfesor());
				gestorIO.escribirLinea();
			}
		}else{
			gestorIO.escribirLinea("No hay trabajos libres");
		}
	}

	public void imprimirMensaje(String mensaje) {
		gestorIO.escribirLinea(mensaje);
	}

	public void error(String descripcion) {
		gestorIO.escribirLinea("ERROR! " + descripcion + ".");
	}

	public int leerInt(String mensaje) {
		return gestorIO.leerInt(mensaje);
	}

	public String leerString(String mensaje) {
		return gestorIO.leerString(mensaje);
	}

	public boolean leerBoolean(String mensaje) {
		return gestorIO.leerBoolean(mensaje);
	}
	
	public float leerFloat(String mensaje){
		return gestorIO.leerFloat(mensaje);
	}
}
