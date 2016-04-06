import java.util.Scanner;

public class Tfg {
    private String titulo;
    private String descripcion;
    private String fRegistro;
    private String fComienzo;
    private String fConvocatoria;
    private String fFinal;
    private String nombAlumno;
    private String apProfesor;
    private int nota;

    public Tfg() {
        this.titulo = null;
        this.descripcion = null;
        this.fRegistro = null;
        this.fComienzo = null;
        this.fConvocatoria = null;
        this.fFinal = null;
        this.nombAlumno = null;
        this.apProfesor = null;
        this.nota = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getfRegistro() {
        return fRegistro;
    }

    public void setfRegistro(String fRegistro) {
        this.fRegistro = fRegistro;
    }

    public String getfComienzo() {
        return fComienzo;
    }

    public void setfComienzo(String fComienzo) {
        this.fComienzo = fComienzo;
    }

    public String getfConvocatoria() {
        return fConvocatoria;
    }

    public void setfConvocatoria(String fConvocatoria) {
        this.fConvocatoria = fConvocatoria;
    }

    public String getNombAlumno() {
        return nombAlumno;
    }

    public void setNombAlumno(String nombAlumno) {
        this.nombAlumno = nombAlumno;
    }

    public String getfFinal() {
        return fFinal;
    }

    public void setfFinal(String fFinal) {
        this.fFinal = fFinal;
    }

    public String getApProfesor() {
        return apProfesor;
    }

    public void setApProfesor(String apProfesor) {
        this.apProfesor = apProfesor;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    protected void leerTfg(){
        Scanner sc= new Scanner(System.in);
        String s;
        int n;

        System.out.println("Procediendo a leer TFG: ");
        System.out.print("Introduzca titulo del TFG: ");
        s= sc.nextLine();
        this.setTitulo(s);
        System.out.println("");
        System.out.print("Introduzca descripcion del TFG: ");
        s= sc.nextLine();
        this.setDescripcion(s);
        System.out.println("");
        System.out.print("Introduzca la fecha del registro del TFG en formato dd/mm/aaaa");
        s= sc.nextLine();
        this.setfRegistro(s);
        System.out.println("");
        System.out.print("Introduzca el apellido del profesor que propuso este TFG: ");
        s= sc.nextLine();
        this.setApProfesor(s);

        System.out.println("");
        System.out.println("¿Este TFG tiene ya un alumno asignado? Si lo tiene, introduzca un 1 ");
        n= sc.nextInt();
        if(n== 1){
            System.out.println("");
            System.out.print("Introduzca el nombre del alumno: ");
            s= sc.nextLine();
            this.setNombAlumno(s);
            System.out.println("");
            System.out.print("Introduzca la fecha del inicio del TFG en formato dd/mm/aaaa: ");
            s= sc.nextLine();
            this.setfComienzo(s);
        }

        System.out.println("");
        System.out.println("Se ha terminado de leer los datos de este TFG");
    }

    protected void actualizarTfgMeterAlumno(){
        Scanner sc= new Scanner(System.in);
        String s;

        System.out.println("");
        System.out.print("Introduzca el nombre del alumno: ");
        s= sc.nextLine();
        this.setNombAlumno(s);
        System.out.println("");
        System.out.print("Introduzca la fecha del inicio del TFG en formato dd/mm/aaaa: ");
        s= sc.nextLine();
        this.setfComienzo(s);
    }
public void setAll(String titulo, String descripcion, String fRegistro, String fComienzo, String fConvocatoria, String fFinal, String nombAlumno, String apProfesor, int nota){
		this.titulo=titulo;
	   this.descripcion= descripcion;
	    this.fRegistro= fRegistro;
	    this.fComienzo=fComienzo;
		this.fConvocatoria=fConvocatoria;
	    this.fFinal=fFinal;
	    this. nombAlumno=nombAlumno;
	    this.apProfesor=apProfesor;
	    this.nota=nota;
	}

	public String toFileTypeString(){
		return titulo+":"+descripcion+":"+fRegistro+":"+fComienzo+":"+fConvocatoria+":"+fFinal+":"+nombAlumno+":"+apProfesor+":"+nota;
	}
}

