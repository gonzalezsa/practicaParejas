package examenbecas;

public class BecaLibro extends Beca{
	private int nota;
	private String codigo;
	private static int contadorCodigo=1;
	
	public BecaLibro(String dnialumno, double renta, int nota) {
		super(dnialumno, renta);
		this.nota = nota;
		this.codigo = "LI" + contadorCodigo;
		contadorCodigo++;
	}
	
	public int darPuntuacion() {
		if (nota==7 || nota==8)
			puntuacion+=1;
		if (nota==9 || nota==10)
			puntuacion+=2;
		if (renta < 6000)
			puntuacion+=2;
		return puntuacion;
	}

	@Override
	public String toString() {
		return "BecaLibro [nota=" + nota + ", codigo=" + codigo + ", toString()=" + super.toString() + "]";
	}
	
	
}