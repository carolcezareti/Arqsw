import javax.swing.JOptionPane;
public class Ex01 {
   // main
   public static void main(String args[]) {
      // variáveis
      int vet[] = new int[6];
      // double vet[] = new double[10];
      int cont;
      
      // preencher vetor
      for (cont = 0; cont < vet.length; cont++) {
         vet[cont] = (int)(Math.random() * 60) + 1;
      }

      // exibir vetor
      for (cont = 0; cont < vet.length; cont++) {
         System.out.println("[" + cont + "] = " + vet[cont]);
      }

      // sair do programa
      System.exit(0);   
   }
}