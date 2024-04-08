package org.avbo.tpsit.threadsexample;


/**
 * Classe che esegue l'operazione definita
 * come op2 nello pseudo-codice: x = 7b + 3
 */
public class OP2Runnable implements Runnable {
	/**
	 * Contiene il risultato dell'operazione
	 */
	private int x;
	/**
	 * Variabile da utilizzare per fare il calcolo
	 */
	private int b;
	/**
	 * Oggetto che effettua il calcolo
	 * x = 7b + 3
	 * @param b variabile da usare nel calcolo
	 */
	public OP2Runnable(int b) {
		this.b = b;
	}
	/**
	 * @return Restituisce la variabile impostata
	 */
	public int getB() {
		return b;
	}
	/**
	 * Modifica la variabile da usare
	 * per fare il calcolo
	 * @param b Valore da impostare
	 */
	public void setB(int b) {
		this.b = b;
	}
	/**
	 * Restituisce il risultato dell'operazione,
	 * da verificare dopo l'esecuzione del
	 * metodo run
	 * @return risultato dell'operazione
	 */
	public int getX() {
		return x;
	}
	/**
	 * Esegue il calcolo x = 7b + 3
	 */
	@Override
	public void run() {
		//Effettua il calcolo
		x = 7 * b + 3;
	}

}
