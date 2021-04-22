package ro.ase.csie.cts.g1088.dp.decorator;

public class TestDecorator {

	public static void main(String[] args) {
		
		SuperErou dragon = new Dragon("Dragonul albastru", 1000);
		dragon.alearga();
		dragon.esteLovit(800);
		dragon.seVindeca(100);
		
		SuperErou dragon2 = new Dragon("Dragonul galben", 1000);
		dragon2.alearga();
		dragon2.esteLovit(200);
		dragon2.seVindeca(100);
		
		// aplicam decoratori pe primul dragon
		// putem face in 2 pasi sau in unul
		
		//2 pasi
		//SuperErou dragonCuArmura = new DecoratorArmura(dragon, 300);
		//dragonCuArmura.esteLovit(400);
		
		//intr-un singur pas - este mai ok
		dragon = new DecoratorArmura(dragon, 300);
		dragon.esteLovit(400);
		
		// in cascada
		dragon = new DecoratorEsteRanit(dragon);
		dragon.esteLovit(400);
		dragon.alearga();

	}

}
