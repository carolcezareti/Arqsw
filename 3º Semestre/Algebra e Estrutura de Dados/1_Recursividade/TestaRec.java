import javax.swing.JOptionPane;
public class TestaRec {
   static Recursividade obj;
   public static void main(String args[]) {
      // variáveis e objetos
      obj = new Recursividade();
      String opcoes[] = {"21", "22", "23", "Fim"};
      int    opcao;
      //menu
      do {
         opcao = JOptionPane.showOptionDialog(
                     null,
                     "Qual exercício?",
                     "Recursividade...",
                     JOptionPane.DEFAULT_OPTION,
                     JOptionPane.WARNING_MESSAGE,
                     null,
                     opcoes,
                     opcoes[0]);
         if      (opcao == 0) ex21();
         else if (opcao == 1) ex22();
         else if (opcao == 2) ex23();
      } while (opcao != opcoes.length-1);
      // fim
      System.exit(0);
   }
   // ex21
   public static void ex21() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Fatorial de qual inteiro?"));
      JOptionPane.showMessageDialog(null, "O fatorial de " + nro + " é " + obj.fatRec(nro));
   }
   // ex22
   public static void ex22() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Qual termo de FIBONACCI?"));
      JOptionPane.showMessageDialog(null, "O " + nro + "o. termo de Fibonacci é " + obj.fibRec(nro));
   }
   // ex23
   public static void ex23() {
      int vet[] = {47, 18, 25, 10};
      // JOptionPane.showMessageDialog(null, "Soma do vetor: " + obj.somaVetorRec(vet));
   }

}