package org.avbo.tpsit.threadsexample;


/**
 * Classe che esegue l'operazione definita
 * come op3 nello pseudo-codice: y = 10c.
 * 
 * Avevo molte cose in comune con Op2 sarebbe
 * stato più corretto creare una classe base con
 * le parti comuni e cambiare solo l'operazione eseguita.
 * In questo esempio è stato scelto di non farlo
 * per rendere il codice più semplice da leggere. 
 */
public class OP3Runnable implements Runnable {
	/**
	 * Contiene il risultato dell'operazione
	 */
	private int y;
	/**
	 * Variabile da utilizzare per fare il calcolo
	 */
	private int c;
	/**
	 * Oggetto che effettua il calcolo
	 * y = 10c
	 * @param c variabile da usare nel calcolo
	 */
	public OP3Runnable(int c) {
		this.c = c;
	}
	/**
	 * @return Restituisce la variabile impostata
	 */
	public int getC() {
		return c;
	}
	/**
	 * Modifica la variabile da usare
	 * per fare il calcolo
	 * @param b Valore da impostare
	 */
	public void setC(int c) {
		this.c = c;
	}
	/**
	 * Restituisce il risultato dell'operazione,
	 * da verificare dopo l'esecuzione del
	 * metodo run
	 * @return risultato dell'operazione
	 */
	public int getY() {
		return y;
	}
	/**
	 * Esegue il calcolo y = 10c
	 */
	@Override
	public void run() {
		//Effettua il calcolo
		y = 10 * c;
	}

}
