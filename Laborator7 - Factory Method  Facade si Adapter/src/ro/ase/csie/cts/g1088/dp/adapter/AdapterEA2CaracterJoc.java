package ro.ase.csie.cts.g1088.dp.adapter;

import ro.ase.csie.cts.g1088.dp.factory.method.CaracterJoc;

public class AdapterEA2CaracterJoc extends CaracterJoc {

	
	InterfataCaracterEA caracterEA;

	public AdapterEA2CaracterJoc(InterfataCaracterEA cracterEA) {
		super();
		this.caracterEA = cracterEA;
	}

	@Override
	public void seDeplaseaza() {
	
		caracterEA.move();
		
	}
	
	
}
