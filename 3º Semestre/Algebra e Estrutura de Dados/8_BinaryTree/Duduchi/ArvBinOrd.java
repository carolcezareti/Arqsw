public class ArvBinOrd {
   // atributo
   private Node raiz;
   // construtor
   public ArvBinOrd() {
      raiz = null;
   }
   // incArv
   public void incArv(int elem) {
      raiz = incAux(raiz, elem);
   }
   // incAux (incArv recursivo)
   public Node incAux(Node raiz, int elem) {
      if (raiz == null) {
         raiz = new Node(elem);
      }
      else {
         if (elem < raiz.data) raiz.linke = incAux(raiz.linke, elem);
         else                  raiz.linkd = incAux(raiz.linkd, elem);
      }
      return raiz;
   }
   // atravessamento PRE ORDER
   public void preOrdem() {
      System.out.print("PreOrdem: [");
      preOrdemAux(raiz);
      System.out.println(" ]");
   }
   public void preOrdemAux(Node raiz) {
      if (raiz != null) {
         System.out.print(" " + raiz.data);
         preOrdemAux(raiz.linke);
         preOrdemAux(raiz.linkd);
      }
   }
   // atravessamento POS ORDER
   public void posOrdem() {
      System.out.print("PosOrdem: [");
      posOrdemAux(raiz);
      System.out.println(" ]");
   }
   public void posOrdemAux(Node raiz) {
      if (raiz != null) {
         posOrdemAux(raiz.linke);
         posOrdemAux(raiz.linkd);
         System.out.print(" " + raiz.data);
      }
   }
   // atravessamento IN ORDER
   public void inOrdem() {
      System.out.print("InOrdem: [");
      inOrdemAux(raiz);
      System.out.println(" ]");
   }
   public void inOrdemAux(Node raiz) {
      if (raiz != null) {
         inOrdemAux(raiz.linke);
         System.out.print(" " + raiz.data);
         inOrdemAux(raiz.linkd);
      }
   }
   // atravessamento INVERSO ORDER
   public void inversoOrdem() {
      System.out.print("Inverso: [");
      inversoOrdemAux(raiz);
      System.out.println(" ]");
   }
   public void inversoOrdemAux(Node raiz) {
      if (raiz != null) {
         inversoOrdemAux(raiz.linkd);
         System.out.print(" " + raiz.data);
         inversoOrdemAux(raiz.linke);
      }
   }
   // busca elemento
   public boolean BuscaArv(int elem) {
      return BuscaAux(raiz, elem);
   }
   public boolean BuscaAux(Node raiz, int elem) {
      if (raiz != null) {
         if      (raiz.data > elem) return BuscaAux (raiz.linke, elem);
         else if (raiz.data < elem) return BuscaAux (raiz.linkd, elem);
         else                       return true;
      }
      return false;
   }
   // excluir elemento da árvore
   public void excluiArv (int elem) {
      raiz = excluiAux(raiz, elem);
   }
   public Node excluiAux(Node raiz, int elem) {
      if (raiz != null) {
         if      (raiz.data > elem) raiz.linke = excluiAux (raiz.linke, elem);
         else if (raiz.data < elem) raiz.linkd = excluiAux (raiz.linkd, elem);
         else {
            if      (raiz.linke == null && raiz.linkd == null) return null;
            else if (raiz.linke == null && raiz.linkd != null) {
               raiz = raiz.linke;
               return raiz;
            }
            else if (raiz.linke != null && raiz.linkd == null) {
               raiz = raiz.linkd;
               return raiz;
            }
            else {
               Node aux = raiz.linke;
               while (aux.linkd != null) { 
                  aux = aux.linkd;
               }
               raiz.data = aux.data;
               raiz.linke = excluiAux(raiz.linke, raiz.data);
               return raiz;
            }
         }
      }
      return raiz;
   }
   // altura da árvore
   public int altura () {
      return altura(raiz);
   }
   public int altura (Node raiz) {
      if (raiz == null) return 0; // altura da árvore vazia
      else {
         int he = altura(raiz.linke);
         int hd = altura(raiz.linkd);
         if (he < hd) return hd + 1;
         else         return he + 1;
      }
   }
}