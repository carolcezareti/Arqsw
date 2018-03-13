public class Node {
   // atributos
   private boolean lock;
   private String  data;
   private int     address;
   // construtor
   public Node() {
      this("", 0);
   }
   public Node(String data, int address) {
      setLock(false);
      setData(data);
      setAddress(address);
   }
   // kill
   public void kill(){
      setLock(false);
      setData("");
      setAddress(0);
   }
   // free
   public void free() {
      setLock(false);
   }
   // lock
   public void lock() {
      setLock(true);
   }
   // isLocked
   public boolean isLocked() {
      return getLock();
   }
   // toString
   public String toString() {
      return getData() + " - " + getAddress();
   }
   // set´s
   private void setLock   (boolean value) { this.lock    = value; }
   public  void setData   (String  value) { this.data    = value; }
   public  void setAddress(int     value) { this.address = value; }
   // get´s
   private boolean getLock()    { return this.lock; }
   public  String  getData()    { return this.data; }
   public  int     getAddress() { return this.address; }
}