package folha;

public interface Bonus {
	static double valor = 1000.0;

	double bonus();

	default double imposto(double aliquota) {
		return aliquota * bonus();
	}

	static double limite() {
		return valor;
	}
}
