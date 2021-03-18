package ro.ase.csie.cts.g1088.Laborator3.faza3.servicii;

import ro.ase.csie.cts.g1088.Laborator3.exceptii.ExceptiePretInvalid;
import ro.ase.csie.cts.g1088.Laborator3.exceptii.ExceptieVechimeClient;

public interface InterfataValidare {

	public void validarePret(float pretInitial) throws ExceptiePretInvalid;
	public void validareVechimeClient(int vechimeClientInAni) throws ExceptieVechimeClient;
}
