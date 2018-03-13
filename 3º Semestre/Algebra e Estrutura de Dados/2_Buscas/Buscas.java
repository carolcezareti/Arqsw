public class Buscas {
	// linear iterativa
	public int linear(int v[], int find) {
		int i;
		for (i = 0; i < v.length; i++) {
			if (v[i] == find) return i;
		}
		return -1;
	}
	// binária iterativa
	public int binaria(int v[], int find) {
		int ini = 0, meio, fim = v.length -1;
		do {
			meio = (ini + fim) / 2;
			if      (v[meio] > find) fim = meio - 1;
			else if (v[meio] < find) ini = meio + 1;
			else                     return meio;
		} while (ini <= fim);
		return -1;
	}
	// linear recursiva
	public int linearRec(int v[], int find) {
		return linearRec(v, find, 0);
	}
	private int linearRec(int v[], int find, int i) {
		if      (i == v.length) return -1;
		else if (v[i] == find)  return i;
		else                    return linearRec(v, find, i+1);
	}
	// binária recursiva
	public int binariaRec(int v[], int find) {
		return binariaRec(v, find, 0, v.length-1);
	}
	private int binariaRec(int v[], int find, int ini, int fim) {
		int meio = (ini + fim) / 2;
		if      (ini > fim)      return -1;
		else if (v[meio] > find) return binariaRec(v, find, ini,    meio-1);
		else if (v[meio] < find) return binariaRec(v, find, meio+1, fim);
		else                     return meio;
	}
}