package Controladores;

import java.io.IOException;
import java.util.List;

import Modelo.ColeccionProfesores;
import Modelo.ColeccionTFG;
import Modelo.Profesor;
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
        try{
        	profesores.anyadirProfesores(GestorFicheros.leerProfesores());
        }catch(IOException i){
            vista.error("NO EXISTE UN FICHERO DE PROFESORES. NO SE PODRÁ NI AÑADIR TFGs NI OBTENER INFORMACION DE PROFESOR");

        }
        menu.ejecutar();
 
    }

    public void cerrarAplicacion() {
        try {
            GestorFicheros.guardarTrabajos(trabajos.getTrabajos());
        } catch (IOException e) {
            vista.error("NO FUE POSIBLE GUARDAR LOS TRABAJOS EN EL FICHERO");
        }
    }

    public void consultarTrabajosLibres() {
        vista.imprimirTrabajos(trabajos.getTrabajosLibres());
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
        while (!profesores.profesorexiste(apellidos)) {
            vista.imprimirMensaje("El profesor especificado no esta en la lista.");
            vista.imprimirMensaje("Profesores registrados:");
            vista.imprimirProfesores();
            apellidos = vista.leerString("Apellidos Profesor: ");
        }
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

    public void consultarDatosProfesor() {
        String ap = vista.leerString("Dame los apellidos del profesor: ");
        Profesor aux = profesores.obtenerProfesor(ap);
        if (aux == null) {
            vista.error("El profesor especificado no esta en la lista");
        } else {
            vista.imprimirMensaje("Apellidos del profesor : " + aux.getApellidos());
            vista.imprimirMensaje("Nombre del profesor : " + aux.getNombre());
            vista.imprimirMensaje("Despacho del profesor : " + aux.getDespacho());
            vista.imprimirMensaje("Correo del profesor : " + aux.getCorreo());

        }
        vista.leerString("Pulsa una tecla para continuar....");

    }

    public void modificarTrabajo() {

        int peticion;
        int i;
        int total = trabajos.getTrabajosAsignados().size();
        if (total != 0) {
            vista.imprimirOpcionesModificado();
            do {
                peticion = vista.leerInt("Elija una opcion: ");
            } while (peticion != 1 && peticion != 2);
            if (peticion == 1) {
                vista.imprimirTrabajos(trabajos.getTrabajosAsignados());
                do {
                    i = vista.leerInt("Que trabajo desea liberar? ");
                } while (i > total || 0 >= i);
                trabajos.getTrabajo(i - 1).liberar();
                vista.imprimirMensaje("Trabajo liberado ");
                vista.leerString("Pulsa una tecla para continuar....");
            } else if (peticion == 2) {
                vista.imprimirTrabajos(trabajos.getTrabajosAsignados());
                do {
                    i = vista.leerInt("Que trabajo desea finalizar? ");
                } while (i > total || 0 > i);
                String fechaD = leerFecha("Fecha de defensa: ");
                String convocatoria = vista.leerString("Convocatoria: ");
                Float nota = vista.leerFloat("Nota: ");
                trabajos.getTrabajo(i - 1).finalizar(fechaD, convocatoria, nota);
                vista.leerString("Pulsa una tecla para continuar....");
            }
        }
    }

    public void eliminarTrabajo() {

    	vista.imprimirTrabajos(trabajos.getTrabajos());
        if (trabajos.size() > 0) {
            int indice;
            do {
                indice = vista.leerInt("Introduce el indice del trabajo que deseas borrar: ");
                if (indice < 1 || trabajos.size() < indice) {
                    vista.error("Introduce un indice en el rango [1," + trabajos.size() + "]");
                }
            } while (indice < 1 || trabajos.size() < indice);

            trabajos.eliminarTrabajo(indice - 1);

            vista.imprimirMensaje("El TFG ha sido eliminado correctamente ");
            vista.leerString("Pulsa una tecla para continuar....");
        } else {
            vista.imprimirMensaje("La lista de TFGs esta vacia.AÃ±ade antes de borrar");
        }

    }


    public void asignarAlumno() {
        List<TFG> libres = trabajos.getTrabajosLibres();
        vista.imprimirTrabajos(libres);
        if (libres.size() > 0) {
            int indice;
            do {
                indice = vista.leerInt("Introduce el indice del trabajo que deseas modificar: ");
                if (indice < 1 || libres.size() < indice) {
                    vista.error("Introduce un indice en el rango [1," + libres.size() + "]");
                }
            } while (indice < 1 || libres.size() < indice);
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
            vista.error("Introduzca un aÃ±o en el rango [0,9999]");
            return false;
        }
        return true;
    }
}
