package Modelo;

public class TFG {
	private String titulo;
	private String descripcion;
	private String fechaRegistro;
	private String alumno;
	private String fechaInicio;
	private String convocatoria;
	private String fechaDefensa;
	private float nota;
	private String apellidosProfesor;

	public TFG(String titulo, String descripcion, String fechaRegistro, String profesor) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
		this.apellidosProfesor = profesor;
		this.alumno = "";
		this.fechaInicio = "";
		this.convocatoria = "";
		this.fechaDefensa = "";
		this.nota = 0f;
	}

	public TFG(String[] datos) {
		this.titulo = datos[0];
		this.descripcion = datos[1];
		this.fechaRegistro = datos[2];
		this.alumno = datos[3];
		this.fechaInicio = datos[4];
		this.convocatoria = datos[5];
		this.fechaDefensa = datos[6];
		this.nota = Float.parseFloat(datos[7]);
		this.apellidosProfesor = datos[8];
	}

	public void asignarAlumno(String alumno, String fechaInicio) {
		this.alumno = alumno;
		this.fechaInicio = fechaInicio;
	}

	public void finalizar(String fechaDefensa, String convocatoria, float nota) {
		//TODO
	}
	
	public void liberar(){
		//TODO
	}
	
	public boolean estaDisponible() {
		return alumno == null || alumno.equals("");
	}

	public String formatoFichero() {
		return titulo + ":" + descripcion + ":" + fechaRegistro + ":" + alumno + ":" + fechaInicio + ":" + convocatoria
				+ ":" + fechaDefensa + ":" + nota + ":" + apellidosProfesor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public String getAlumno() {
		return alumno;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public String getFechaDefensa() {
		return fechaDefensa;
	}

	public float getNota() {
		return nota;
	}

	public String getProfesor() {
		return apellidosProfesor;
	}
}
