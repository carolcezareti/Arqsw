public class Recursividade {
   // ex 21 - fatorial
   public double fatRec(int n) {
      if      (n <  0) return 0;
      else if (n == 0) return 1;
      else             return n * fatRec(n-1);
   }
   // ex 22 - Fibonacci
   public double fibRec(int termo) {
      if      (termo <= 0) return 0;
      else if (termo <= 2) return 1;
      else                 return fibRec(termo-1) + fibRec(termo-2);
   }
   // ex 24 - É primo?
   public boolean ehPrimoRec(int nro) {
      return ehPrimoRec(nro, 2);
   }
   private boolean ehPrimoRec(int nro, int div) {
      if      (nro <= 1)        return false;
      else if (nro == div)      return true;
      else if (nro %  div == 0) return false;
      else                      return ehPrimoRec(nro, div+1);
   }
}