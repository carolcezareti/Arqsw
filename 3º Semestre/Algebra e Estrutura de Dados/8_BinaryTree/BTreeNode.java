public class BTreeNode {
   // atributos
   private int       elem;
   private BTreeNode left;
   private BTreeNode right;
   // construtores
   public BTreeNode() {
      this(0, null, null);
   }
   public BTreeNode(int e, BTreeNode l, BTreeNode r) {
      setElem(e);
      setLeft(l);
      setRight(r);
   }
   // set's
   public void setElem (int e)       { this.elem  = e; }
   public void setLeft (BTreeNode l) { this.left  = l; }
   public void setRight(BTreeNode r) { this.right = r; }
   // get's
   public int       getElem()  { return this.elem;  }
   public BTreeNode getLeft()  { return this.left;  }
   public BTreeNode getRight() { return this.right; }
   // isLeaf
   public boolean isLeaf() {
      if (getLeft() == null  && getRight() == null) return true;
      else                                          return false;
   }
}