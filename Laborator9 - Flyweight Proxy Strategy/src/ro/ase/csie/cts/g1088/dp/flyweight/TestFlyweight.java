package ro.ase.csie.cts.g1088.dp.flyweight;

public class TestFlyweight {
	
	// mail+ctrl+space -> pt a genera mai usor main-ul

	public static void main(String[] args) {
		
		DateEcran soldat1 = new DateEcran(100, 50, 50, "Verde");
		DateEcran soldat2 = new DateEcran(100, 100, 50, "Rosu");
		DateEcran cladire1 = new DateEcran(10, 10, 0, "Gri");
		DateEcran cladire2 = new DateEcran(107, 150, 0, "Maro");
		
		// afisare
		// separat
		InterfataFlyweightModel3D modelSoldat = Model3DFactory.getModel(TipModel3D.SOLDAT);
		modelSoldat.afisareEcran(soldat1);
		modelSoldat.afisareEcran(soldat2);
		
		// intr-o singura linie
		Model3DFactory.getModel(TipModel3D.CLADIRE).afisareEcran(cladire1);
		Model3DFactory.getModel(TipModel3D.CLADIRE).afisareEcran(cladire2);

	}

}
