public class Ordena {
   // bubbleSort
   public void bubble(int v[]) {
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
   // selectionSort
   public void selection(int v[]) {
      int iA, iB, iC, iT;
      for (iA = 0; iA < v.length - 1; iA++) {
         iC = iA;
         iT = v[iA];
         for (iB = iA + 1; iB < v.length; iB++) {
            if (v[iB] < iT) {
               iC = iB;
               iT = v[iB];
            }
         }
         v[iC] = v[iA];
         v[iA] = iT;
      }
   }
   // insertionSort
   public void insertion(int v[]) {
      int iA, iB, iT;
      for (iA = 1; iA < v.length; iA++) {
         iT = v[iA];
         iB = iA - 1;
         while (iB >= 0 && iT < v[iB]) {
            v[iB + 1] = v[iB];
            iB--;
         }
         v[iB+ 1] = iT;
      }
   }
   // quickSort
   public void quick(int v[]) {
      quick(v, 0, v.length-1);
   }
   private void quick(int v[], int iBaixo, int iAlto) {
      int iP, iB, iA, iPivot;
      iB     = iBaixo;
      iA     = iAlto;
      iPivot = v[iBaixo];
      while (iBaixo < iAlto) {
         while ((v[iAlto]  >= iPivot) && (iBaixo < iAlto)) iAlto--;
         if    (iBaixo     != iAlto)                       v[iBaixo++] = v[iAlto];
         while ((v[iBaixo] <= iPivot) && (iBaixo < iAlto)) iBaixo++;
         if    (iBaixo     != iAlto)                       v[iAlto--] = v[iBaixo];
      }
      v[iBaixo] = iPivot;
      iP        = iBaixo;
      if (iB < iP) quick(v, iB,     iP - 1);
      if (iA > iP) quick(v, iP + 1, iA);
   }
   // mergeSort
   public void merge(int v[]) {
      merge(v, 0, v.length - 1);
   }
   private void merge(int[] vet, int ini, int fim) {
      int meio, A[], B[], i, j, k;
   	if (fim <= ini) return;
	   meio = (ini + fim) / 2;
   	merge(vet, ini,      meio);
   	merge(vet, meio + 1, fim);
   	A = new int[meio - ini + 1];
   	B = new int[fim - meio];
   	for (i = 0; i <= meio - ini;     i++) A[i] = vet[ini + i];
   	for (i = 0; i <= fim - meio - 1; i++) B[i] = vet[meio + 1 + i];
	   i = 0;
	   j = 0;
	   for (k = ini; k <= fim; k++) {
         if (i < A.length && j < B.length) {
   			if (A[i] < B[j]) vet[k] = A[i++];
            else             vet[k] = B[j++];
		   }
         else if (i < A.length) vet[k] = A[i++];
         else if (j < B.length) vet[k] = B[j++];
	   }
   }
   // selectionSort RECURSIVO
   public void selectionRec(int v[]) {
      selectionRec(v, 0);
   }
   private void selectionRec(int v[], int ini) {
      int iMenor, iAtual, troca;
      if (ini >= v.length - 1) return;
      iMenor    = menorVetorRec(v, ini, ini+1);
      troca     = v[ini];
      v[ini]    = v[iMenor];
      v[iMenor] = troca;
      selectionRec(v, ini + 1);
   }
   // localiza o menor elemento no vetor
   private int menorVetorRec(int v[], int i, int me) {
      if      (i == v.length) return me;
      else if (v[i] < v[me])  return menorVetorRec(v, i+1, i);
      else                    return menorVetorRec(v, i+1, me);
   }
}