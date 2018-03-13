package folha;
public class Mensalista extends Empregado{
   private double salario;
   
   public Mensalista(String nome, double salario){
      super(nome);
      this.salario = salario;
   }

   @Override
   public double salario(){
      return this.salario;
   }
}