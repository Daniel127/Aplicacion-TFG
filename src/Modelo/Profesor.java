package Modelo;

public class Profesor {
	private String nombre;
	private String apellidos;
	private String despacho;
	private String correo;
	
	public Profesor(String nombre, String apellidos, String despacho, String correo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDespacho() {
		return despacho;
	}
	public String getCorreo() {
		return correo;
	}
}
