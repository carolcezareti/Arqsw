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
   public void insertFirst(SingleNode snNew) {
      snNew.setNext(snBegin);
      this.snBegin = snNew;
   }
   // insertLast
   public void insertLast(SingleNode snNew) {
      if (isEmpty()) insertFirst(snNew);
      else {
         snNew.setNext(null);
         SingleNode snWalk = this.snBegin;
         while (snWalk.getNext() != null) {
            snWalk = snWalk.getNext();
         }
         snWalk.setNext(snNew);
      }
   }
   // insertAt
   public void insertAt(SingleNode snNew, int pos) {
      if      (pos <= 0)        insertFirst(snNew);
      else if (pos >= size()-1) insertLast(snNew);
      else {
         int cont;
         SingleNode snWalk = this.snBegin;
         for (cont = 1; cont < pos; cont++) {
            snWalk = snWalk.getNext();
         }
         snNew.setNext(snWalk.getNext());
         snWalk.setNext(snNew);
      }
   }
   // removeFirst
   public SingleNode removeFirst() {
      SingleNode snDel = this.snBegin;
      if (!isEmpty()) this.snBegin = this.snBegin.getNext();
      return snDel;
   }
   // removeLast
   public SingleNode removeLast() {
      if (size() <= 1) return removeFirst();
      else {
         SingleNode snDel = this.snBegin, snWalk = null;
         while (snDel.getNext() != null) {
            snWalk = snDel;
            snDel  = snDel.getNext();
         }
         snWalk.setNext(null);
         return snDel;
      }
   }
   // removeAt
   public SingleNode removeAt(int pos) {
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
         return snDel;
      }
   }
   // show
   public String show() {
      String msg = "";
      if (isEmpty()) msg = "Lista vazia!";
      else {
         SingleNode snWalk = snBegin;
         while (snWalk != null) {
            msg += snWalk.getData() + "   ";
            snWalk = snWalk.getNext();
         }
      }
      return msg;
   }
}