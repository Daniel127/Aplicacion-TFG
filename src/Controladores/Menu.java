package Controladores;

import Vistas.VistaAplicacion;

public class Menu {
	
	private VistaAplicacion vista;
	private ControladorAplicacion controlador;
	
	public Menu(VistaAplicacion vista, ControladorAplicacion controlador){
		this.vista = vista;
		this.controlador = controlador;
	}
	
	public void ejecutar() {
		boolean salir = false;
		do {
			vista.imprimirMenu();
			int opcion = vista.leerInt("Elegir una opcion: ");
			switch (opcion) {
			case 1:
				controlador.consultarTrabajosLibres();
				break;
			case 2:
				controlador.asignarAlumno();
				break;
			case 3:
				controlador.anyadirTrabajo();
				break;
			case 4:
				controlador.modificarTrabajo();
				break;
			case 5:
				controlador.eliminarTrabajo();
				break;
			case 6:
				controlador.consultarDatosProfesor();
				break;
			case 7:
				controlador.cerrarAplicacion();
				salir = true;
				break;
			default:
				vista.imprimirMensaje("Opcion incorrecta");
				break;
			}
		} while (!salir);
	}
}
