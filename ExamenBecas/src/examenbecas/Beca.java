package examenbecas;

public class Beca {

	private String dnialumno;
	protected double renta;
	protected int puntuacion;
		
	public Beca(String dnialumno, double renta) {
		super();
		this.dnialumno = dnialumno;
		this.renta = renta;
	}

	public Beca(String dnialumno) {
		super();
		this.dnialumno = dnialumno;
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
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Beca other = (Beca) obj;
		if (dnialumno == null) {
			if (other.dnialumno != null)
				return false;
		} else if (!dnialumno.equals(other.dnialumno))
			return false;
		return true;
	}

	public int getPuntuacion(){
		return puntuacion;
	}

	@Override
	public String toString() {
		return "Dni= " + dnialumno + ", Renta= " + renta +", puntuacion= " + puntuacion;
	}
	
	
}
