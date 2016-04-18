package Utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	public static List<Profesor> leerProfesores() {
		//TODO
		return null;
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
