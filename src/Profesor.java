import java.util.Scanner;

public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private int despacho;

    public Profesor() {
        this.nombre = null;
        this.apellido = null;
        this.email = null;
        this.despacho = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAppellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAppellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    protected void leerProfesor() {
        Scanner sc = new Scanner(System.in);
        String s;
        int n;

        System.out.println("Procediendo a leer profesor:");
        System.out.print("Introduzca el nombre del profesor: ");
        s = sc.nextLine();
        this.setNombre(s);
        System.out.println("");
        System.out.print("Introduzca el apellido del profesor: ");
        s = sc.nextLine();
        this.setAppellido(s);
        System.out.println("");
        System.out.print("Introduzca el email del profesor: ");
        s = sc.nextLine();
        this.setEmail(s);
        System.out.println("");
        System.out.print("Introduzca el numero del despacho del profesor: ");
        n = sc.nextInt();
        this.setDespacho(n);
        System.out.println("");
        System.out.println("Se ha terminado de leer los datos. ");
    }

}
