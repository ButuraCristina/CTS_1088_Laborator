package ro.ase.csie.cts.g1088.dp.decorator;

public abstract class DecoratorErouAbstract extends SuperErou {
	
	//referinta catre obiectul pe care il vom decora
	SuperErou erou = null;
	
	//trebuie sa primesc referinta la SuperErou
	public DecoratorErouAbstract(SuperErou erou) {
		super(erou.nume, erou.puncteViata);
		this.erou = erou;
	}

	
	// source -> override/implemet methods
	
	@Override
	public void alearga() {
		this.erou.alearga();
		
	}

	@Override
	public void esteLovit(int puncte) {
		this.erou.esteLovit(puncte);
		
	}

	@Override
	public void seVindeca(int puncte) {
		this.erou.seVindeca(puncte);
		
	}


	@Override
	public int getPuncteViata() {
		return this.erou.getPuncteViata();
	}



}
