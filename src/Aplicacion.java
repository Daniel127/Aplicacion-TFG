import java.util.ArrayList;
import java.io.BufferedReader
import java.util.Iterator;
import java.util.Scanner;


public class Aplicacion {
    public static void main(String args[]){
        ArrayList<Tfg> listaTfg;
	GestorFicheros gestorF = new GestorFicheros();
        int a�adidos;
    	listaTfg= gestorF.leerTFGs();

        Profesor p = new Profesor();
        p.leerProfesor();
        Tfg tfg= new Tfg();
        tfg.leerTfg();
        BufferedReader r = new BufferedReader("System.in");
        int opc = -1;

//gestorF.actualizarFicheroTFGs(listaTfg, a�adidos);
    }

    //Abrir, cerrar, leer de fichero.
    //MAIN.
    
    private void inicio(){
    	while(opc!=6){
    		System.out.println("== Menu Principal ==");
    		System.out.println("1. ");
    		System.out.println("2. ");
    		System.out.println("3.Mostrar Tfg libres ");
    		System.out.println("4. ");
    		System.out.println("5. ");
    		System.out.println("6. Salir");
    		
    		System.out.println("Elegir una opcion: ");
    		opc = r.nextInt();
    		
    		if(opc<1 || opc>6){
    			switch(opc){
    				case 1: opcion1(); break;
    				case 2: opcion2(); break;
    				case 3: mostrarTFG(); break;
    				case 4: opcion4(); break;
    				case 5: opcion5(); break;
    				case 6: break;
    			}
    		} else {
    			System.out.println("Opcion no valida");
    		}
    	}
    }
    
    private void opcion1(){
        
    }
    private void opcion2(){
    	
    }
   
    private void mostrarTFG(){
    	int i=-1;
    	Iterator<Tfg> it=listaTfg.iterator();
    	while(it.hasNext()){
    		Tfg aux=it.next();
    		i++;
    		if(aux.getNombAlumno()== " "){
    			System.out.println(" Posición en el registro " + i + "Nombre del TFG"+aux. getTitulo());
    			System.out.println("Descripcion del tfg"+aux.getDescripcion());
    			System.out.println("Fecha registro del tfg" + aux.getfRegistro());
    			System.out.println("Apellidos del profesor"+aux.getApProfesor());
    		}
    	}
    	
    }
    
    private void asignarAlumno(){
    	String nm,fc;
    	int pos;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Nombre del Alumno");
    	nm=sc.nextLine();
    	System.out.println("Fecha comienzo TFG (dd/mm/aaaa)");
    	fc=sc.nextLine();
    	System.out.println("Posición del TFG deseado en el registro");
    	pos=sc.nextInt();
    	Tfg aux=listaTfg.get(pos);
    	aux.setNombAlumno(nm);
    	aux.setfComienzo(fc);
    	listaTfg.set(pos, aux);
    	System.out.println("Asignación de un alumno a un TFG completada");	
    	
    }
    private void opcion5(){
    	
    }

    //Constructor, metodos de las historias de usuario.

}
