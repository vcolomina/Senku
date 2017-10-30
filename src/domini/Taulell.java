package domini;

public class Taulell {

	private Casella taulell [][];
	
	public Taulell(){
		taulell = new Casella [7][7];
		init();	
	}

	private void init() {
		
		int num = 1;
		
		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell.length; j++) {
				
				// Creem la casella
				taulell[i][j] = new Casella();
				
				if( i > 1 && i < 5 || j > 1 && j < 5){ 
					if(i == 3 && j == 3){
						taulell[i][j].setFitxa(false);
					} else {
						taulell[i][j].setFitxa(true);
					}
					
					taulell[i][j].setIsEditable(true);
					taulell[i][j].setValor(num);
					num++;		
					
				} else{
					
					taulell[i][j].setIsEditable(false);
					taulell[i][j].setValor(0);
					
				}
				
			}
		}
	}

	public void moviment(int x, int y) throws IllegalArgumentException{
		
		if(esCorrecte(x) && esCorrecte(y))
			isMovimientoValido(x, y);
		
	}
	private boolean esCorrecte(int numcasella){
        if (!(numcasella > 0 && numcasella < 34)) {
        	throw new IllegalArgumentException("Error: Tria una casella entre el número 1 i el 33.");
        }
        
        return true;   
    }
    
	private int getFila (int casella){
        for (int i=0; i<taulell.length;i++)  {
            for (int j=0; j<taulell.length;j++)  {
                if (taulell[i][j].getValor() ==casella)
                    return i;
            }
        }
        return 0;
    }

    private int getColumna (int casella){
        for (int i=0; i<taulell.length;i++)  {
            for (int j=0; j<taulell.length;j++)  {
                if (taulell[i][j].getValor() == casella)
                    return j;
            }
        }
        return 0;
    }

    private int getPosMitg(int posA, int posB){
        if ((posA - posB) < 0)
            return (posA + 1);
        else if ((posA - posB) > 0)
            return (posA - 1);
        else
            return posA;
    }
    private boolean isMovimientoValido(int casella, int casella2){
        int oldY=getFila(casella);
        int oldX=getColumna(casella);
        int newY=getFila(casella2);
        int newX=getColumna(casella2);
        if ((Math.abs(oldY - newY) == 2) && (oldX - newX == 0))
            return comprobarMoviment(oldY,oldX,newY,newX);
        else if ((oldY - newY == 0) && (Math.abs(oldX - newX) == 2))
            return comprobarMoviment(oldY,oldX,newY,newX);
        else
        	throw new IllegalArgumentException("Error: S'ha de fer una moviment en vertical o horitzontal amb dos espais de separacio.");
    }

    private boolean comprobarMoviment (int oldY, int oldX, int newY, int newX){
        int migY=getPosMitg(oldY,newY);
        int migX=getPosMitg(oldX,newX);
        if (!taulell[oldY][oldX].getFitxa()){
        	throw new IllegalArgumentException("Error: No has seleccionat una casella amb fitxa.");
        }
        else if (taulell[newY][newX].getFitxa())
        	throw new IllegalArgumentException("Error: Hi ha fitxa a la casella final.");
        else if (!taulell[migY][migX].getFitxa())
        	throw new IllegalArgumentException("Error: La casella del mig no te fitxa.");
        else{
        	taulell[oldY][oldX].setFitxa(false);
            taulell[newY][newX].setFitxa(true);
            taulell[migY][migX].setFitxa(false);
            return true;
        }        
    }
	
	public String toString() {

		String result = "";

		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell.length; j++) {

				if (!taulell[i][j].getIsEditable()) {
					result += "       ";
				} else {
					if (!taulell[i][j].getFitxa()) {
						if (taulell[i][j].getValor() > 9)
							result += taulell[i][j].getValor() + " O   ";
						else
							result += " " + taulell[i][j].getValor() + " O   ";
					} else {
						if (taulell[i][j].getValor() > 9)
							result += taulell[i][j].getValor() + " X   ";
						else
							result += " " + taulell[i][j].getValor() + " X   ";
					}

				}
			}

			result += "\n";
		}

		return result;
	}
	
    public String getFelicitacio(){
    	
    	int contador = 0;
    	
    	for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell.length; j++) {
				if(taulell[i][j].getFitxa())
					contador++;
			}
		}
    	
    	if(contador <= 10 && contador >=5)
    		return "Força bé";
    	else if (contador <= 2 && contador >= 4)
    		return "Excel·lent";	
    	else if (contador == 1)
    		return "Ets un crac";	
    	
    	return "";
    	
    }
}
