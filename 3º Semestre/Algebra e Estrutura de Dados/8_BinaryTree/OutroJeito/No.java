public class No {	
    // atributos
    public int dado;
    public No  pai;
    public No  esquerda;
    public No  direita;
    // antecessor
    public No antecessor () {
        No n   = esquerda;
        No ant = esquerda;
        while (n != null) {
            ant = n;
            n   = n.direita;
        }
        return ant;
    }
    // sucessor
    public No sucessor () {
        No n   = direita;
        No suc = direita;
        while (n != null) {
            suc = n;
            n   = n.esquerda;
        }
        return suc;
    }
    // numeroFilhos
    public int numeroFilhos() {
        if      (esquerda == null && direita == null) return 0;
        else if (esquerda != null && direita != null) return 2;
        else                                          return 1;
    }
    // toString
    public String toString () {
        return "<" + dado + ">";
    }
}