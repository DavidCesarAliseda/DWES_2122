package animales;

public class Main {

	public static void main(String[] args) {
		
		Animal a  =  FactoryAnimales.getAnimal("perro", "lulu");
		
		System.out.println(a.saludar());
		
	}
}
