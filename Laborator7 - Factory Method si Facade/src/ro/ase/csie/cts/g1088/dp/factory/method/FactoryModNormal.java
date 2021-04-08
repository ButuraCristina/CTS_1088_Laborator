package ro.ase.csie.cts.g1088.dp.factory.method;

import java.nio.channels.UnsupportedAddressTypeException;

public class FactoryModNormal extends FactoryAbstractCaracter{

	@Override
	public CaracterJoc getCaracter(TipCaracter tip, String nume) {
		
		CaracterJoc caracter = null;
		switch(tip) {
		case DISNEY:
			caracter = new CaracterDisney(nume);
			break; // ATENTIE LA BREAK - TREBUIE PUS PT CA DACA UITAM DE EL SI TESTAM IN MAIN O SA RETURNEZE INTOTDEAUNA UN TIP - NU IESE DIN CASE
		case MARVEL:
			caracter = new CaracterMarvel(nume, 300);
			break;
		case DC: 
			caracter = new CaracterDCComics(nume);
			break;
		default:
			throw new UnsupportedOperationException();
	
	}
		return caracter;

}
}
