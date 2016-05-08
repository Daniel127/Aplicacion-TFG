package Utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Profesor;
import Modelo.TFG;

public class GestorFicheros {

	private GestorFicheros(){}
	
	public static List<TFG> leerTrabajos() throws IOException {
		BufferedReader fTrabajos = new BufferedReader(new FileReader("TrabajosFinGrado.txt"));
		List<TFG> listaTFGs = new ArrayList<TFG>();
		String linea;
		String[] datos;
		linea = fTrabajos.readLine();
		while (linea != null) {
			datos = linea.split(":");
			if(datos.length == 9){
				TFG nuevoTFG = new TFG(datos);
				listaTFGs.add(nuevoTFG);
			}
			linea = fTrabajos.readLine();
		}
		fTrabajos.close();
		return listaTFGs;
	}

	public static List<Profesor> leerProfesores() throws IOException {
		//Leer profesores de fichero (el fichero se proporciona, no hay que crearlo)
        BufferedReader fProfesores = new BufferedReader(new FileReader("Profesores.txt"));

        List<Profesor> listaProfesores = new ArrayList<Profesor>();
        String linea;
        String[] datos;
        linea = fProfesores.readLine();

        while (linea != null) {
            datos = linea.split(":");
            Profesor nuevoProfesor = new Profesor(datos[0], datos[1], datos[2], datos[3]);
            listaProfesores.add(nuevoProfesor);
            linea = fProfesores.readLine();
        }

		return listaProfesores;
	}

	public static void guardarTrabajo(TFG trabajo) throws IOException{
		BufferedWriter fTrabajos = new BufferedWriter(new FileWriter("TrabajosFinGrado.txt",true));
		fTrabajos.write(trabajo.formatoFichero());
		fTrabajos.newLine();
		fTrabajos.flush();
		fTrabajos.close();
	}
	
	public static void guardarTrabajos(List<TFG> trabajos) throws IOException {
		BufferedWriter fTrabajos = new BufferedWriter(new FileWriter("TrabajosFinGrado.txt"));
		for(TFG trabajo : trabajos){
			fTrabajos.write(trabajo.formatoFichero());
			fTrabajos.newLine();
		}
		fTrabajos.close();
	}
}
