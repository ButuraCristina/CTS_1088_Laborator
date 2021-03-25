package ro.ase.csie.cts.g1088.dp.singleton.versiune.statica;

public class TestSigleton {

	public static void main(String[] args) {
		
		ConexiuneBD conexiune1 = ConexiuneBD.conexiune;
		ConexiuneBD conexiune2 = ConexiuneBD.conexiune;
		
		if(conexiune1 == conexiune2) {
			System.out.println("Cele doua conexiuni sunt identice");
		}
		else {
			System.out.println("Cele doua conexiuni sunt diferite");
		}

	}

}
