public class PilhaChar {
   // atributos
   private char vet[];
   private int  topo;
   // construtor
   public PilhaChar(int tam) {
      vet  = new char[tam];
      topo = 0;
   }
   // métodos padrão
   public int  size() { return topo; }
   public char top()  { return vet[topo-1]; }
   public char pop()  { return vet[--topo]; }
   public boolean push(char elem) {
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