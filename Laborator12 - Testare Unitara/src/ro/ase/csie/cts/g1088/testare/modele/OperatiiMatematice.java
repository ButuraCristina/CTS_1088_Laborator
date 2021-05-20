package ro.ase.csie.cts.g1088.testare.modele;

import ro.ase.csie.cts.g1088.testare.exceptii.ExceptieImpartireLaZero;

public class OperatiiMatematice {
	
	// punem static ca sa nu instantiem oeratiile
	public static int suma(int a, int b) {
		return a + b;
	}
	
	public static double impartire(int a, int b) throws ExceptieImpartireLaZero {
		if(b == 0) {
			throw new ExceptieImpartireLaZero();
		}
		//return (double)a/b;
		return a / b;
	}
	

}
