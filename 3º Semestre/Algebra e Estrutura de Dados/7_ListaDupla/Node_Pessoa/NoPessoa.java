/*
   +---------------------------+
   |         NoPessoa          |
   +---------------------------+
   | - prev: NoPessoa = null   |
   | - elem: Pessoa   = null   |
   | - next: NoPessoa = null   |
   +---------------------------+
   | + getElem(): Pessoa       |
   | + getNext(): NoPessoa     |
   | + setElem(Pessoa)  : void |
   | + setNext(NoPessoa): void |
   +---------------------------+
*/
public class NoPessoa {
   // atributos
   private Pessoa   elem;
   private NoPessoa prev;
   private NoPessoa next;
   // construtores
   public NoPessoa() {
      this(new Pessoa(), null, null);
   }
   public NoPessoa(Pessoa e, NoPessoa p, NoPessoa n) {
      setElem(e);
      setPrev(p);
      setNext(n);
   }
   // metodos de acesso - get
   public Pessoa   getElem() { return this.elem; }
   public NoPessoa getNext() { return this.next; }
   public NoPessoa getPrev() { return this.prev; }
   // metodos de modificacao - set
   public void setElem(Pessoa   p) { this.elem = p; }
   public void setNext(NoPessoa n) { this.next = n; }
   public void setPrev(NoPessoa p) { this.prev = p; }
}