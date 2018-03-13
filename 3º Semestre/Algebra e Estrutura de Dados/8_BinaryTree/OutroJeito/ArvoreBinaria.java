public class ArvoreBinaria {	
    // atributo
    private No raiz;
    // construtor
    public ArvoreBinaria () {	
        raiz = null;
    }
    // insere
    public void insere (int dado) {	
        No novo       = new No();
        novo.dado     = dado;
        novo.esquerda = novo.direita = null;
        if(raiz == null) {
            novo.pai  = null;
            raiz      = novo;
        }
        else {
            No      aux   = raiz;
            No      pai   = null;
            boolean noEsq = false;
            while (aux != null) {
                if      (aux.dado == dado) return; //o "dado" ja existe
                else if (aux.dado <  dado) {
                  pai   = aux;
                  aux   = aux.direita; //passo a procurar aa direita
                  noEsq = false;
                }
                else {
                  pai   = aux;
                  aux   = aux.esquerda; //passo a procurar aa esquerda
                  noEsq = true;
                }
            }
            if (noEsq) pai.esquerda = novo;
            else       pai.direita  = novo;
            novo.pai = pai;
         }
    }
    // remove
    public void remove (No n) {
        if (raiz == null) throw new RuntimeException ("Lista vazia.");
        else {
            int numFilhos = n.numeroFilhos();
            if (numFilhos == 0) { // folha
                if (n == raiz) raiz = null;
                else {
                  if (n.pai.dado > n.dado) n.pai.esquerda = null;
                  else                     n.pai.direita  = null;
               }
            }
            else if (numFilhos == 1) { // tem 1 filho
               No filho;
               if (n.esquerda != null) filho = n.esquerda;
               else                    filho = n.direita;
               if (n == raiz) raiz = filho;
               else {
                  if (n.pai.dado > n.dado) n.pai.esquerda = filho;
                  else                     n.pai.direita  = filho;
               }
            }
            else { // tem 2 filhos
               No substituto = n.antecessor();
               remove(substituto);
               n.dado = substituto.dado;
            }
         }
    }
    // contem
    public boolean contem (int dado) {
        No aux = raiz;
        while (aux != null) {
            if      (aux.dado == dado) return true;        //se encontrei, retorno true
            else if (aux.dado <  dado) aux = aux.direita;  //passo a procurar aa direita
            else                       aux = aux.esquerda; //passo a procurar aa esquerda
         }
         return false; //se chegou aqui eh porque nao existe
    }
    // procurar
    public No procurar (int dado) {
         No aux = raiz;
         while (aux != null) {	
            if      (aux.dado == dado) return aux;         //se encontrei, retorno a referencia
            else if (aux.dado <  dado) aux = aux.direita;  //passo a procurar aa direita
            else                       aux = aux.esquerda; //passo a procurar aa esquerda
         }
         return null; //se chegou aqui eh porque nao existe
    }
    // espacos
    private String espacos (int n) {
        String s = "";
        for(int i=0; i<n; i++) s += "      ";
        return s;
    }
    // toString
    public String toString () {	
        return mostra(raiz, 1); 
    }
    // mostra
    private String mostra(No n, int nivel) {
        if (n == null) return "";
        else           return mostra(n.direita, nivel + 1) + "\n" +
                              espacos(nivel) + n.dado + "\n" +
                              mostra(n.esquerda, nivel + 1);
    }
    // main
    public static void main (String [] args) {	
         System.out.println ("Arvore Binaria ab (de numeros inteiros)");
         ArvoreBinaria ab = new ArvoreBinaria ();

         ab.insere(5);
         ab.insere(7);
         ab.insere(3);
         ab.insere(2);
         ab.insere(1);
         ab.insere(9);
         ab.insere(8);
         ab.insere(4);
         ab.insere(6);
      
         System.out.println (ab);
      
         System.out.println ("\nRemovendo o 5 ......");
         ab.remove(ab.procurar(5));
         System.out.println (ab);
      
         System.out.println ("\nRemovendo o 8 ......");
         ab.remove(ab.procurar(8));
         System.out.println (ab);
      
         System.out.println ("\nRemovendo o 3 ......");
         ab.remove(ab.procurar(3));
         System.out.println (ab);
      
         System.out.println("O antecessor de " + ab.raiz + " eh " + (ab.raiz).antecessor() + " e o sucessor eh " + (ab.raiz).sucessor());
         
         System.exit(0);
    }
}