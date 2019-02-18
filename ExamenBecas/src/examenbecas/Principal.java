package examenbecas;
import java.util.*;

public class Principal {
	static final int MAXBECAS=20;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ciudad;
		Vector<Beca> becas=new Vector<Beca>(MAXBECAS);
		int tipo, menu;
		int nota;
		
		// Se añaden tantas solicitudes como desee el usuario
		
		do{
				System.out.println("Dni del solicitante: ");
				String dni=sc.nextLine();
				
				int encontrado=becas.indexOf(new Beca(dni));
				
				if(encontrado == -1){
					System.out.println("Renta percápita del solicitante: ");
					double renta=sc.nextDouble();
					do {
						System.out.println("¿Qué tipo de beca desea? (1-FP, 2-Libros): ");
						tipo=sc.nextInt();
					}while(tipo!=1&&tipo!=2);
					if(tipo==1) {
						sc.nextLine();
						System.out.println("Ciudad: ");
						ciudad=sc.nextLine();
						becas.add(new BecaFP(dni, renta, ciudad));
					}
					else {
						System.out.println("Nota: ");
						nota=sc.nextInt();
						becas.add(new BecaLibro(dni, renta, nota));
					}
				}
				else
					System.out.println("Este alumno ya ha hecho una solicitud");
				
				if (becas.size()==MAXBECAS)
					break;
				System.out.println("Añadir otra solicitud:1. Si\n2. No");
				menu=sc.nextInt();
				sc.nextLine();
		}while(menu==1);
		//USU2 AÑADE CODIGO PARA QUE SALTE EL ERROR
		System.out.println("\nDamos puntuación a las becas*************");
		
		for(int cont=0; cont < becas.size(); cont++){
			becas.get(cont).darPuntuacion();
			System.out.println(becas.get(cont).toString());	
		}
		
		System.out.println("\nOrdenamos las becas por puntos, y a puntos iguales por menos renta***********");
		int j,k;
		Beca aux;
		for(j = 1; j < becas.size(); j++)
			for(k = 0; k < becas.size()-1; k++){
				
				if(becas.get(k).getPuntuacion() < becas.get(k+1).getPuntuacion()  || 
						becas.get(k).getPuntuacion() == becas.get(k+1).getPuntuacion() && becas.get(k).getRenta() > becas.get(k+1).getRenta()){
					
					aux=becas.get(k);
					becas.set(k, becas.get(k+1));
					becas.set(k+1, aux);				
				}
				
			}
		
		/* Mostramos las puntuaciones de todas las becas */
		for(int cont=0; cont < becas.size(); cont++)
			System.out.println(becas.get(cont));
					
		System.out.println("\nMostramos únicamente las becas de FP y eliminamos las que tienen 0 puntos****");
		// Elimino del array las becas de FP con 0 puntos
		for(int cont=0; cont < becas.size(); cont++) {
			if(becas.get(cont) instanceof BecaFP&&becas.get(cont).getPuntuacion()==0) {
				becas.remove(cont);
				cont--;
			}
		}
		// Muestro por pantalla las becas de FP
		for(int cont=0; cont < becas.size(); cont++)
			if(becas.get(cont) instanceof BecaFP)
				System.out.println(becas.get(cont));
	}
	
	
	
}
