package ro.ase.csie.cts.g1088.dp.command;

import java.util.ArrayList;
import java.util.List;

public class ManagerTaskuri {
	
	List<InterfataTaskAsincron> taskuri = new ArrayList<>();
	
	public void adaugaTask(InterfataTaskAsincron task) {
		taskuri.add(task);
	}
	
	public void executaUrmatorulTask() {
		if(taskuri.size() > 0) {
			// daca verificam in functie de prioritate ar trebui 
			//sa parcurgem cu for si sa gasim taskul 
			//cu prioritatea cea mai mare
			// ar fi bine sa fie un heap(coada de prioritati)
			InterfataTaskAsincron task = taskuri.get(0);
			task.startTaskAsincron();
			taskuri.remove(0);
		}
	}

}
