package domini;

public class Casella {

	private int valor;
	private boolean isEditable;
	private boolean fitxa;
	
	public Casella(){
				
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean getIsEditable() {
		return isEditable;
	}
	
	public void setIsEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}
	
	public void setFitxa(boolean fitxa) {
		this.fitxa = fitxa;
	}

	public boolean getFitxa() {
		return this.fitxa;
	}
}
