public class DoubleNode {
   // atributos
   DoubleNode prev;
   int        elem;
   DoubleNode next;
   // construtores
   public DoubleNode() {
      this(null, 0, null);
   }
   public DoubleNode(DoubleNode prev, int elem, DoubleNode next) {
      setPrev(prev);
      setElem(elem);
      setNext(next);
   }
   // get´s
   public DoubleNode getPrev() { return this.prev; }
   public int        getElem() { return this.elem; }
   public DoubleNode getNext() { return this.next; }
   // set´s
   public void setPrev(DoubleNode prev) { this.prev = prev; }
   public void setElem(int        elem) { this.elem = elem; }
   public void setNext(DoubleNode next) { this.next = next; }
}