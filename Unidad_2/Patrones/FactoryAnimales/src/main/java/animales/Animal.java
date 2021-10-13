package animales;

public abstract class Animal {

	private String name;

	public Animal(String name) {
		super();
		this.name = name;
	}
	
	public abstract String saludar();
}
