import javax.swing.JOptionPane;
public class Testando {
   // main
   public static void main(String args[]) {
      // objeto e variáveis
      Buscas obj           = new Buscas();
      int    desordenado[] = new int[500];
      int    ordenado[]    = new int[500];
      int    i, nroDig, resLinear, resBinaria, resLinRec, resBinRec;
      String mens = "";
      // gerar elementos randômicos no vetor
      fillArray(desordenado, 1000);
      for (i = 0; i < desordenado.length; i++) {
         ordenado[i] = desordenado[i];
      }
      // ordena vetor para busca binária
      bubbleSort(ordenado);
      // exibir vetores
      System.out.println("\nDESORDENADO\n-----------\n" + showArray(desordenado));
      System.out.println("\nORDENADO\n--------\n"       + showArray(ordenado));
      // solicita número a ser procurado
      nroDig = Integer.parseInt( JOptionPane.showInputDialog("Qual número devo procurar?") );
      mens   = "Resultado das buscas para o número " + nroDig;
      //busca linear iterativo
      resLinear = obj.linear(desordenado, nroDig);
      if (resLinear == -1) mens += "\n\nLINEAR ITERATIVO --> NÃO FOI ENCONTRADO!";
      else                 mens += "\n\nLINEAR ITERATIVO --> FOI ENCONTRADO na posição " + resLinear;
      //busca linear recursiva
      resLinRec = obj.linearRec(desordenado, nroDig);
      if (resLinRec == -1) mens += "\n\nLINEAR RECURSIVO --> NÃO FOI ENCONTRADO!";
      else                 mens += "\n\nLINEAR RECURSIVO --> FOI ENCONTRADO na posição " + resLinRec;
      //busca binária iterativa
      resBinaria = obj.binaria(ordenado, nroDig);
      if (resBinaria == -1) mens += "\n\nBINÁRIA ITERATIVA --> NÃO FOI ENCONTRADO!";
      else                  mens += "\n\nBINÁRIA ITERATIVA --> FOI ENCONTRADO na posição " + resBinaria;
      //busca binária recursiva
      resBinRec = obj.binariaRec(ordenado, nroDig);
      if (resBinRec == -1) mens += "\n\nBINÁRIA RECURSIVA --> NÃO FOI ENCONTRADO!";
      else                 mens += "\n\nBINÁRIA RECURSIVA --> FOI ENCONTRADO na posição " + resBinRec;
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