package ro.ase.csie.cts.g1088.dp.factory.method;

public abstract class FactoryAbstractCaracter {
	// avem meetoda care nu mai este statica ca la cel simplu pt ca instantiem factory-ul
	
	public abstract CaracterJoc getCaracter(TipCaracter tip, String nume);
}
