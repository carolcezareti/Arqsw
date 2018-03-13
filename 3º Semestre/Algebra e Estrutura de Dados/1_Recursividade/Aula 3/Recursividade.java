public class Recursividade {
   // ex 21 - fatorial
   public double fatRec(int n) {
      if      (n <  0) return 0;
      else if (n == 0) return 1;
      else             return n * fatRec(n-1);
   }
   // ex 22 - Fibonacci
   public int fibRec(int termo) {
      if      (termo <= 0) return 0;
      else if (termo <= 2) return 1;
      else                 return fibRec(termo-1) + fibRec(termo-2);
   }
   // ex23 - Soma Vetor
   public int somaVetorRec(int v[]) {
      return somaVetorRec(v, 0);
   }
   private int somaVetorRec(int v[], int i) {
      if (i == v.length) return 0;
      else               return v[i] + somaVetorRec(v, i + 1);
   }
   // ex24 - Números Primos
   public boolean ehPrimoRec(int nro) {
      return ehPrimoRec(nro, 2);
   }
   private boolean ehPrimoRec(int nro, int div) {
      if      (nro <= 1)       return false;
      else if (nro == div)     return true;
      else if (nro % div == 0) return false;
      else                     return ehPrimoRec(nro, div+1);
   }
   // ex25 - busca linear recursiva
   public int linearRec(int v[], int seek) {
      return linearRec(v, seek, 0);
   }
   private int linearRec(int v[], int seek, int i) {
      if      (i == v.length) return -1;
      else if (v[i] == seek)  return  i;
      else                    return linearRec(v, seek, i+1);
   }
   // ex26 - MDC
   public int mdcRec(int num, int div) {
      if      (div == 0)       return 0;
      else if (num % div == 0) return div;
      else                     return mdcRec(div, num % div);
   }
   // ex27 - potência entre dois inteiros
   public double powRec(int base, int expo) {
      if (expo < 0) return 1.0 / powRec2(base, -expo);
      else          return powRec2(base,  expo);
   }
   private int powRec2(int base, int expo) {
      if (expo == 0) return 1;
      else           return base * powRec2(base, expo - 1);
   }
   // ex30
   public double seqRec(int n) {
      if      (n <= 0) return 0;
      else if (n == 1) return 1;
      else             return 1 / Math.pow(2, n - 1) + seqRec(n - 1);
   }
}