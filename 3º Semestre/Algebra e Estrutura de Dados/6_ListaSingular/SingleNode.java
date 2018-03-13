public class SingleNode {
   // atributos
   int        elem;
   SingleNode next;
   // construtores
   public SingleNode() {
      this(0, null);
   }
   public SingleNode(int elem, SingleNode next) {
      setElem(elem);
      setNext(next);
   }
   // get´s
   public int        getElem() { return this.elem; }
   public SingleNode getNext() { return this.next; }
   // set´s
   public void setElem(int        elem) { this.elem = elem; }
   public void setNext(SingleNode next) { this.next = next; }
}