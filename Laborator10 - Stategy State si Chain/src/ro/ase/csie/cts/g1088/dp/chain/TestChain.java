package ro.ase.csie.cts.g1088.dp.chain;

public class TestChain {

	public static void main(String[] args) {
		
		// trebuie definite cele 3 module, nu conteaza ordinea
		ModulProcesareMesaj modulFiltru = new ModulFiltruRomana();
		ModulProcesareMesaj modulPrivat = new ModulMesajePrivate();
		ModulProcesareMesaj modulGrup = new ModulMesajeGrup();
		
		modulFiltru.setNext(modulPrivat);
		modulPrivat.setNext(modulGrup);
		
		ModulProcesareMesaj serverChat = modulFiltru;
		
		serverChat.procesareMesaj(new MesajChat("Salut!", 3, "@Gigel"));
		serverChat.procesareMesaj(new MesajChat("Esti un jucator rau!", 0, "@Gigel"));
		serverChat.procesareMesaj(new MesajChat("Salut tuturor!", 0, "@everyone"));

	}

}
