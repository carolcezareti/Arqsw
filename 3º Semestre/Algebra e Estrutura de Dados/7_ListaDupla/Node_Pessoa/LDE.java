/*
   +-------------------------------+
   |              LDE              |
   +-------------------------------+
   | - dnBegin: NoPessoa = null    |
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
public class LDE {
   // atributos
   private NoPessoa dnBegin;
   // construtor
   public LDE() {
      dnBegin = null;
   }
   // size
   public int size() {
      int      qtde  = 0;
      NoPessoa dnAux = dnBegin;
      while (dnAux != null) {
         qtde++;
         dnAux = dnAux.getNext();
      }
      return qtde;
   }
   // show
   public String show() {
      String mens = "Sexo  Idade  Nome\n====  =====  =======================================\n";
      NoPessoa dnAux = dnBegin;
      while (dnAux != null) {
         mens += dnAux.getElem().getSexo() + "     " + dnAux.getElem().getIdade() + "  " + dnAux.getElem().getNome() + "\n";
         dnAux = dnAux.getNext();
      }
      return mens;
   }
   // metodo get
   public Pessoa get(int pos) {
      if (size() == 0) return null;
      int      cont  = 0;
      NoPessoa dnAux = dnBegin;
      while (dnAux != null && cont < pos) {
         dnAux = dnAux.getNext();
         cont++;
      }
      return dnAux.getElem();
   }
   // insertFirst
   public void insertFirst(Pessoa p) {
      NoPessoa dnNew = new NoPessoa(p, null, dnBegin);
      if (size() != 0) dnBegin.setPrev(dnNew);
      dnBegin = dnNew;
   }
   // insertLast
   public void insertLast(Pessoa p) {
      if (size() == 0) insertFirst(p);
      else {
         NoPessoa dnNew = new NoPessoa(p, null, null);
         NoPessoa dnAux = dnBegin;
         while (dnAux.getNext() != null) {
            dnAux = dnAux.getNext();
         }
         dnAux.setNext(dnNew);
         dnNew.setPrev(dnAux);
      }
   }
   // insertAt
   public void insertAt(Pessoa p, int pos) {
      if      (pos <= 0)      insertFirst(p);
      else if (pos >= size()) insertLast(p);
      else {
         NoPessoa dnNew = new NoPessoa(p, null, null);
         NoPessoa dnAux = dnBegin;
         for (int i = 0; i < pos - 1; i++) {
            dnAux = dnAux.getNext();
         }
         dnAux.getNext().setPrev(dnNew);
         dnNew.setNext(dnAux.getNext());
         dnNew.setPrev(dnAux);
         dnAux.setNext(dnNew);
      }
   }
   // removeFirst
   public Pessoa removeFirst() {
      if (size() == 0) return null;
      else {
         NoPessoa dnDel = dnBegin;
         dnBegin = dnBegin.getNext();
         if (dnBegin != null) dnBegin.setPrev(null);
         return dnDel.getElem();
      }
   }
   // removeLast
   public Pessoa removeLast() {
      if (size() == 0) return null;
      else {
         NoPessoa dnDel = dnBegin;
         NoPessoa dnAux = null;
         while (dnDel.getNext() != null) {
            dnAux = dnDel;
            dnDel = dnDel.getNext();
         }
         dnAux.setNext(null);
         return dnDel.getElem();
      }
   }
   // removeAt
   public Pessoa removeAt(int pos) {
      if      (pos <= 0)          return removeFirst();
      else if (pos >= size() - 1) return removeLast();
      else {
         NoPessoa dnDel = dnBegin;
         NoPessoa dnAux = null;
         for (int i = 0; i < pos; i++) {
            dnAux = dnDel;
            dnDel = dnDel.getNext();
         }
         dnDel.getNext().setPrev(dnAux);
         dnAux.setNext(dnDel.getNext());
         return dnDel.getElem();
      }
   }
}