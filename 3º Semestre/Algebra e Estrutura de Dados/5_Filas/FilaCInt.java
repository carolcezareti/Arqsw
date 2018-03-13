public class FilaCInt {
   // atributos
   private int     vet[];
   private int     ini;
   private int     fim;
   private boolean queueFull;
   // construtor
   public FilaCInt(int qtde) {
      vet       = new int[qtde];
      ini       = 0 ;
      fim       = 0;
      queueFull = false;
   }
   // reset
   public void reset() {
      ini       = 0 ;
      fim       = 0;
      queueFull = false;
   }
   // isEmpty
   public boolean isEmpty() {
      if (size() == 0) return true;
      else             return false;
   }
   // isFull
   public boolean isFull() {
      if (size() == vet.length) return true;
      else                      return false;
   }
   // size
   public int size() {
      if (fim >= ini && !queueFull) return fim - ini;
      else                          return fim - ini + vet.length;
   }
   // front
   public int front() {
      return vet[ini];
   }
   // enQueue
   public boolean enQueue(int elem) {
      if (isFull()) return false;
      else {
         vet[fim++] = elem;
         if (fim == vet.length) fim       = 0;
         if (fim == ini)        queueFull = true;
         return true;
      }
   }
   // deQueue
   public int deQueue() {
      int ret = vet[ini++];
      if (ini == vet.length) ini = 0;
      queueFull = false;
      return ret;
   }
   // show
   public String show() {
      String msg = "";
      int    i   = ini;
      if (isEmpty()) msg = "Fila vazia!";
      else {
         do {
            msg += vet[i++] + " |  ";
            if (i == vet.length) i = 0;
         } while(i != fim);
      }
      return msg;
   }
}