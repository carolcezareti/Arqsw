public class BinaryTree {
   // atributo
   private BTreeNode root;
   // construtor
   public BinaryTree() {
      this.root = null;
   }
   // insert
   public void insert(BTreeNode btnNew) {
      btnNew.setLeft(null);
      btnNew.setRight(null);
      insert(btnNew, root);
   }
   public void insert(BTreeNode btnNew, BTreeNode subTree) {
      if (subTree.isLeaf()) {
         if (btnNew.getElem() <= subTree.getElem()) insert(btnNew, subTree.getLeft());
         else                                       insert(btnNew, subTree.getRight());
      }
      else if (btnNew.getElem() <= subTree.getElem()) insert(btnNew, subTree.getLeft());
      else                                            insert(btnNew, subTree.getRight());
   }
   // atravessamentos
   // in Order
   public String inOrder() {
      return "";
   }
   // pre Order
   public String preOrder() {
      return "";
   }
   // pos Order
   public String posOrder() {
      return "";
   }
}