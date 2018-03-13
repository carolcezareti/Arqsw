package folha;
public class Diretor extends Mensalista implements Bonus {

	public Diretor(String nome, double salario) {
		super(nome, salario);
	}

	@Override
	public double bonus() {
		return salario() * 0.1;
	}
}
