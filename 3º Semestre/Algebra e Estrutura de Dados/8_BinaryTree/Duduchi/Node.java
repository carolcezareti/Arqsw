public class Node {
   // atributos
   public int  data;
   public Node linke, linkd;
   // construtores
   public Node() {
      this(null, 0, null);
   }
   public Node(int data) {
      this(null, data, null);
   }
   public Node(Node esq, int data, Node dir) {
      setEsq(esq);
      setData(data);
      setDir(dir);
   }
   // set
   public void setEsq (Node esq)  { this.linke = esq;  }
   public void setData(int  data) { this.data  = data; }
   public void setDir (Node dir)  { this.linkd = dir;  }
}