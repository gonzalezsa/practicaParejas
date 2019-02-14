package examenbecas;
import java.util.*;

public class Principal {
    static final int MAXBECAS=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Beca becas[]=new Beca[MAXBECAS];
		int numBecas=0;
		
		int menu;
		
		// Se añaden tantas solicitudes como desee el usuario
		
		
		do{
			
			
				System.out.println("Dni del solicitante: ");
				String dni=sc.nextLine();
				
				int encontrado=buscarDni(dni, becas, numBecas);
				
				if(encontrado == -1){
					System.out.println("Renta percápita del solicitante: ");
					double renta=sc.nextDouble();
					sc.nextLine();
					
									
					becas[numBecas]=new Beca(dni, renta);
					numBecas++;
						
				}
				else
					System.out.println("Este alumno ya ha hecho una solicitud");
				
				if (numBecas==MAXBECAS)
					break;
				System.out.println("Añadir otra solicitud:1. Si\n2. No");
				menu=sc.nextInt();
			
		}while(menu==1);
		
		System.out.println("Damos puntuación a las becas*************");
		
		for(int cont=0; cont < numBecas; cont++){
			becas[cont].darPuntuacion();
			System.out.println(becas[cont].toString());	
		}
		
		System.out.println("Ordenamos las becas por puntos, y a puntos iguales por menos renta***********");
		int j,k;
		Beca aux;
		for(j = 1; j < numBecas; j++)
			for(k = 0; k < numBecas-1; k++){
				
				if(becas[k].getPuntuacion() < becas[k+1].getPuntuacion()  || 
				   becas[k].getPuntuacion() == becas[k+1].getPuntuacion() && becas[k].getRenta() > becas[k+1].getRenta()){
					
					aux=becas[k];
					becas[k]=becas[k+1];
					becas[k+1]= aux;				
				}
				
			}
		
		/* Mostramos las puntuaciones de todas las becas */
		for(int cont=0; cont < numBecas; cont++)
			System.out.println(becas[cont]);
						
	}

	
	public static int buscarDni(String dni, Beca becas[],int tam){
		
		for(int cont=0; cont < tam;cont++)
			if(becas[cont].getDnialumno().equals(dni))
				return cont;
		return -1;
	}
	
	
	
}
