package ro.ase.csie.cts.g1088.testare.teste;

import static org.junit.Assert.*; 

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.g1088.testare.exceptii.ExceptieNota;
import ro.ase.csie.cts.g1088.testare.exceptii.ExceptieNume;
import ro.ase.csie.cts.g1088.testare.exceptii.ExceptieVarsta;
import ro.ase.csie.cts.g1088.testare.modele.Student;
import ro.ase.csie.cts.g1088.testare.teste.categorii.TestImportant;
import ro.ase.csie.cts.g1088.testare.teste.categorii.TestPerformanta;

public class TestStudent {
	
	// test fixture - setul de date de care avem nevoie intr-un test (cele cu static)
	static Student student;
	static ArrayList<Integer> note;
	static String numeInitial = "Gigel";
	static int varstaInitiala = 21;

	//se executa o singura data inainte de unit test (o singura data per total)
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		note = new ArrayList<>(); // stergem ArrayLista sa nu facem shadowing
		note.add(9);
		note.add(7);
		note.add(10);
		
	}
	//se executa o singura data dupa de unit test (o singura data per total)
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// avem masina virtuala care face deja asta
		note.clear();
		note=null;
	}
	//se executa inainte de fiecare unit test (daca am 5 unit test se va executa de 5 ori)
	@Before
	public void setUp() throws Exception {
		// il punem aici ca sa cream de fiecrea data studentul ca sa nu fie modificat de fiecare test in parte(valorile initiale nu se modifica)
		student = new Student(numeInitial, varstaInitiala, note); // de aici stergem Student din fata ca sa nu facem shadowing
	}
	//se executa dupa fiecare unit test (daca am 5 unit test se va executa de 5 ori)
	@After
	public void tearDown() throws Exception {
		// avem masina virtuala care face deja asta
		student = null; // sa fim siguri ca e o singura referinta, altfel obiectul nu e distrus
	}

	// cum ignoram un test? -> am putea comenta testul sau sterge (solutii nerecomandate)
	// Metoda corecta => adaugam @Ignore - testul tot apare dar nu este executat (are iconita gri)
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//TESTE CONFORMANCE
	
	
	@Test
	public void testSetVarstaConformanceRight() throws ExceptieVarsta {
		
		int varstaNoua = 23;
		// avem doua variante de erori -> de preferat add throws Exceptie pt ca e mai putin cod
		student.setVarsta(varstaNoua);
		//test right pentru setVarsta
		assertEquals("Test cu valori corecte", varstaNoua, student.getVarsta());
		
	}
	
	@Test
	public void testSetNumeRight() {
		// nu e ok sa facem copy paste la codul de mai sus
		// folosim metodele care se executa automat de mai sus - adaugam partea care e comuna pentru toate testele
		String numeNou = "Ana";
		// testele trebuie sa fie independente - sa ruleze independent
		try {
			student.setNume(numeNou);
			assertEquals("Test cu valori corecte", numeNou, student.getNume());
		} catch (ExceptieNume e) {
			fail("Genereaza exceptie pentru valori corecte");
		}
	}
	
	// TESTE ERROR CONDITION
	
	@Test
	public void testSetVarstaErrorCondition() {
		//sa evitam hardcodarea
		int varstaNoua = Student.MIN_VARSTA - 1;
		try {
			student.setVarsta(varstaNoua);
			fail("NU genereaza exceptie pentru varsta in afara limitelor");
		} catch (ExceptieVarsta e) {
			// e bine sa intram pe catch acum
			assertTrue(true);
		}
		
	}
	
	@Test(expected = ExceptieNume.class)
	public void testSetNumeErrorCondition() throws ExceptieNume {
		String numeNou = "Io";
		student.setNume(numeNou);
	}
	
	
	//ORDERING
	@Category({TestPerformanta.class, TestImportant.class})
	@Test
	public void testGetNotaMinimaOrderingSetSortatCrescator() throws ExceptieNota {
		int notaMinima = 4;
		ArrayList<Integer> note = new ArrayList<>();
		for(int i = 0;  i < 5; i++) {
			note.add(i+notaMinima);
		}
		student.setNote(note);
		
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test cu valori sortate crescator", notaMinima, notaMinimaCalculata);
	}
	
	//CARDINALITATE ZERO
	@Test
	public void testGetNotaMinimaCardinalityZero() throws ExceptieNota {
		ArrayList<Integer> note = new ArrayList<>();
		student.setNote(note);
		int notaMinima = 0;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test fara note", notaMinima, notaMinimaCalculata);
	}
	
	//CARDINALITATE UNU
	@Test
	public void testGetNotaMinimaCardinalityUnu() throws ExceptieNota {
		ArrayList<Integer> note = new ArrayList<>();
		note.add(Student.MAX_NOTA);
		
		student.setNote(note);
		
		int notaMinima = student.MAX_NOTA;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test cu o singura nota", notaMinima, notaMinimaCalculata);
	}
	
	//EXISTANCE
	@Test
	public void getNotaMinimaExistanceReferintaNoteNull() throws ExceptieNota {
		
		student.setNote(null);
		int notaMinima = 0;
		int notaMinimaCalculata = student.getNotaMinima();
		assertEquals("Test cu referinta null pentru note", notaMinima, notaMinimaCalculata);
		
	}

}
