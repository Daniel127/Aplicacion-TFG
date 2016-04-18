package Utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorIO {

	private static BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
	private static GestorIO gestorIO = new GestorIO();

	public static GestorIO getGestorIO() {
		return gestorIO;
	}

	private GestorIO() {
	}

	public String leerString(String mensaje) {
		String entrada = null;
		boolean valido = false;
		do {
			this.escribir(mensaje);
			try {
				entrada = br.readLine();
				valido = true;
			} catch (Exception e) {
				this.error("de cadena de caracteres");
			}
		} while (!valido);
		return entrada;
	}

	public int leerInt(String mensaje) {
		int entrada = 0;
		boolean valido = false;
		do {
			try {
				entrada = Integer.parseInt(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("entero");
			}
		} while (!valido);
		return entrada;
	}

	public float leerFloat(String mensaje) {
		float entrada = 0;
		boolean valido = false;
		do {
			try {
				entrada = Float.parseFloat(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("real");
			}
		} while (!valido);
		return entrada;
	}

	public double leerDouble(String mensaje) {
		double entrada = 0.0;
		boolean valido = false;
		do {
			try {
				entrada = Double.parseDouble(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("real");
			}
		} while (!valido);
		return entrada;
	}

	public long leerLong(String mensaje) {
		long entrada = 0;
		boolean valido = false;
		do {
			try {
				entrada = Long.parseLong(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("entero");
			}
		} while (!valido);
		return entrada;
	}

	public byte leerByte(String mensaje) {
		byte entrada = 0;
		boolean valido = false;
		do {
			try {
				entrada = Byte.parseByte(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("entero");
			}
		} while (!valido);
		return entrada;
	}

	public short leerShort(String mensaje) {
		short entrada = 0;
		boolean valido = false;
		do {
			try {
				entrada = Short.parseShort(this.leerString(mensaje));
				valido = true;
			} catch (Exception e) {
				this.error("entero");
			}
		} while (!valido);
		return entrada;
	}

	public char leerChar(String mensaje) {
		char caracter = ' ';
		boolean valido = false;
		do {
			String entrada = this.leerString(mensaje);
			if (entrada.length() != 1) {
				this.error("caracter");
			} else {
				caracter = entrada.charAt(0);
				valido = true;
			}
		} while (!valido);
		return caracter;
	}

	public boolean leerBoolean(String mensaje) {
		boolean entradaLogica = true;
		boolean valido = false;
		do {
			String entrada = this.leerString(mensaje);
			if (entrada.equalsIgnoreCase("true") ||
					entrada.equalsIgnoreCase("false")) {
				entradaLogica = Boolean.valueOf(entrada).booleanValue();
				valido = true;
			} else {
				this.error("logico");
			}
		} while (!valido);
		return entradaLogica;
	}

	public void escribir(String salida) {
		System.out.print(salida);
	}

	public void escribirLinea(String salida) {
		System.out.println(salida);
	}

	public void escribir(int salida) {
		System.out.print(salida);
	}

	public void escribirLinea(int salida) {
		System.out.println(salida);
	}

	public void escribir(float salida) {
		System.out.print(salida);
	}

	public void escribirLinea(float salida) {
		System.out.println(salida);
	}

	public void escribir(double salida) {
		System.out.print(salida);
	}

	public void escribirLinea(double salida) {
		System.out.println(salida);
	}

	public void escribir(long salida) {
		System.out.print(salida);
	}

	public void escribirLinea(long salida) {
		System.out.println(salida);
	}

	public void escribir(byte salida) {
		System.out.print(salida);
	}

	public void escribirLinea(byte salida) {
		System.out.println(salida);
	}

	public void escribir(short salida) {
		System.out.print(salida);
	}

	public void escribirLinea(short salida) {
		System.out.println(salida);
	}

	public void escribir(char salida) {
		System.out.print(salida);
	}

	public void escribirLinea(char salida) {
		System.out.println(salida);
	}

	public void escribir(boolean salida) {
		System.out.print(salida);
	}

	public void escribirLinea(boolean salida) {
		System.out.println(salida);
	}

	public void escribirLinea() {
		System.out.println();
	}

	private void error(String formato) {
		System.out.println("ERROR DE FORMATO! " +
				"Introduzca un valor con formato " + formato + ".");
	}

	public static void main(String args[]) {
		GestorIO gestorIO = GestorIO.getGestorIO();
		gestorIO.escribirLinea(gestorIO.leerInt("ENTERO? "));
		gestorIO.escribirLinea(gestorIO.leerChar("CARACTER? "));
		gestorIO.escribirLinea(gestorIO.leerFloat("REAL? "));
		gestorIO.escribirLinea(gestorIO.leerBoolean("BOOLEAN? "));
	}
}

