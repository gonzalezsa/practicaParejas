package examenbecas;

public class Beca {

	private String dnialumno;
	private double renta;
	private int puntuacion;
		
	public Beca(String dnialumno, double renta) {
		super();
		this.dnialumno = dnialumno;
		this.renta = renta;
	}

	public String getDnialumno() {
		return dnialumno;
	}

	public double getRenta(){
		return renta;
	}
	
	public void setRenta(double renta) {
		this.renta = renta;
	}

	public int darPuntuacion() {
			if(renta < 6000)
				puntuacion=2;
			if(renta >= 6000 && renta <= 10000)
				puntuacion=1;
			return puntuacion;
	}
	
	
	public int getPuntuacion(){
		return puntuacion;
	}

	@Override
	public String toString() {
		return "Dni= " + dnialumno + ", Renta= " + renta +", puntuacion= " + puntuacion;
	}
	
	
}
