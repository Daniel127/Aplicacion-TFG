import java.io.*;
import java.util.ArrayList;

public class GestorFicheros {

    BufferedReader fRProfesores;
    BufferedReader fRTrabajos;
    BufferedWriter fWProfesores;
    BufferedWriter fWTrabajos;
    

	public GestorFicheros(){
		
	
	try {
		fWProfesores= new BufferedWriter( new FileWriter("Profesores.txt")) ;
	    fWTrabajos= new BufferedWriter(new FileWriter("TrabajosFinGrado.txt",true));
	    fRProfesores= new BufferedReader(new FileReader("Profesores.txt"));
	    fRTrabajos=  new BufferedReader(new FileReader("TrabajosFinGrado.txt"));

	} catch (IOException e) {

		e.printStackTrace();
	}
	
	}
	public ArrayList<Tfg> leerTFGs(){
		String linea;
		ArrayList<Tfg> listaTFGs= new ArrayList<Tfg>();
		Tfg nuevoTFG= new Tfg();
		String[] datos;
		int nota;
		try {
			linea=fRTrabajos.readLine();
			while(linea!=null){
				
				datos= linea.split(":");
				nota= Integer.parseInt(datos[8]);
				nuevoTFG.setAll(datos[0], datos[1], datos[2], datos[3], datos[4],datos[5], datos[6],datos[7],nota);
				listaTFGs.add(nuevoTFG);
				linea=fRTrabajos.readLine();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return listaTFGs;
		
	}
	public void actualizarFicheroTFGs(ArrayList<Tfg> listaTFGs, int modificados){

		int tamañoL=listaTFGs.size();
		try {
		for(int i=tamañoL-1; i>=tamañoL-modificados;i--){
			
				fWTrabajos.write(listaTFGs.get(i).toFileTypeString());
				fWTrabajos.newLine();
			}
		}catch (IOException e) {

				e.printStackTrace();
		}
		
		try {
			fWTrabajos.flush();
			System.out.println("Datos añadidos correctamente");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Datos no añadidos");
		}

	}
	public void close(){
		try {
			fWProfesores.close();
			fWTrabajos.close();
			fRProfesores.close();
			fRTrabajos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
