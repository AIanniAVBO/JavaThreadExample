package org.avbo.tpsit.threadsexample;

import java.util.Scanner;

public class Main {
	/**
	 * Punto di ingresso del software. Chiede di
	 * inserire le variabili 'a', 'b' e 'c' e in
	 * seguito calcola l'espressione:
	 * <br>
	 * z = 5*[(2a + 4) * (7b + 3)] - 10c
	 * <br>
	 * Il calcolo verrà eseguito in parallelo secondo
	 * quanto ricavato dal grafo assiciato e dallo
	 * pseudo-codice
	 */
	public static void main(String[] args) {
		//Inizializza le variabili a, b e c
		int a, b, c;
		//Crea uno scanner per poter leggere i numeri
		//	dati in input. Si trova dentro un try
		//	in modo che venga fatto il close automaticamente
		try (Scanner input = new Scanner( System.in ))
		{
			//Richiede il valore di a
			System.out.println("Inserire il valore di a:");
			//Legge il valore di a
			a = input.nextInt();

			//Richiede il valore di b
			System.out.println("Inserire il valore di b:");
			//Legge il valore di b
			b = input.nextInt();
			
			//Richiede il valore di c
			System.out.println("Inserire il valore di c:");
			//Legge il valore di c
			c = input.nextInt();
		}
		//Crea l'oggetto che effettua l'operazione
		//	x = 7b + 3 passando b nel costruttore
		OP2Runnable op2 = new OP2Runnable(b);
		//Crea l'oggetto che effettua l'operazione
		//	y = 10c passando c nel costruttore
		OP3Runnable op3 = new OP3Runnable(c);
		//Dichiara due thread per poter eseguire le
		//	operazioni
		Thread threadOp2, threadOp3;
		//Crea il primo thread in modo esegua
		//	l'operazione op2
		threadOp2 = new Thread(op2);
		//Crea il secondo thread in modo esegua
		//	l'operazione op3
		threadOp3 = new Thread(op3);
		//Avvia entrambi i thread 
		//	(FORK nello pseudocodice)
		threadOp2.start();
		threadOp3.start();
		//Esegue la prima operazione per calcolare
		//	z sul thread corrente 
		//	in parallelo a op2 e op3
		int z = 2 * a + 4;
		//Per fare il join è necessario un try
		try {
			//Effettua il join su thread che sta
			//	eseguendo op2, in sostanza aspetta
			//	che termini di fare il calcolo
			threadOp2.join();
			//Calcola l'operazione successiva prendendo
			//	la x calcolata da op2
			z = z * op2.getX();
			//Moltiplica tutto per 5
			z = z * 5;
			//Effettua il join su thread che sta
			//	eseguendo op3, in sostanza aspetta
			//	che termini di fare il calcolo
			threadOp3.join();
			//Calcola l'operazione successiva 
			//	prendendo il risultato da op3
			z = z - op3.getY();
			//Stampa il risultato ottenuto
			System.out.println("Il risultato finale è: "
		} catch (InterruptedException e) {
			//Nel caso ci siano dei problemi nel join
			//	stampa il relativo errore
			e.printStackTrace();
		}
	}

}
