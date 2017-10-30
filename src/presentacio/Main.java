package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import domini.Taulell;


public class Main {
		
    public static void main(String[] args) {
    	
    	Taulell taulell = new Taulell();
    	
    	int resposta = 0;
    	int casella1;
    	int casella2;
    	
    	
    	System.out.println("\t\tSENKU v.1\n");
    	System.out.println("*********************************************************");
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (resposta != -1){
    	
    		System.out.println(taulell.toString());
    		System.out.println("Introdueix la casella que vols seleccionar (-1 per acabar)");
            
    		boolean ok = false;
    		String input = "";
    		
    		while(!ok){
	    		try {
	    			input = br.readLine();
	    			resposta = Integer.parseInt(input);
	    			ok = true;
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					System.out.println("Introdueix la casella que vols seleccionar (-1 per acabar)");
				}
    		}
    		
    		if(resposta != -1){
    			
    			System.out.println("Introdueix la casella on la vols moure");
                
    			casella1 = resposta;
    			resposta = 0;
    			ok = false;
    			
    			while (!ok){
	    			try {
	    				
	    				input = br.readLine();
	    				resposta = Integer.parseInt(input);
	    				ok = true;
	    				
	    			} catch (Exception e) {
	    				System.out.println("Error: " + e.getMessage());
	    				System.out.println("Introdueix la casella on la vols moure");
	    			}
    			}
    			if(resposta != -1){
    				casella2 = resposta;
    				
    				try {
    					taulell.moviment(casella1, casella2);
    					System.out.println("Resultat de moure la fitxa de la casella " + casella1 + " a la casella " + casella2 + ".");
    					System.out.println();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
    				
    			}
    			
    		}
    		
    	}
    	
    	System.out.println("Fi del joc. " + taulell.getFelicitacio());
    	
    }
    
}
