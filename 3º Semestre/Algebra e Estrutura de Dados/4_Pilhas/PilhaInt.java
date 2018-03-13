public class PilhaInt {
   // atributos
   private int vet[];
   private int topo;
   // construtor
   public PilhaInt(int tam) {
      vet  = new int[tam];
      topo = 0;
   }
   // métodos padrão
   public int size() { return topo; }
   public int top()  { return vet[topo-1]; }
   public int pop()  { return vet[--topo]; }
   public boolean push(int elem) {
      if (isFull()) return false;
      else {
         vet[topo++] = elem;
         return true;
      }
   }
   // isFull
   public boolean isFull() {
      if (size() == vet.length) return true;
      else                      return false;
   }
   // isEmpty
   public boolean isEmpty() {
      if (size() == 0) return true;
      else             return false;
   }
   // reset
   public void reset() {
      topo = 0;
   }
   // show
   public String show() {
      String ret = "";
      int    i   = topo - 1;
      if (isEmpty()) ret = "Pilha vazia!";
      else {
         while (i >= 0) ret += "\n" + vet[i--];
      }
      return ret;
   }
}