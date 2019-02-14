package examenbecas;

public class BecaFP extends Beca{
	private String ciudad;
	private String codigo;
	private static int contadorCodigo=1;
	
	public BecaFP(String dnialumno, double renta, String ciudad) {
		super(dnialumno, renta);
		this.ciudad = ciudad;
		this.codigo = "FP" + contadorCodigo;
		this.contadorCodigo++;
	}
	
	public int darPuntuacion () {
		if (ciudad.equalsIgnoreCase("madrid"))
			puntuacion+=1;
		if (renta < 6000)
			puntuacion+=2;
		if (renta >= 6000 && renta <= 10000)
			puntuacion+=1;
		return puntuacion;
	}

	@Override
	public String toString() {
		return "BecaFP [ciudad=" + ciudad + ", codigo=" + codigo + ", toString()=" + super.toString() + "]";
	}

	
	
}