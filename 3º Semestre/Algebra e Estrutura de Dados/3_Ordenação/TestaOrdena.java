import javax.swing.JOptionPane;
public class TestaOrdena {
   // main
   public static void main(String args[]) {
      // objetos e variáveis
      Ordena obj  = new Ordena();
      String mens = "";
      int    vB[] = new int[50];
      int    vS[] = new int[vB.length];
      int    vI[] = new int[vB.length];
      int    vQ[] = new int[vB.length];
      int    vM[] = new int[vB.length];
      int    i;
      long   startB, tempoB;
      long   startS, tempoS;
      long   startI, tempoI;
      long   startQ, tempoQ;
      long   startM, tempoM;
      // gera elementos randômicos no vetor
      fillArray(vB, vB.length);
      for (i = 0; i < vB.length; i++) {
         vS[i] = vB[i];
         vI[i] = vB[i];
         vQ[i] = vB[i];
         vM[i] = vB[i];
      }
      // BUBBLESORT
      System.out.println("Bubble...");
      startB = System.currentTimeMillis();
      obj.bubble(vB);
      tempoB = System.currentTimeMillis() - startB;
      // SELECTIONSORT
      System.out.println("Selection...");
      startS = System.currentTimeMillis();
      obj.selectionRec(vS);
      tempoS = System.currentTimeMillis() - startS;
      // INSERTIONSORT
      System.out.println("Insertion...");
      startI = System.currentTimeMillis();
      obj.insertion(vI);
      tempoI = System.currentTimeMillis() - startI;
      // QUICKSORT
      System.out.println("Quick...");
      startQ = System.currentTimeMillis();
      obj.quick(vQ);
      tempoQ = System.currentTimeMillis() - startQ;
      // MERGESORT
      System.out.println("Merge...");
      startM = System.currentTimeMillis();
      obj.merge(vM);
      tempoM = System.currentTimeMillis() - startM;
      // exibe resposta
      mens = "Ordenando " + vB.length  + " posições:\n" +
             "\nBubbleSort: "    + tempoB + " milissegundos." +
             "\nSelectionSort: " + tempoS + " milissegundos." +
             "\nInsertionSort: " + tempoI + " milissegundos." +
             "\nQuickSort: "     + tempoQ + " milissegundos." +
             "\nMergeSort: "     + tempoM + " milissegundos.";
      JOptionPane.showMessageDialog(null, mens);
      
      System.out.println(showArray(vS));
      
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