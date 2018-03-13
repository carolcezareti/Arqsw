import javax.swing.JOptionPane;
public class TestaRec {
   static Recursividade obj;
   public static void main(String args[]) {
      // vari�veis e objetos
      obj = new Recursividade();
      String opcoes[] = {"21", "22", "23", "24", "25", "26", "27", "30", "Fim"};
      int    opcao;
      //menu
      do {
         opcao = JOptionPane.showOptionDialog(
                     null,
                     "Qual exerc�cio?",
                     "Recursividade...",
                     JOptionPane.DEFAULT_OPTION,
                     JOptionPane.WARNING_MESSAGE,
                     null,
                     opcoes,
                     opcoes[0]);
         if      (opcao == 0) ex21();
         else if (opcao == 1) ex22();
         else if (opcao == 2) ex23();
         else if (opcao == 3) ex24();
         else if (opcao == 4) ex25();
         else if (opcao == 5) ex26();
         else if (opcao == 6) ex27();
         else if (opcao == 7) ex30();
      } while (opcao != opcoes.length-1);
      // fim
      System.exit(0);
   }
   // ex21
   public static void ex21() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Fatorial de qual inteiro?"));
      JOptionPane.showMessageDialog(null, "O fatorial de " + nro + " � " + obj.fatRec(nro));
   }
   // ex22
   public static void ex22() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Qual termo de FIBONACCI?"));
      JOptionPane.showMessageDialog(null, "O " + nro + "o. termo de Fibonacci � " + obj.fibRec(nro));
   }
   // ex23
   public static void ex23() {
      int vet[] = {47, 18, 25, 10};
      JOptionPane.showMessageDialog(null, "Soma do vetor: " + obj.somaVetorRec(vet));
   }
   // ex24
   public static void ex24() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Informe o inteiro:"));
      String resp = "O n�mero " + nro;
      if (obj.ehPrimoRec(nro)) resp += " � PRIMO!";
      else                     resp += " N�O � PRIMO!";
      JOptionPane.showMessageDialog(null, resp);
   }
   // ex25
   public static void ex25() {
      int vet[] = {69, 51, 0, -71, 100, 33, 19};
      int proc = Integer.parseInt(JOptionPane.showInputDialog("Localizar qual n�mero?"));
      String resp = "O n�mero " + proc;
      int result = obj.linearRec(vet, proc);
      if (result == -1) resp += " n�o foi encontrado!";
      else              resp += " est� na posi��o " + result;
      JOptionPane.showMessageDialog(null, resp);
   }
   // ex26
   public static void ex26() {
      String resp;
      int nro1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o 1� inteiro:"));
      int nro2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o 2� inteiro:"));
      resp = "O MDC entre " + nro1 + " e " + nro2 + " � " + obj.mdcRec(nro1, nro2);
      JOptionPane.showMessageDialog(null, resp);
   }
  // ex27
   public static void ex27() {
      int b = Integer.parseInt(JOptionPane.showInputDialog("Informe a base:"));
      int e = Integer.parseInt(JOptionPane.showInputDialog("Informe o expoente:"));
      String resp = b + " elevado a " + e + " � " + obj.powRec(b, e);
      JOptionPane.showMessageDialog(null, resp);
   }
   // ex30
   public static void ex30() {
      int nro = Integer.parseInt(JOptionPane.showInputDialog("Informe o inteiro:"));
      String resp = "A soma da sequ�ncia � " + obj.seqRec(nro);
      JOptionPane.showMessageDialog(null, resp);
   }
 }