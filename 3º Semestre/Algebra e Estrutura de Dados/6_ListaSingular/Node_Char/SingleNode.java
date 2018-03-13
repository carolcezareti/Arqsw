public class SingleNode {
   // atributos
   private char       data;
   private SingleNode next;
   // construtores
   public SingleNode() {
      this(' ', null);
   }
   public SingleNode(char data, SingleNode next) {
      setData(data);
      setNext(next);
   }
   // get´s
   public char       getData() { return this.data; }
   public SingleNode getNext() { return this.next; }
   // set´s
   public void setData(char       data) { this.data = data; }
   public void setNext(SingleNode next) { this.next = next; }
}