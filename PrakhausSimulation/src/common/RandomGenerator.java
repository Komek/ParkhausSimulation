package common;

public class RandomGenerator {

	private double lambda;

	public RandomGenerator(double lambda) {
		this.lambda = lambda;
	}

	public void setLambda(double lamdba) {
		this.lambda = lambda;
	}

	public double setLambda() {
		return lambda;
	}

	public double generate() {
		return 0; // TODO Exponentialverteilung muss zurück gegeben werden
	}

}
