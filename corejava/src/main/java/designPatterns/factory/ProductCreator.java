package designPatterns.factory;

public class ProductCreator {
	public Product createProduct(String type) {
		if (" A ".equals(type)) {
			return new ProductA();
		}
		if (" B ".equals(type)) {
			return new ProductB();
		} else
			return null;
	}

	public static void main(String[] args) {
		ProductCreator creator = new ProductCreator();
		creator.createProduct(" A ").getName();
		creator.createProduct(" B ").getName();
	}
}
