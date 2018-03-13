package folha;
import java.util.ArrayList;

public class TesteEmpregado {
	public static void main(String[] args) {
		ArrayList<Empregado> empregados = new ArrayList<>();
		empregados.add(new Mensalista("Jose Pereira", 3500.00));
		empregados.add(new Gerente("Roberto Almeida", 7000.00));
		empregados.add(new Diretor("Joao Silva", 25000.00));
		empregados.add(new Comissionado("Maria Pereira", 1500.00, 5000.00));
		
		for(Empregado emp:empregados){
			System.out.println(emp.getNome());
			System.out.println(emp.salario());
			if(emp instanceof Bonus){
				System.out.println(((Bonus)emp).bonus());
			}
		}
	}

}