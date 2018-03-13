import javax.swing.JOptionPane;
public class Testando {
   // main
   public static void main(String args[]) {
      // objeto e vari�veis
      Buscas obj           = new Buscas();
      int    desordenado[] = new int[500];
      int    ordenado[]    = new int[500];
      int    i, nroDig, resLinear, resBinaria, resLinRec, resBinRec;
      String mens = "";
      // gerar elementos rand�micos no vetor
      fillArray(desordenado, 1000);
      for (i = 0; i < desordenado.length; i++) {
         ordenado[i] = desordenado[i];
      }
      // ordena vetor para busca bin�ria
      bubbleSort(ordenado);
      // exibir vetores
      System.out.println("\nDESORDENADO\n-----------\n" + showArray(desordenado));
      System.out.println("\nORDENADO\n--------\n"       + showArray(ordenado));
      // solicita n�mero a ser procurado
      nroDig = Integer.parseInt( JOptionPane.showInputDialog("Qual n�mero devo procurar?") );
      mens   = "Resultado das buscas para o n�mero " + nroDig;
      //busca linear iterativo
      resLinear = obj.linear(desordenado, nroDig);
      if (resLinear == -1) mens += "\n\nLINEAR ITERATIVO --> N�O FOI ENCONTRADO!";
      else                 mens += "\n\nLINEAR ITERATIVO --> FOI ENCONTRADO na posi��o " + resLinear;
      //busca linear recursiva
      resLinRec = obj.linearRec(desordenado, nroDig);
      if (resLinRec == -1) mens += "\n\nLINEAR RECURSIVO --> N�O FOI ENCONTRADO!";
      else                 mens += "\n\nLINEAR RECURSIVO --> FOI ENCONTRADO na posi��o " + resLinRec;
      //busca bin�ria iterativa
      resBinaria = obj.binaria(ordenado, nroDig);
      if (resBinaria == -1) mens += "\n\nBIN�RIA ITERATIVA --> N�O FOI ENCONTRADO!";
      else                  mens += "\n\nBIN�RIA ITERATIVA --> FOI ENCONTRADO na posi��o " + resBinaria;
      //busca bin�ria recursiva
      resBinRec = obj.binariaRec(ordenado, nroDig);
      if (resBinRec == -1) mens += "\n\nBIN�RIA RECURSIVA --> N�O FOI ENCONTRADO!";
      else                 mens += "\n\nBIN�RIA RECURSIVA --> FOI ENCONTRADO na posi��o " + resBinRec;
      // exibe mensagem final
      JOptionPane.showMessageDialog(null, mens);
      // fim do programa
      System.exit(0);
   }
   // fillArray
   public static void fillArray(int v[], int range) {
      int i;
      for (i = 0; i < v.length; i++) {
         v[i] = (int)(Math.random() * range);
      }
   }
   // bubbleSort
   public static void bubbleSort(int v[]) {
      int ini, fim, aux;
      for (ini = 0; ini < v.length - 1; ini++) {
         for (fim = v.length - 1; fim > ini; fim--) {
            if (v[fim] < v[fim-1]) {
               aux      = v[fim];
               v[fim]   = v[fim-1];
               v[fim-1] = aux;
            }
         }
      }
   }
   // showArray
   public static String showArray(int v[]) {
      int    i;
      String ret = "";
      for (i = 0; i < v.length; i++) {
         ret += "\n[" + i + "]: " + v[i];
      }
      return ret;
   }
}