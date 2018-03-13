package folha;
public class Gerente extends Empregado implements Bonus {

	private double salario;

	public Gerente(String nome, double salario) {
		super(nome);
		this.salario = salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public double bonus() {
		return salario * 0.5;
	}

	@Override
	public double salario() {
		return salario;
	}

}
