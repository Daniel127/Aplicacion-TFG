package Modelo;
import java.util.ArrayList;
import java.util.List;

public class ColeccionProfesores {
	private List<Profesor> profesores;

	public ColeccionProfesores() {
		profesores = new ArrayList<>();
	}

	public void anyadirProfesores(List<Profesor> profesores) {
		this.profesores.addAll(profesores);
	}

	public Profesor obtenerProfesor(String apellidos) {
		// TODO
		return null;
	}
	
	public List<Profesor> getProfesores(){
		return profesores;
	}
}
