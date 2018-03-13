public class SLL {
   // atributo
   SingleNode snBegin;
   // construtor
   public SLL() {
      this.snBegin = null;
   }
   // size
   public int size() {
      int        qtde   = 0;
      SingleNode snWalk = this.snBegin;
      while (snWalk != null) {
         qtde++;
         snWalk = snWalk.getNext();
      }
      return qtde;
   }
   // isEmpty
   public boolean isEmpty() {
      if (size() == 0) return true;
      else             return false;
   }
   // insertFirst
   public void insertFirst(int elem) {
      SingleNode snNew = new SingleNode(elem, this.snBegin);
      this.snBegin = snNew;
   }
   // insertLast
   public void insertLast(int elem) {
      if (isEmpty()) insertFirst(elem);
      else {
         SingleNode snNew  = new SingleNode(elem, null);
         SingleNode snWalk = this.snBegin;
         while (snWalk.getNext() != null) {
            snWalk = snWalk.getNext();
         }
         snWalk.setNext(snNew);
      }
   }
   // insertAt
   public void insertAt(int elem, int pos) {
      if      (pos <= 0)        insertFirst(elem);
      else if (pos >= size()-1) insertLast(elem);
      else {
         int cont;
         SingleNode snWalk = this.snBegin;
         SingleNode snNew  = new SingleNode(elem, null);
         for (cont = 1; cont < pos; cont++) {
            snWalk = snWalk.getNext();
         }
         snNew.setNext(snWalk.getNext());
         snWalk.setNext(snNew);
      }
   }
   // removeFirst
   public int removeFirst() {
      int ret = this.snBegin.getElem();
      this.snBegin = this.snBegin.getNext();
      return ret;
   }
   // removeLast
   public int removeLast() {
      if (size() == 1) return removeFirst();
      else {
         SingleNode snDel = this.snBegin, snWalk = null;
         while (snDel.getNext() != null) {
            snWalk = snDel;
            snDel  = snDel.getNext();
         }
         snWalk.setNext(null);
         return snDel.getElem();
      }
   }
   // removeAt
   public int removeAt(int pos) {
      if      (pos <= 0)        return removeFirst();
      else if (pos >= size()-1) return removeLast();
      else {
         int        cont;
         SingleNode snDel = this.snBegin, snWalk = null;
         for (cont = 0; cont < pos; cont++) {
            snWalk = snDel;
            snDel  = snDel.getNext();
         }
         snWalk.setNext(snDel.getNext());
         return snDel.getElem();
      }
   }
}