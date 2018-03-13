/*
   +-------------------------------+
   |              LSE              |
   +-------------------------------+
   | - snBegin: NoPessoa = null    |
   +-------------------------------+
   | + size(): int                 |
   | + show(): String              |
   | + get(int): Pessoa            |
   | + insertFirst(Pessoa): void   |
   | + insertLast(Pessoa): void    |
   | + insertAt(Pessoa, int): void |
   | + removeFirst(): Pessoa       |
   | + removeLast(): Pessoa        |
   | + removeAt(int): Pessoa       |
   +-------------------------------+
*/
public class LSE {
   // atributos
   private NoPessoa snBegin;
   // construtor
   public LSE() {
      snBegin = null;
   }
   // size
   public int size() {
      int      qtde  = 0;
      NoPessoa snAux = snBegin;
      while (snAux != null) {
         qtde++;
         snAux = snAux.getNext();
      }
      return qtde;
   }
   // show
   public String show() {
      String mens = "Sexo  Idade  Nome\n====  =====  =======================================\n";
      NoPessoa snAux = snBegin;
      while (snAux != null) {
         mens += snAux.getElem().getSexo() + "     " + snAux.getElem().getIdade() + "  " + snAux.getElem().getNome() + "\n";
         snAux = snAux.getNext();
      }
      return mens;
   }
   // metodo get
   public Pessoa get(int pos) {
      if (size() == 0) return null;
      int      cont  = 0;
      NoPessoa snAux = snBegin;
      while (snAux != null && cont < pos) {
         snAux = snAux.getNext();
         cont++;
      }
      return snAux.getElem();
   }
   // insertFirst
   public void insertFirst(Pessoa p) {
      NoPessoa snNew = new NoPessoa(p, snBegin);
      snBegin = snNew;
   }
   // insertLast
   public void insertLast(Pessoa p) {
      if (size() == 0) insertFirst(p);
      else {
         NoPessoa snNew = new NoPessoa(p, null);
         NoPessoa snAux = snBegin;
         while (snAux.getNext() != null) {
            snAux = snAux.getNext();
         }
         snAux.setNext(snNew);
      }
   }
   // insertAt
   public void insertAt(Pessoa p, int pos) {
      if      (pos <= 0) insertFirst(p);
      else if (pos >= size()) insertLast(p);
      else {
         NoPessoa snNew = new NoPessoa(p, null);
         NoPessoa snAux = snBegin;
         for (int i = 0; i < pos - 1; i++) {
            snAux = snAux.getNext();
         }
         snNew.setNext(snAux.getNext());
         snAux.setNext(snNew);
      }
   }
   // removeFirst
   public Pessoa removeFirst() {
      if (size() == 0) return null;
      else {
         NoPessoa snDel = snBegin;
         snBegin = snBegin.getNext();
         return snDel.getElem();
      }
   }
   // removeLast
   public Pessoa removeLast() {
      if (size() == 0) return null;
      else {
         NoPessoa snDel = snBegin;
         NoPessoa snAux = null;
         while (snDel.getNext() != null) {
            snAux = snDel;
            snDel = snDel.getNext();
         }
         snAux.setNext(null);
         return snDel.getElem();
      }
   }
   // removeAt
   public Pessoa removeAt(int pos) {
      if      (pos <= 0)          return removeFirst();
      else if (pos >= size() - 1) return removeLast();
      else {
         NoPessoa snDel = snBegin;
         NoPessoa snAux = null;
         for (int i = 0; i < pos; i++) {
            snAux = snDel;
            snDel = snDel.getNext();
         }
         snAux.setNext(snDel.getNext());
         return snDel.getElem();
      }
   }
}