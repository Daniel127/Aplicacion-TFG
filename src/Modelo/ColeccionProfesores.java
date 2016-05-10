package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ColeccionProfesores {
	private List<Profesor> profesores;

	public ColeccionProfesores() {
        profesores = new ArrayList<Profesor>();

	}

	public void anyadirProfesores(List<Profesor> profesores) {
		this.profesores.addAll(profesores);
	}

	public Profesor obtenerProfesor(String apellidos) {
		Profesor p = null;
		boolean encontrado = false;
		Iterator<Profesor> it = profesores.iterator();
		while (it.hasNext() && !encontrado) {
			p = it.next();
			if (apellidos.equals(p.getApellidos()))
				encontrado = true;
		}
		if (encontrado) {
			return p;
		} else {
			return null;
		}

	}
	
	public List<Profesor> getProfesores(){
		return profesores;
	}
	
	public boolean profesorexiste(String apellidos){
		Profesor aux;
		boolean encontrado = false;
		Iterator<Profesor> it = profesores.iterator();
		while (it.hasNext() && !encontrado) {
			aux= it.next();
			if (apellidos.equals(aux.getApellidos()))
				encontrado = true;
		}
		
		return encontrado;
		
		
	}
}
