package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class metodos{


	/**
	 * Regresa la lista extraida del archivo, gracias a la ruta que se le envia desde el main
	 * @param ruta
	 * @return arreglo de la lista 
	 */
	public ArrayList<String> regresaRuta(String ruta) {

		ArrayList<String> lista= new ArrayList<String>();

		try {
			Scanner csvData1=new Scanner(new File(ruta));
			while(csvData1.hasNext()) {
				lista.add(csvData1.nextLine());
			}

		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return lista;

	}

	/* Limpia el array del documento leido  y le quita los números, signos de puntuacion y la palabra Booking.com
	 * @param texto
	 * @return array limpio
	 */
	public ArrayList<String> limpiar(ArrayList<String> texto){

		ArrayList<String> limpio= new ArrayList<String>();
		String temporal;

		for(int i=0;i<texto.size();i++) {
			temporal=texto.get(i);
			temporal=temporal.replaceAll("\\d", "");
			temporal=temporal.replaceAll("\\W", " ");
			temporal=temporal.replaceAll("Booking.com", "");

			limpio.add(temporal);

		}
		return limpio;		
	}


	/**
	 * Hace la comparación de las palabras con un archivo y las cuenta el numero de veces que se encuentran en el archivo 
	 * y las guarda en una nueva 
	 * @param texto
	 * @param ruta
	 * @return lista sin las palabras que se indican en el archivo 
	 */
	public ArrayList<String> contar(ArrayList<String> texto,String ruta){

		ArrayList<String> nueva= new ArrayList<String>();
		ArrayList<String> lista= new ArrayList<String>();
		ArrayList<String> numeros= new ArrayList<String>();
		String temporal = null;
		String palabra;
		int cont=0;

		try {
			Scanner csvData1=new Scanner(new File(ruta));
			while(csvData1.hasNext()) {
				lista.add(csvData1.nextLine());
			}

		}catch(Exception ex){
			System.out.println(ex.toString());
		}

		for(int j=0; j<lista.size();j++) {
			palabra=lista.get(j);
			cont=0;
			for(int i=0;i<texto.size();i++) {	
				temporal=texto.get(i);
				if(temporal.contains(palabra)) {
					//System.out.println(palabra);
					cont++;
				}	

			}
			numeros.add(Integer.toString(cont));

		}
		return numeros;		

	}



}
